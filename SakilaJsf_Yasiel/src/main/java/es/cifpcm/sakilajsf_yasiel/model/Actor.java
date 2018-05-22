/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilajsf_yasiel.model;

import java.util.Date;

/**
 *
 * @author yasie
 */
public class Actor {
    private Integer id_actor;
    private String first_name;
    private String last_name;
    private Date last_update; 
    public Actor(){
        
    }
    public Integer getId_actor() {
        return id_actor;
    }

    public void setId_actor(Integer id_actor) {
        this.id_actor = id_actor;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Actor(Integer id_actor, String first_name, String last_name, Date last_update) {
        this.id_actor = id_actor;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }
}
