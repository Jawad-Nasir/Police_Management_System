import java.sql.*;

public class CitizenDAO {

    public int getOrCreateCitizenId(String name, String cnic) {
        int citizenId = getCitizenIdByCnic(cnic);
        if (citizenId != -1) {
            return citizenId;
        }

        String sql = "INSERT INTO citizens (name, cnic) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, cnic);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getCitizenIdByCnic(String cnic) {
        String sql = "SELECT id FROM citizens WHERE cnic = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnic);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Citizen getCitizenById(int id) {
    String sql = "SELECT * FROM citizens WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Citizen(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("cnic")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


    public Citizen getCitizenByCnic(String cnic) {
        String sql = "SELECT * FROM citizens WHERE cnic = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnic);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Citizen(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("cnic")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
