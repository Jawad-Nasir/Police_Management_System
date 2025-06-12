import java.sql.*;

public class ComplainDAO {
    public void addComplain(Complain c) {
        String sql = "INSERT INTO complains (name, cnic, description, is_solved) VALUES (?, ?, ?, false)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getCnic());
            stmt.setString(3, c.getDescription());
            stmt.executeUpdate();
            System.out.println("Complain registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(String cnic) {
        String sql = "UPDATE complains SET is_solved = true WHERE cnic = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnic);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Status updated successfully.");
            } else {
                System.out.println("No complain found with the provided CNIC.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Complain getComplainByCnic(String cnic) {
        String sql = "SELECT * FROM complains WHERE cnic = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnic);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Complain(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("cnic"),
                    rs.getString("description"),
                    rs.getBoolean("is_solved")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}