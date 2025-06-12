public class Staff {
    private int id;
    private String name, gender, role;

    public Staff(int id, String name, String gender, String role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
    }

    public Staff(String name, String gender, String role) {
        this(0, name, gender, role);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getRole() { return role; }
}
