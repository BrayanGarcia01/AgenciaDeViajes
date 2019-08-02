/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.condortripsweb.servlets;

import com.mycompany.condortripsweb.acceso.VString;
import com.mycompany.condortripsweb.negocio.GestorPaquetesWeb;
import com.mycompany.condortripsweb.negocio.PaqueteWeb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielmej
 */
@WebServlet(name = "PaquetesServlet", urlPatterns = {"/PaquetesServlet"})
public class PaquetesServlet extends HttpServlet {

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
        
        String accion=request.getParameter("accion");
        
        if(accion !=null){
            if(accion.equals("listar")){
                GestorPaquetesWeb pqBD=new GestorPaquetesWeb();
                VString[] IdpaqueteDisponibles=pqBD.consultarIDPaquetesTI();
                
                ArrayList<PaqueteWeb> paquetes=new ArrayList<PaqueteWeb>();
                
                for(int i=0;i<IdpaqueteDisponibles.length;i++){
                    paquetes.add(pqBD.consultarPaquete(IdpaqueteDisponibles[i].getInt()));
                }
                
                request.setAttribute("paquetes", paquetes);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
            }
            
            if(accion.equals("acerca")){
                request.getRequestDispatcher("acercaDe.jsp").forward(request, response);
            }
            
            if(accion.equals("ofertas")){
                request.getRequestDispatcher("ofertas.jsp").forward(request, response);
            }
            
            if(accion.equals("index")){
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
          
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
