/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilajsf_yasiel.web.bean;

import es.cifpcm.sakilajsf_yasiel.data.ActorDao;
import es.cifpcm.sakilajsf_yasiel.data.ActorDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import es.cifpcm.sakilajsf_yasiel.model.Actor;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yasie
 */
@Named(value = "actorBean")
@RequestScoped

public class ActorBean extends Actor {

    @NotNull(message = "Apellido es obligatorio")
    @Size(min = 1, message = "Apellido es obligatorio")
    @Override
    public String getLast_name() {
        return super.getLast_name();
    }

    @NotNull(message = "Nombre es obligatorio")
    @Size(min = 1, message = "Nombre es obligatorio")
    @Override
    public String getFirst_name() {
        return super.getFirst_name();
    }

    public static Actor actor;

    public static Actor getActor() {
        return actor;
    }
    
    public List<Actor> getActorList() {
        // Llama al metodo selectAll del ActorDaoImpl
        ActorDao a = new ActorDaoImpl();
        return a.selectAll();
    }

    public String save() {
        // Guarda el actor con los parametros introducidos
        actor = new ActorDaoImpl().insert(this);
        
        // Si el ID del actor es nulo significa que se inserto bien
        if (actor.getId_actor() == null) {
            return "/error.xhtml?faces-redirect=true";
        } else {
            return "actorDetail.xhtml?faces-redirect=true";
        }
    }

    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Error en la base de datos!"));
    }

    

}
