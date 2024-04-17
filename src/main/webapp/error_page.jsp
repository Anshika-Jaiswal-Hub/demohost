<%-- 
    Document   : error_page
    Created on : 29-Mar-2024, 12:54:59 am
    Author     : Anshika Jaiswal
--%>
<%@page isErrorPage ="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry something went wrong</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="container text-center" >
            <img src="Image/system.png" class="img-fluid">
            <h1>Sorry something went wrong....</h1>
            <h4>(<%= exception %>)</h4>
            
            <a href="index.jsp" class="btn primary-background btn-lg text-white ">Home</a>
            
        </div>
    </body>
</html>
