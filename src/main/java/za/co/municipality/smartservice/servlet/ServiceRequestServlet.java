package za.co.municipality.smartservice.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import za.co.municipality.smartservice.jdbc.JdbcConnection;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServiceRequestServlet", urlPatterns = "/submit-request")
public class ServiceRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String citizenName = request.getParameter("citizenName");
        String requestType = request.getParameter("requestType");
        String description = request.getParameter("description");

        if (isBlank(citizenName) || isBlank(requestType) || isBlank(description)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Citizen name, request type and description are required.");
            return;
        }

        String sql = "INSERT INTO service_requests "
                + "(citizen_name, request_type, description, status, created_at) "
                + "VALUES (?, ?, ?, 'SUBMITTED', NOW())";

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, citizenName.trim());
            statement.setString(2, requestType.trim());
            statement.setString(3, description.trim());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new ServletException("Unable to save the municipal request.", ex);
        }

        response.sendRedirect(request.getContextPath() + "/?submitted="
                + URLEncoder.encode("true", StandardCharsets.UTF_8));
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
