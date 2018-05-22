/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilajsf_yasiel.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import es.cifpcm.sakilajsf_yasiel.model.Actor;

/**
 *
 * @author yasie
 */
public class ActorDaoImpl implements ActorDao {
    
    public List<Actor> selectAll() {
        List<Actor> actors = new ArrayList<Actor>();
        
        try {
            Connection conexion = null;
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "2daw", "2daw");
                String cadena = "select * from actor";
                PreparedStatement s = conexion.prepareStatement(cadena);
                ResultSet rs = s.executeQuery(cadena);
                
                while (rs.next()) {
                    Integer id = rs.getInt("actor_id");
                    String name = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    Date update = rs.getDate("last_update");
                    
                    Actor actor = new Actor();
                    actor.setId_actor(id);
                    actor.setFirst_name(name);
                    actor.setLast_name(lastName);
                    actor.setLast_update(update);
                    
                    actors.add(actor);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        return actors;
    }
    
    public Actor insert(Actor actor) {
        // Guardarmos el actor en una variable nueva
        Actor a = actor;
        try {
            // Dependencia de la conexion
            Connection conexion = null;
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                // String de conexion
                conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "2daw", "2daw");
                // Insert a la base de datos
                String cadena = "INSERT INTO `actor`( `first_name`, `last_name`) VALUES (?,?)";
                // Prepare Statement que devuelve las claves generadas
                PreparedStatement s = conexion.prepareStatement(cadena, Statement.RETURN_GENERATED_KEYS);
                
                // Asignamos los valores del actor
                s.setString(1, a.getFirst_name());
                s.setString(2, a.getLast_name());
                
                // Ejecuta la sentencia
                s.executeUpdate();                
                
                // Recogemos las claves
                ResultSet rs = s.getGeneratedKeys();
                
                if (rs.next()) {
                    // Obtenemos la ID generada
                    Short id = rs.getShort(1);
                    // La asignamos al actor
                    a.setId_actor(Integer.parseInt(id.toString()));
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        
        // Devolvemos el actor con la ID
        return a;
    }
    
}
