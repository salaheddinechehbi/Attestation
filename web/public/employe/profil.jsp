<%-- 
    Document   : profil
    Created on : 1 nov. 2018, 19:40:18
    Author     : salah
--%>

<%@page import="java.util.List"%>
<%@page import="classes.Employe"%>
<%@page import="service.EmployeService"%>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma", "no-cache");//HTTP 1.0
    response.setHeader("Expires", "0");
    
    String email = session.getAttribute("umail").toString();
    if(session.getAttribute("umail")==null){response.sendRedirect("../../index.html");}
    
    EmployeService es = new EmployeService();
    Employe emp = es.findByEmail(email);
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>A-Profil</title>
        <%@include file="includes/header_scripts.jsp" %>
    </head>
    <body>
        <div class="container-fluid">
        <div class="row">
            <!-- Main Sidebar -->
            <%@include file="includes/sideBarMenu.jsp" %>
            <!-- End Main Sidebar -->
            <main class="main-content col-lg-10 col-md-9 col-sm-12 p-0 offset-lg-2 offset-md-3">
                <div class="main-navbar sticky-top bg-white">
                    <!-- Main Navbar -->
                    <%@include file="includes/headerMenu.jsp" %>
                </div>
                <!-- / .main-navbar -->
                <div class="main-content-container container-fluid px-4">
                    <!-- Page Header -->
                    <div class="page-header row no-gutters py-4">
                        <div class="col-12 col-sm-4 text-center text-sm-left mb-0">
                            <span class="text-uppercase page-subtitle">Overview</span>
                            <h3 class="page-title">User Profile</h3>
                        </div>
                    </div>
                    <!-- End Page Header -->
                    <!-- Default Light Table -->
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card card-small mb-4 pt-3">
                                <div class="card-header border-bottom text-center">
                                    <div class="mb-3 mx-auto">
                                        <img class="rounded-circle" src="../../images/avatars/1.jpg" alt="User Avatar" width="110"> </div>
                                    <h4 class="mb-0" id="userName"><%= emp.getNom()+" " %><%= emp.getPrenom() %></h4>
                                    <span class="text-muted d-block mb-2">Employe</span>
                                    <button type="button" class="mb-2 btn btn-sm btn-pill btn-outline-primary mr-2">
                                        <i class="material-icons mr-1">person_img</i>Change</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="card card-small mb-4">
                                <div class="card-header border-bottom">
                                    <h6 class="m-0">Account Details</h6>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item p-3">
                                        <div class="row">
                                            <div class="col">
                                              
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="feFirstName">Nom</label>
                                                            <input type="text" class="form-control" id="nomA" value="<%= emp.getNom() %>"> </div>
                                                        <div class="form-group col-md-6">
                                                            <label for="feLastName">Prenom</label>
                                                            <input type="text" class="form-control" id="prenomA" value="<%= emp.getPrenom() %>"> </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="feEmailAddress">Email</label>
                                                            <input type="email" class="form-control" disabled="" id="emailA" value="<%= emp.getEmail() %>"> </div>
                                                        <div class="form-group col-md-6">
                                                            <label for="fePassword">Password</label>
                                                            <input type="password" class="form-control" id="passA" value="<%= emp.getPassword() %>"> </div>
                                                    </div>
                                                            <input type="hidden" class="form-control" id="idA"  value="<%= emp.getId() %>"> 
                                                    
                                                    <button id="updateA" class="btn btn-accent">Update Account</button>
                                                
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- End Default Light Table -->
                </div>
            </main>

        </div>
        </div>
        <%@include file="includes/footer_scripts.jsp" %>
        <script src="scripts/profil.js" type="text/javascript"></script>      
    </body>
</html>
