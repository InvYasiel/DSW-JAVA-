/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yasie
 */
@WebServlet(urlPatterns = {"/vercalendario"})
public class VerCalendarioServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerCalendarioServlet</title>");        
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> CALENDARIO </h1>");
            Hashtable<String, Integer> meses = new Hashtable<String, Integer>();
            meses.put("Enero",0);
            meses.put("Febrero",1);
            meses.put("Marzo",2);
            meses.put("Abril",3);
            meses.put("Mayo",4);
            meses.put("Junio",5);
            meses.put("Julio",6);
            meses.put("Agosto",7);
            meses.put("Septiembre",8);
            meses.put("Octubre",9);
            meses.put("Noviembre",10);
            meses.put("Diciembre",11);
            
            String mes = request.getParameter("mes");
            int mest = meses.get(mes);
            String aniot = request.getParameter("anio");
            int ano = Integer.parseInt(aniot);
                // MOSTRAR CALENDARIO

            int equivalencias_semana[] = {6, 0, 1, 2, 3, 4, 5};
            Calendar fecha_elegida = new GregorianCalendar(Integer.parseInt(aniot),mest, 1);
            int dia_semana = 0;
            int dia_corriente = 1;
            int dia_semana_actual = fecha_elegida.get(Calendar.DAY_OF_WEEK)-1;
            int desplazamiento_inicio = equivalencias_semana[dia_semana_actual];
            int limite_mes = fecha_elegida.getActualMaximum(Calendar.DAY_OF_MONTH);

            Calendar mes_anterior = new GregorianCalendar(Integer.parseInt(aniot),mest-1, 1);
            Calendar fecha_actual = new GregorianCalendar();

            int dia_actual = fecha_actual.get(Calendar.DAY_OF_MONTH);

            int dia_desplazado = mes_anterior.getActualMaximum(Calendar.DAY_OF_MONTH);
            dia_desplazado = dia_desplazado - (equivalencias_semana[dia_semana_actual]-1);

            String dias_semana[] = {"L", "M", "X", "J", "V", "S", "D"};
            out.print("<h3>"+mes+" de "+ano+"</h3>");
            out.print("<table style='border: 2px solid red; padding:15px;'>");
            out.print("<tr style='border: 2px solid black; padding: 5px;'>");
            for(int i = 0; i < dias_semana.length; i++){
                out.print("<td style='border: 2px solid grey; width:25px; color:#fff; background-color: grey; text-align:center !important;'>"+dias_semana[i]+"</td>");
            }
            out.print("</tr><tr style='border: 2px solid black;'>");
            for(int i = 0; i < desplazamiento_inicio; i++){
                out.print("<td style='border: 2px solid grey; width:25px;text-align:center !important; color:#8e8e8e; background-color: #cecece;' >"+dia_desplazado+"</td>");
                dia_semana++;
                dia_desplazado++;
            }
            while(dia_corriente <= limite_mes){
                String color = "b1b1b1";
                if(dia_actual == dia_corriente && mest == fecha_actual.get((Calendar.MONTH))){
                    color = "d8c231";
                }else if(dia_semana == dias_semana.length-2 || dia_semana == dias_semana.length-1){
                    color = "ff0000";
                }
                out.print("<td style='border: 2px solid #"+color+"; width:25px;text-align:center !important;' >"+dia_corriente+"</td>");
                dia_semana++;
                if(dia_semana == dias_semana.length){
                    out.print("</tr><tr style='border: 2px solid black;'>");
                    dia_semana = 0;
                }
                dia_corriente++;
            }
            dia_corriente = 1;
            while(dia_semana < dias_semana.length){
                out.print("<td style='border: 2px solid grey; width:25px;text-align:center !important; color:#8e8e8e; background-color: #cecece;' >"+dia_corriente+"</td>");
                dia_semana++;
                dia_corriente++;
            }
            out.print("</tr>");
            out.print("</table>");


            out.println("</body>");
            out.println("</html>");
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
