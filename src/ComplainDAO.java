import java.sql.*;

public class ComplainDAO {
    private CitizenDAO citizenDAO = new CitizenDAO();

    public void addComplain(Complain c) {
        int citizenId = citizenDAO.getOrCreateCitizenId(c.getName(), c.getCnic());

        String sql = "INSERT INTO complains (citizen_id, description, is_solved) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, citizenId);
            stmt.setString(2, c.getDescription());
            stmt.setBoolean(3, c.isSolved());
            stmt.executeUpdate();
            System.out.println("Complain added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusByCnic(String cnic) {
        String sql = "UPDATE complains SET is_solved = TRUE WHERE citizen_id = (SELECT id FROM citizens WHERE cnic = ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnic);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Complain status updated to solved.");
            } else {
                System.out.println("Complain not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Complain getComplainByCnic(String cnic) {
        Citizen citizen = citizenDAO.getCitizenByCnic(cnic);
        if (citizen == null)
            return null;

        String sql = "SELECT * FROM complains WHERE citizen_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, citizen.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Complain(
                        rs.getInt("id"),
                        citizen.getName(),
                        citizen.getCnic(),
                        rs.getString("description"),
                        rs.getBoolean("is_solved"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
