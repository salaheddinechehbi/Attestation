<%-- 
    Document   : region
    Created on : 28 oct. 2018, 22:49:47
    Author     : salah
--%>
<%@page import="classes.Region" %>
<%@page import="service.RegionService" %>
<%
    RegionService rs = new RegionService();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js h-100" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>G-Régions</title>
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
                                <span class="text-uppercase page-subtitle">Overview</span>
                                <h3 class="page-title">Gestion Des Régions</h3>
                            </div>
                        </div>
                        <!-- End Page Header -->
                        <div class="row">
                            <div class="col">
                                <div class="card card-small mb-4">
                                    <div class="card-header border-bottom">
                                        <h6 class="m-0">Ajouter Région</h6>
                                    </div>
                                    <div class="card-body p-0 pb-3">
                                        <div class="form-group col-md-4">
                                            <label>Nom :</label>
                                            <link href="includes/style.css" rel="stylesheet" type="text/css"/>
                                            <input class="form-control" type="text" name="nom" id="nom"/>
                                            <input type="button" value="Ajouter" id="saveReg" name="saveReg" onclick="addRegion()" class="btn btn-success"/>                    
                                            <input type="hidden" name="region" id="region" value="" />
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
                                    <div class="card-body p-0 pb-3" id="divtable">
                                        <table class="table mb-0" id="regTable">
                                            <thead class="bg-light">
                                                <tr>
                                                    <th>Nom</th>
                                                    <th>Modifier</th>
                                                    <th>Supprimer</th>
                                                </tr>
                                            </thead>
                                            <tbody id="tbody">
                                                <% for (Region r : rs.findAll()) {%>
                                                <tr>
                                                    <td><%= r.getNom()%></td>
                                                    <td><Button onclick="updateRegion(<%=r.getId()%>, '<%= r.getNom()%>')" class="btn btn-info updateR" >Modifier</Button></td>
                                                    <td><Button onclick="deleteRegion(<%=r.getId()%>)" class="btn btn-danger deleteR" >Supprimer</Button></td>
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
        <script src="scripts/region.js" type="text/javascript"></script>
    </body>
</html>