<%-- 
    Document   : employe
    Created on : 30 oct. 2018, 16:49:47
    Author     : Sinponzakra
--%>
<%@page import="classes.Employe"%>
<%@page import="service.EmployeService"%>
<%@page import="classes.Region" %>
<%@page import="service.RegionService" %>
<%
    EmployeService es = new EmployeService();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js h-100" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Employes</title>
        <link href="includes/style.css" rel="stylesheet" type="text/css"/>
        <%@include file="includes/header_scripts.jsp" %>
    </head>
    <body class="h-100">
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
                                <h3 class="page-title">Gestion Des Employes</h3>
                            </div>
                        </div>
                        <!-- End Page Header -->
                        <div class="row">
                            <div class="col">
                                <div class="card card-small mb-4">
                                    <div class="card-header border-bottom">
                                        <h6 class="m-0">Ajouter un Employe</h6>
                                    </div>
                                    <input id="operation" type="hidden" name="operation" value="add" v="" />
                                    <div class="card-body p-0 pb-3">
                                        <div class="form-group col-md-4">
                                            <label>Nom :</label>
                                            <input class="form-control" type="text" name="nom" id="nom"/>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label>Prenom :</label>
                                            <input class="form-control" type="text" name="prenom" id="prenom"/>                  
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label>Email :</label>
                                            <input class="form-control" type="text" name="email" id="email"/>                  
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label>Fonction :</label>
                                            <input class="form-control" type="text" name="fonction" id="fonction"/>                  
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label>Password :</label>
                                            <input class="form-control" type="text" name="password" id="password"/>                  
                                        </div>

                                        <div class="form-group col-md-4">
                                            <button id="save" class="btn btn-success">Ajouter</button>                    
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Default Light Table -->
                        <div class="row">
                            <div class="col">
                                <div class="card card-small mb-4">
                                    <div class="card-header border-bottom">
                                        <h6 class="m-0">Liste Région</h6>
                                    </div>
                                    <div class="card-body p-0 pb-3" id="ttable">
                                        <table class="table mb-0" id="regTable">
                                            <thead class="bg-light">
                                                <tr>
                                                    <th>Nom</th>
                                                    <th>Prenom</th>
                                                    <th>Email</th>
                                                    <th>Fonction</th>
                                                    <th>Password</th>
                                                    <th>Modifier</th>
                                                    <th>Supprimer</th>
                                                </tr>
                                            </thead>
                                            <tbody id="container">
                                                <% for (Employe e : es.findAll()) {%>
                                                <tr>
                                                    <td><%= e.getNom()%></td>
                                                    <td><%= e.getPrenom()%></td>
                                                    <td><%= e.getEmail()%></td>
                                                    <td><%= e.getFonction()%></td>
                                                    <td><%= e.getPassword()%></td>
                                                    <td><Button  class="btn btn-info updateR" v="<%= e.getId()%>">Modifier</Button></td>
                                                    <td><Button  class="btn btn-danger deleteR" v="<%= e.getId()%>">Supprimer</Button></td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Default Light Table -->

                    </div>
                    <footer class="main-footer d-flex p-2 px-3 bg-white border-top">
                        <ul class="nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Services</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">About</a>
                            </li>
                        </ul>
                        <span class="copyright ml-auto my-auto mr-2">Copyright © 2018
                            <a href="https://designrevision.com" rel="nofollow">DesignRevision</a>
                        </span>
                    </footer>
                </main>
            </div>
        </div>

        <%@include file="includes/footer_scripts.jsp" %>
        <script src="scripts/employe.js" type="text/javascript"></script>
    </body>
</html>