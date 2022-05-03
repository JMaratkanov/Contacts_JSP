<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="de">
<head>
  <meta charset="UTF-8">
  <title>${pagetitle}</title>
  <!--Bootstrap CSS-->
  <!--<link rel="stylesheet" href="/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css" />-->
  <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
  <!--Bootstrap JS-->
  <script th:src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div>
  <div><h2>${pagetitle}</h2></div>
  <form:form method="POST" action="/contacts/new/save" modelAttribute="contact">
    <table>
      <form:input type="hidden" path="id"/>
    <tr>
      <td><form:label path="fName">Vorname</form:label></td>
      <td><form:input path="fName"/></td>
    </tr>
    <tr>
      <td><form:label path="lName">Nachname</form:label></td>
      <td><form:input path="lName"/></td>
    </tr>
    <tr>
        <td><form:label path="bDay">Geburtstag</form:label></td>
        <td><form:input type="date" id="datepicker" path="bDay" placeholder="yyyy/mm/dd"/></td>
    </tr>
    <tr>
      <td><form:label path="eMail">email</form:label></td>
      <td><form:input path="eMail"/></td>
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