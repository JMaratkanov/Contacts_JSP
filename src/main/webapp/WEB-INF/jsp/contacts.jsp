<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Kontakte verwalten</title>
    <link href="css/custom.css" rel="stylesheet">
</head>
<body>
<div>
    <div><h2>Hier kann man Kontakte verwalten</h2></div>
    <div>
        <a href="${pageContext.request.contextPath}/contacts/new">Neuer Kontakt</a>
    </div>
    <div>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Vorname</th>
                <th>Nachname</th>
                <th>Geburtstag</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <c:if test="${not empty contactList}">

            <c:forEach items="${contactList}" var="contact">
                <tr>
                    <td><c:out value="${contact.id}" /></td>
                    <td><c:out value="${contact.fName}" /></td>
                    <td><c:out value="${contact.lName}" /></td>
                    <td><c:out value="${contact.eMail}" /></td>
                    <td><c:out value="${contact.bDay}" /></td>

                    <td>
                        <a href="${pageContext.request.contextPath}/contacts/edit/${contact.id}">Bearbeiten</a>
                        <a href="${pageContext.request.contextPath}/contacts/delete/${contact.id}">Löschen</a>
                        <a href="${pageContext.request.contextPath}/contacts/adress/${contact.id}">Zeige Adressen</a>
                    </td>
                </tr>
            </c:forEach>
            </c:if>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>