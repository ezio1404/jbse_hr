<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css?c=<c:out value='${bv}'/>">
<title>Java Base Code</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/buttons.dataTables.min.css">
    <!-- Custom styles for this template -->
    <!-- <link href="${pageContext.request.contextPath}/lib/bootstrap/cover.css" rel="stylesheet"> -->
    
  </head>

  <body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="ads.jsp">Advertisement</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="app.jsp">Applications</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="rb.jsp">Resume Bank</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="reports.jsp">Reports</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="notif.jsp">Notifier</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Profile</a>
          <a class="dropdown-item" href="#">Settings</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Logout</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
 <div class="container">


 <!-- table -->
     <table id="example" class="display nowrap" style="width:100%">
        <thead>
            <tr>
                <th>Date Applied</th>
                <th>Name</th>
                <th>Email</th>
                <th>Position Applied for</th>
                <th>Resume</th>
         
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011/04/25</td>
          
            </tr>
            <tr>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>63</td>
                <td>2011/07/25</td>
           
            </tr>
            <tr>
                <td>Ashton Cox</td>
                <td>Junior Technical Author</td>
                <td>San Francisco</td>
                <td>66</td>
                <td>2009/01/12</td>
             
            </tr>
            <tr>
                <td>Cedric Kelly</td>
                <td>Senior Javascript Developer</td>
                <td>Edinburgh</td>
                <td>22</td>
                <td>2012/03/29</td>
       
            </tr>
            <tr>
                <td>Airi Satou</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>33</td>
                <td>2008/11/28</td>
        
            </tr>
	</tbody>
</table>
            
 <!-- end table -->
</div>
</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
	<script src="${pageContext.request.contextPath}/lib/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/assets/js/vendor/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/dataTables.buttons.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/buttons.print.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/buttons.flash.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/buttons.html5.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/jszip.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/pdfmake.min.js"></script>
	<script src="${pageContext.request.contextPath}/lib/vfs_fonts.js"></script>
	<script type="text/javascript">
    $(document).ready(function () {
        $('#example').DataTable({
            "pageLength": 20,
            dom: 'Bfrtip',
            buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
        });
    });
</script>

  </body>
</html>