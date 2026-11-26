package za.co.municipality.smartservice.jdbc;

import za.co.municipality.smartservice.model.ServiceRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcServiceRequestDao {
    public int insert(ServiceRequest request) throws SQLException {
        String sql = "INSERT INTO service_requests "
                + "(citizen_name, request_type, description, status, created_at) "
                + "VALUES (?, ?, ?, ?, NOW())";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, request.getCitizenName());
            statement.setString(2, request.getRequestType());
            statement.setString(3, request.getDescription());
            statement.setString(4, request.getStatus());
            return statement.executeUpdate();
        }
    }

    public List<String> findAllAsText() throws SQLException {
        String sql = "SELECT request_id, citizen_name, request_type, description, status "
                   + "FROM service_requests ORDER BY request_id DESC";
        List<String> rows = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                rows.add("ID: " + resultSet.getLong("request_id")
                        + " | Citizen: " + resultSet.getString("citizen_name")
                        + " | Type: " + resultSet.getString("request_type")
                        + " | Description: " + resultSet.getString("description")
                        + " | Status: " + resultSet.getString("status"));
            }
        }
        return rows;
    }
}
