<%-- 
    Document   : etablissement
    Created on : 28 oct. 2018, 22:50:25
    Author     : salah
--%>

<%@page import="classes.Etablissement"%>
<%@page import="classes.Region" %>
<%@page import="service.RegionService" %>
<%@page import="service.EtablissementService" %>
<%
    RegionService rs = new RegionService();
    EtablissementService es = new EtablissementService();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js h-100" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>G-Etablissements</title>
        <%@include file="includes/header_scripts.jsp" %>
        <link href="includes/style.css" rel="stylesheet" type="text/css"/>
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
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-3">
                                            <label>Nom :</label>
                                            <input class="form-control" type="text" name="nom" id="nom"/>
                                            </div>
                                            <div class="form-group col-md-3">
                                            <label>Type :</label>
                                            <select class="form-control" name="type" id="type">
                                                <option selected disabled>Sélectionnez Type</option>
                                                <option value="public">Public</option>
                                                <option value="prive">Privé</option>
                                            </select>
                                            </div>
                                            <div class="form-group col-md-3">
                                            <label>Région :</label>
                                            <select class="form-control" name="region" id="region">
                                                <option selected disabled>Sélectionnez la Région</option>
                                                <% for (Region r : rs.findAll()) {%>
                                                <option value="<%= r.getId() %>"><%= r.getNom() %></option>
                                                <% }%>
                                            </select>
                                            </div>
                                            <div class="form-group col-md-3">
                                             <input style="margin-top: 30px" type="button" value="Ajouter" id="saveEtab" name="saveEtab" class="btn btn-success saveEtab"/>   
                                             <input type="hidden" name="etablissement" id="etablissement" value="" />
                                            </div>
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
                                        <table class="table mb-0" id="etabTable">
                                            <thead class="bg-light">
                                                <tr>
                                                    <th>Nom</th>
                                                    <th>Type</th>
                                                    <th>Région</th>
                                                    <th>Modifier</th>
                                                    <th>Supprimer</th>
                                                </tr>
                                            </thead>
                                            <tbody id="tbody">
                                                <% for(Etablissement e : es.findAll()){ %>
                                                <tr>
                                                    <td><%= e.getNom() %></td>
                                                    <td><%= e.getType() %></td>
                                                    <td><%= e.getRegion().getNom() %></td>
                                                    <td><Button  class="btn btn-info updateE" v="<%= e.getId()%>">Modifier</Button></td>
                                                    <td><Button  class="btn btn-danger deleteE" onclick="deleteEtab(<%= e.getId()%>)" v="<%= e.getId()%>">Supprimer</Button></td>
                                                </tr>
                                                <% } %>
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
        <script src="scripts/etablissement.js" type="text/javascript"></script>
    </body>
</html>