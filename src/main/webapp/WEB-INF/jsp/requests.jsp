<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Municipal Service Requests</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 2rem; background: #f5f7fa; }
        main { max-width: 1000px; margin: auto; background: white; padding: 1.5rem; border-radius: 8px; }
        label { display: block; margin-top: .8rem; }
        input, select, textarea { width: 100%; padding: .6rem; box-sizing: border-box; }
        button { margin-top: 1rem; padding: .7rem 1.2rem; }
        table { width: 100%; border-collapse: collapse; margin-top: 1.5rem; }
        th, td { border: 1px solid #ddd; padding: .6rem; text-align: left; }
        th { background: #eef2f7; }
    </style>
</head>
<body>
<main>
    <h1>Smart Municipal Service Management</h1>
    <h2>Submit a service request</h2>
    <form action="${pageContext.request.contextPath}/submit-request" method="post">
        <label for="citizenName">Citizen name</label>
        <input id="citizenName" name="citizenName" type="text" maxlength="100" required>
        <label for="requestType">Request type</label>
        <select id="requestType" name="requestType" required>
            <option value="">Select a service</option>
            <option>WATER_LEAK</option><option>ELECTRICITY</option>
            <option>REFUSE_REMOVAL</option><option>ROAD_REPAIR</option>
            <option>STREETLIGHT</option>
        </select>
        <label for="description">Description</label>
        <textarea id="description" name="description" maxlength="1000" required></textarea>
        <button type="submit">Submit request</button>
    </form>

    <h2>Submitted service requests</h2>
    <table>
        <thead><tr><th>ID</th><th>Citizen</th><th>Type</th><th>Description</th><th>Status</th><th>Created</th></tr></thead>
        <tbody>
        <c:forEach var="item" items="${requests}">
            <tr>
                <td><c:out value="${item.requestId}"/></td>
                <td><c:out value="${item.citizenName}"/></td>
                <td><c:out value="${item.requestType}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="${item.status}"/></td>
                <td><c:out value="${item.createdAt}"/></td>
            </tr>
        </c:forEach>
        <c:if test="${empty requests}">
            <tr><td colspan="6">No service requests have been submitted yet.</td></tr>
        </c:if>
        </tbody>
    </table>
</main>
</body>
</html>
