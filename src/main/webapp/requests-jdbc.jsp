<%@ page contentType="text/html;charset=UTF-8"
         import="java.sql.*, za.co.municipality.smartservice.jdbc.JdbcConnection" %>
<%!
private String escapeHtml(String value) {
    if (value == null) return "";
    return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Municipal Requests - JDBC View</title>
</head>
<body>
<h1>Municipal Service Requests (Direct JDBC)</h1>
<table border="1">
<tr><th>ID</th><th>Citizen</th><th>Type</th><th>Status</th></tr>
<%
String sql = "SELECT request_id, citizen_name, request_type, status FROM service_requests";
try (Connection con = JdbcConnection.getConnection();
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {
    while (rs.next()) {
%>
<tr>
    <td><%= rs.getLong("request_id") %></td>
    <td><%= escapeHtml(rs.getString("citizen_name")) %></td>
    <td><%= escapeHtml(rs.getString("request_type")) %></td>
    <td><%= escapeHtml(rs.getString("status")) %></td>
</tr>
<%  }
} catch (SQLException e) {
    application.log("Unable to display requests using JDBC.", e);
%>
<tr><td colspan="4">Database error. Please contact the system administrator.</td></tr>
<% } %>
</table>
<p><a href="<%= request.getContextPath() %>/">Return to MVC request page</a></p>
</body>
</html>
