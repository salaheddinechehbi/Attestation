<%-- 
    Document   : index
    Created on : 28 oct. 2018, 22:16:25
    Author     : salah
--%>
<%@page import="classes.Region"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.RegionService" %>
<%@page import="service.EtablissementService" %>
<%@page import="service.EmployeService" %>
<%@page import="service.EtudiantService" %>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma", "no-cache");//HTTP 1.0
    response.setHeader("Expires", "0");
    
    if(session.getAttribute("umail")==null){
        response.sendRedirect("../../index.html");
    }
    EmployeService es = new EmployeService();
    EtablissementService ess = new EtablissementService();
    RegionService rs = new RegionService();
    EtudiantService ets = new EtudiantService();

    int employe = es.countEmploye();
    int etablissement = ess.countEtablissement();
    int region = rs.countRegion();
    int etudiant = ets.countEtudiant();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js h-100" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>A-Home</title>
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
                                <span class="text-uppercase page-subtitle">Dashboard</span>
                                <h3 class="page-title">Blog Overview</h3>
                            </div>
                        </div>
                        <!-- End Page Header -->
                        <!-- Small Stats Blocks -->
                        <div class="row">
                            <div class="col-lg col-md-6 col-sm-6 mb-4">
                                <div class="stats-small stats-small--1 card card-small" style="background-color: #0cdbff">
                                    <div class="card-body p-0 d-flex">
                                        <div class="d-flex flex-column m-auto">
                                            <div class="stats-small__data text-center">
                                                <span class="stats-small__label text-uppercase">Régions</span>
                                                <h6 class="stats-small__value count my-3"><%= region %></h6>
                                            </div>
                                        </div>
                                        <canvas height="120" class="blog-overview-stats-small-1"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg col-md-6 col-sm-6 mb-4">
                                <div class="stats-small stats-small--1 card card-small" style="background-color: aquamarine">
                                    <div class="card-body p-0 d-flex">
                                        <div class="d-flex flex-column m-auto">
                                            <div class="stats-small__data text-center">
                                                <span class="stats-small__label text-uppercase">Etablissement</span>
                                                <h6 class="stats-small__value count my-3"><%= etablissement%></h6>
                                            </div>
                                        </div>
                                        <canvas height="120" class="blog-overview-stats-small-2"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg col-md-4 col-sm-6 mb-4">
                                <div class="stats-small stats-small--1 card card-small" style="background-color: palegoldenrod">
                                    <div class="card-body p-0 d-flex">
                                        <div class="d-flex flex-column m-auto">
                                            <div class="stats-small__data text-center">
                                                <span class="stats-small__label text-uppercase">Employes</span>
                                                <h6 class="stats-small__value count my-3"><%= employe%></h6>
                                            </div>
                                        </div>
                                        <canvas height="120" class="blog-overview-stats-small-3"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg col-md-4 col-sm-6 mb-4">
                                <div class="stats-small stats-small--1 card card-small" style="background-color: lightcoral">
                                    <div class="card-body p-0 d-flex">
                                        <div class="d-flex flex-column m-auto">
                                            <div class="stats-small__data text-center">
                                                <span class="stats-small__label text-uppercase">Etudiants</span>
                                                <h6 class="stats-small__value count my-3"><%= etudiant%></h6>
                                            </div>
                                        </div>
                                        <canvas height="120" class="blog-overview-stats-small-4"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Small Stats Blocks -->
                        <div class="row col-md-12">
                            <!-- Users Stats -->
                            <div class="col-md-4">
                                <div class="card card-small">
                                    <div class="card-header border-bottom">
                                        <h6 class="m-0">Etablissements</h6>
                                    </div>
                                    <div class="row border-bottom">
                                        <div>
                                         <ul class="">
                                             <% int count = 1;
                                                 for(Region rg : rs.findAll()){ %>
                                                 <li style="list-style-type:  decimal">
                                            <span class="text-semibold text-fiord-blue"><%= " => "+rg.getNom() %></span>
                                          </li>
                                          <% count++; }%>
                                         </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="card card-small">
                                    <div class="card-header border-bottom">
                                        <h6 class="m-0">Etablissements Par Région</h6>
                                    </div>
                                    <div class="row border-bottom">
                                        <div class="col-9">
                                            <canvas id="etabRegChart"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Users Stats -->
                        </div>
                                               
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
        
        <script>
            $(document).ready(function () {
                //alert("ok");
                let myChart = document.getElementById('etabRegChart').getContext('2d');
                // Global Options
                Chart.defaults.global.defaultFontFamily = 'Lato';
                Chart.defaults.global.defaultFontSize = 18;
                Chart.defaults.global.defaultFontColor = '#777';
                
                <%
                    List<Integer> mList = new ArrayList<Integer>();
                    List<Integer> mList2 = new ArrayList<Integer>();
                    List<String> mList1 = new ArrayList<String>();
                    
                    String regex = "([+\\-!\\(\\){}\\[\\]^\"~*'?:\\\\]|[&\\|]{2})";

                    for(Region s : rs.findAll()){
                        mList1.add("'"+s.getNom().replaceAll(regex, "\\\\$1")+"'");
                    }
                    for(Region rr : rs.findAll()){
                        mList.add(rr.getId());
                    }
                    
                    for(int s : mList){
                        mList2.add(ess.CountEtablissementByRegionName(s));
                    }
                %>
                let regions = <%=mList1%>;
                let etablissements = <%=mList2%>;
                
                let massPopChart = new Chart(myChart, {
                    type: 'bar', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
                    data: {
                        labels: regions,
                        datasets: [{
                                label: "nombre d'etablissement",
                                data: etablissements,
                                //backgroundColor:'green',
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.6)',
                                    'rgba(54, 162, 235, 0.6)',
                                    'rgba(255, 206, 86, 0.6)',
                                    'rgba(75, 192, 192, 0.6)',
                                    'rgba(153, 102, 255, 0.6)',
                                    'rgba(255, 159, 64, 0.6)',
                                    'rgba(255, 99, 132, 0.6)'
                                ],
                                borderWidth: 1,
                                borderColor: '#777',
                                hoverBorderWidth: 3,
                                hoverBorderColor: '#000'
                            }]
                    },
                    options: {
                        title: {
                            display: true,
                            text: 'Le nombre des Etablissements par Région',
                            fontSize: 25
                        },
                        layout: {
                            padding: {
                                left: 30,
                                right: 0,
                                bottom: 0,
                                top: 0
                            }
                        },
                        tooltips: {
                            enabled: true
                        },
                         scales: {
                       yAxes: [{
                                display: true,
                                stacked: true,
                                ticks: {
                                    min: 0, // minimum value
                                }
                       }]
                    }
                    }
                });
                
            });
        </script>
    </body>
</html>