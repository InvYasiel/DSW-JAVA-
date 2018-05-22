package es.cifpcm.aut03_02.buscador.web;

import es.cifcm.aut03_02.cliente;
import es.cifcm.aut03_02.medicion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscadorConsumoElectricoServlet extends HttpServlet {

    public static String dbUrl;
    public static String dbUser;
    public static String dbPassword;
    public static Integer dbPageSize;
    public static Integer DEFAULT_PAGESIZE = 10;
    public static String driverClassName;
    public static String classForName;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscadorConsumoElectricoServlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/css/style.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Servlet los primeros 10 clientes</h1>");
            
            //Lista de clientes y llamada a la función para rellenar.
            ArrayList<cliente> clien = getAllClientes();
            
            //Utiizando un bucle for escribo una tabla con los datos de los clientes.
            out.println("<table class=\"clientes\"><tr> <th>Nombre </th> <th>Apellido </th> <th>NombreCalle </th> <th>Numero </th> <th>CodPostal </th> <th>Poblacion </th> <th>Provincia </th></tr>");
            for (cliente object : clien) {
                out.println("<tr>");
                out.println("<td>" + object.getNombre() + "</td>");
                out.println("<td>" + object.getApellido() + "</td>");
                out.println("<td>" + object.getNombreCalle() + "</td>");
                out.println("<td>" + object.getNumero() + "</td>");
                out.println("<td>" + object.getCodPostal() + "</td>");
                out.println("<td>" + object.getPoblacion() + "</td>");
                out.println("<td>" + object.getProvincia() + "</td></tr>");
            }
            out.println("</table>");
             //Recojo el nombre inroducido en el Index.html
            String nombre = request.getParameter("nombre");
            //Utilizando ese nombre busco un cliente y lo guardo
            cliente c = getClienteByNombre(nombre);
            
            out.println("<h1>Las mediciones para: " + c.getNombre() + "</h1>");
            //lista de mediciones pasandole la id del cliente
            ArrayList<medicion> med = getAllMedicionesById(c.getId());
            //Un double para sumar el total de KW
            Double total = 0.0;
            
            for (medicion object : med) {
                total += object.getKW();
            }
            
            out.println("<h3>El total de mediciones es: " + total + " KW </h3>");
            //Un bucle for que rellena las mediciones para un cliente
            out.println("<table class=\"clientes\"><tr><th>IdMedicion </th> <th>FechaHora </th> <th>KW </th></tr>");
            for (medicion object : med) {
                out.println("<tr>");
                out.println("<td>" + object.getIdMedicion() + "</td>");
                out.println("<td>" + object.getFechaHora() + "</td>");
                //utilizo javascript para mostrar los KW utilizando un botón 
                out.println("<td><button onclick=\"alert('Los KW para esta fecha son: " + object.getKW() + " KW');\">Ver KW</button></td></tr>");

            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    //Función que devuelve un cliente pasandole un nombre
    public static cliente getClienteByNombre(String Nombre) {
        
        Connection conexion = null;
        cliente cc = new cliente();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            Statement s = conexion.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM `misclientes` where nombre = '" + Nombre + "'");


            while (rs.next()) {

                cc.setId(rs.getInt("Id"));
                cc.setNombre(rs.getString(2));
                cc.setApellido(rs.getString(3));
                cc.setNombreCalle(rs.getString(4));
                cc.setNumero(rs.getInt(5));
                cc.setCodPostal(rs.getInt(6));
                cc.setPoblacion(rs.getString(7));
                cc.setProvincia(rs.getString(8));
                return cc;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { 
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return cc;
    }
    //Funcion que contiene una Lista (ArrayList) de todos los Clientes
    public static ArrayList<cliente> getAllClientes() {
        
        Connection conexion = null;

        ArrayList<cliente> clien = new ArrayList<cliente>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            Statement s = conexion.createStatement();

            ResultSet rs = s.executeQuery("select * from misclientes limit " + dbPageSize);


            while (rs.next()) {
                cliente cc = new cliente();
                cc.setId(rs.getInt("Id"));
                cc.setNombre(rs.getString(2));
                cc.setApellido(rs.getString(3));
                cc.setNombreCalle(rs.getString(4));
                cc.setNumero(rs.getInt(5));
                cc.setCodPostal(rs.getInt(6));
                cc.setPoblacion(rs.getString(7));
                cc.setProvincia(rs.getString(8));
                clien.add(cc);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { 
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return clien;
    }
    //Funcion que contiene una Lista (ArrayList) de todas las mediciones de un cliente
    public static ArrayList<medicion> getAllMedicionesById(Integer Id) {
       
        Connection conexion = null;

        ArrayList<medicion> med = new ArrayList<medicion>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `mediciones` WHERE Cliente = " + Id);

            while (rs.next()) {
                medicion mm = new medicion();
                mm.setIdMedicion(rs.getInt("idMedicion"));
                mm.setCliente(rs.getInt("Cliente"));
                mm.setFechaHora(rs.getDate("FechaHora"));
                mm.setKW(rs.getDouble("KW"));
                med.add(mm);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { 
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return med;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            String configBundleName = config.getInitParameter("app.config");
            ResourceBundle rb = ResourceBundle.getBundle(configBundleName);
            this.dbUrl = rb.getString("database.url");
            this.dbUser = rb.getString("database.user");
            this.dbPassword = rb.getString("database.password");
            this.dbPageSize = rb.getString("database.pageSize") == null ? DEFAULT_PAGESIZE : Integer.parseInt(rb.getString("database.pageSize"));
            this.driverClassName = rb.getString("database.driver");
            Class.forName(driverClassName);
        } catch (ClassNotFoundException ex) {

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
