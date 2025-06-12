import java.util.Scanner;

public class PoliceStation {
    private FirDAO firDAO = new FirDAO();
    private ComplainDAO complainDAO = new ComplainDAO();
    private StaffDAO staffDAO = new StaffDAO();

    public void home() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Police Station Management ===");
            System.out.println("1. Register FIR");
            System.out.println("2. Delete FIR");
            System.out.println("3. View FIR");
            System.out.println("4. Register Complain");
            System.out.println("5. Update Complain Status");
            System.out.println("6. View Complain");
            System.out.println("7. Add Staff");
            System.out.println("8. Remove Staff");
            System.out.println("9. View Staff");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> registerFir(input);
                case 2 -> deleteFir(input);
                case 3 -> viewFir(input);
                case 4 -> registerComplain(input);
                case 5 -> updateComplain(input);
                case 6 -> viewComplain(input);
                case 7 -> addStaff(input);
                case 8 -> deleteStaff(input);
                case 9 -> viewStaff(input);
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }
        input.close();
    }

    private void registerFir(Scanner input) {
        System.out.print("Name: "); String name = input.nextLine();
        System.out.print("CNIC: "); String cnic = input.nextLine();
        System.out.print("Date: "); String date = input.nextLine();
        System.out.print("Time: "); String time = input.nextLine();
        System.out.print("Location: "); String location = input.nextLine();
        System.out.print("Description: "); String desc = input.nextLine();
        firDAO.addFir(new Fir(name, cnic, date, time, location, desc));
    }

    private void deleteFir(Scanner input) {
        System.out.print("Enter FIR ID to delete: ");
        int id = input.nextInt();
        firDAO.deleteFir(id);
    }

    private void viewFir(Scanner input) {
        System.out.print("Enter FIR ID to view: ");
        int id = input.nextInt();
        Fir f = firDAO.getFirById(id);
        if (f != null) {
            System.out.printf("%d | %s | %s | %s | %s | %s | %s\n",
                f.getId(), f.getName(), f.getCnic(), f.getDate(), f.getTime(), f.getLocation(), f.getDescription());
        } else {
            System.out.println("FIR not found.");
        }
    }

    private void registerComplain(Scanner input) {
        System.out.print("Name: "); String name = input.nextLine();
        System.out.print("CNIC: "); String cnic = input.nextLine();
        System.out.print("Description: "); String desc = input.nextLine();
        complainDAO.addComplain(new Complain(name, cnic, desc));
    }

    private void updateComplain(Scanner input) {
        System.out.print("Enter CNIC to update status: ");
        String cnic = input.nextLine();
        complainDAO.updateStatus(cnic);
    }

    private void viewComplain(Scanner input) {
        System.out.print("Enter CNIC to view complain: ");
        String cnic = input.nextLine();
        Complain c = complainDAO.getComplainByCnic(cnic);
        if (c != null) {
            System.out.printf("%d | %s | %s | %s | Solved: %s\n",
                c.getId(), c.getName(), c.getCnic(), c.getDescription(), c.isSolved());
        } else {
            System.out.println("No complain found.");
        }
    }

    private void addStaff(Scanner input) {
        System.out.print("Name: "); String name = input.nextLine();
        System.out.print("Gender: "); String gender = input.nextLine();
        System.out.print("Role: "); String role = input.nextLine();
        staffDAO.addStaff(new Staff(name, gender, role));
    }

    private void deleteStaff(Scanner input) {
        System.out.print("Enter Staff ID to delete: ");
        int id = input.nextInt();
        staffDAO.deleteStaff(id);
    }

    private void viewStaff(Scanner input) {
        System.out.print("Enter Staff ID to view: ");
        int id = input.nextInt();
        Staff s = staffDAO.getStaffById(id);
        if (s != null) {
            System.out.printf("%d | %s | %s | %s\n", s.getId(), s.getName(), s.getGender(), s.getRole());
        } else {
            System.out.println("Staff not found.");
        }
    }
}