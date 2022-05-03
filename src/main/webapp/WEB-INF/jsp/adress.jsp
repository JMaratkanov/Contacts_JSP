<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset=utf-8">
    <title>Adressen verwalten</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"  rel="stylesheet" type="text/css">

</head>
<body>
<div class="container-fluid text-center">
    <div><h2>Hier kann man Adressen/Telefonnummern von Kontakt-ID: verwalten</h2></div>
    <div>
        <a class="h3" href="${pageContext.request.contextPath}/contacts/adress/${conId}/new">Neue Adresse</a>
        <a class="h3" href="${pageContext.request.contextPath}/contacts">Zurück</a>
    </div>
    <div>
        <table class="table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Straße</th>
                <th>Nummer</th>
                <th>Ort</th>
                <th>Plz</th>
                <th>Telefonnummer</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <c:if test="${not empty adressList}">

                <c:forEach items="${adressList}" var="adress">
                    <tr>
                        <td><c:out value="${adress.street}" /></td>
                        <td><c:out value="${adress.sNumber}" /></td>
                        <td><c:out value="${adress.place}" /></td>
                        <td><c:out value="${adress.postcode}" /></td>
                        <td><c:out value="${adress.telefonNummer}" /></td>

                        <td>
                            <a href="${pageContext.request.contextPath}/contacts/adress/${conId}/edit/${adress.id}">Bearbeiten</a>
                            <a href="${pageContext.request.contextPath}/contacts/adress/${conId}/delete/${adress.id}">Löschen</a>
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