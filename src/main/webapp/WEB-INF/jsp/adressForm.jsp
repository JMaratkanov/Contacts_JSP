<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="de">
<head>
  <meta charset="UTF-8">
  <title>${pagetitle}</title>

</head>
<body>
<div>
  <div><h2>${pagetitle}</h2></div>
  <form:form method="POST" action="/contacts/adress/${conId}/new/save" modelAttribute="adress">
  <table>
    <form:input type="hidden" path="id"/>
    <form:input type="hidden" path="contactID" value="${conId}"/>
    <tr>
      <td><form:label path="street">Strasse</form:label></td>
      <td><form:input path="street"/></td>
    </tr>
    <tr>
      <td><form:label path="sNumber">Nummer</form:label></td>
      <td><form:input path="sNumber"/></td>
    </tr>
    <tr>
      <td><form:label path="place">Ort</form:label></td>
      <td><form:input path="place"/></td>
    </tr>
    <tr>
      <td><form:label path="postcode">Plz</form:label></td>
      <td><form:input path="postcode"/></td>
    </tr>
    <tr>
      <td><form:label path="telefonNummer">Telefon</form:label></td>
      <td><form:input path="telefonNummer"/></td>
    </tr>

    <tr>
      <td><input type="submit" value="Submit"/></td>
      <td> <button type="button" onclick="cancelform()">Abbrechen</button></td>
    </tr>
  </table>
</form:form>
</div>
<script type="text/javascript">
  function cancelform(){
    window.location= "${pageContext.request.contextPath}/contacts";
  }
</script>
</body>
</html>