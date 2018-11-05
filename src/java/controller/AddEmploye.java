/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Employe;
import classes.EmployeEtablissement;
import classes.EmployeEtablissementPK;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EmployeEtablissementService;
import service.EmployeService;
import service.EtablissementService;
import static util.Util.md5;

/**
 *
 * @author Sinponzakra
 */
@WebServlet(name = "AddEmploye", urlPatterns = {"/AddEmploye"})
public class AddEmploye extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String fonction = request.getParameter("fonction");
            int etab_id = Integer.parseInt(request.getParameter("etab"));
            String dated = request.getParameter("dated").replace("-", "/");
            String datef = request.getParameter("datef").replace("-", "/");
            Date df = null;
            if (!datef.isEmpty()) {
                df = new Date(datef);
            }
            String operation = request.getParameter("operation");
            EmployeService es = new EmployeService();
            EmployeEtablissementService ets = new EmployeEtablissementService();
            EtablissementService ts = new EtablissementService();
            if (operation.equals("add")) {
                int emp_id = es.createWithIdFeedBack(new Employe(nom, prenom, email, fonction, md5(password)));
                ets.create(new EmployeEtablissement(new EmployeEtablissementPK(emp_id, etab_id, new Date(dated)), es.findById(emp_id), ts.findById(etab_id), df));
            } else if (operation.equals("update")) {
                int emp_id = Integer.parseInt(request.getParameter("id"));
                Employe e = es.findById(emp_id);
                e.setNom(nom);
                e.setPrenom(prenom);
                e.setEmail(email);
                e.setPassword(md5(password));
                e.setFonction(fonction);
                es.update(e);
                ets.delete(ets.findbyEmployeId(emp_id));
                ets.create(new EmployeEtablissement(new EmployeEtablissementPK(emp_id, etab_id, new Date(dated)), es.findById(emp_id), ts.findById(etab_id), df));
            }
            Gson g = new Gson();
            out.write(g.toJson(ets.findAll()));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
