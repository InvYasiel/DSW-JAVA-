/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilajsf_yasiel.data;

import java.util.List;
import es.cifpcm.sakilajsf_yasiel.model.Actor;

/**
 *
 * @author yasie
 */
public interface ActorDao {
    public List<Actor> selectAll();
    public Actor insert(Actor actor);
   
}
