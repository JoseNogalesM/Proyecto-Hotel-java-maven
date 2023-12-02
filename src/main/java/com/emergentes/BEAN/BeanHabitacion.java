/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.BEAN;

import com.emergentes.controladores.HabitacionJpaController;
import com.emergentes.controladores.exceptions.NonexistentEntityException;
import com.emergentes.entidades.Habitacion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nogal
 */
public class BeanHabitacion {
    private EntityManagerFactory enf;
    private HabitacionJpaController jpaHabi;
    
    
    public BeanHabitacion(){
        enf= Persistence.createEntityManagerFactory("hotlepersistence");
        jpaHabi= new HabitacionJpaController(enf);
    }
    public List<Habitacion> listartodo(){
        return jpaHabi.findHabitacionEntities();
    }
    public void insertar(Habitacion habi){
        jpaHabi.create(habi);
    }
        public void editar (Habitacion habi){
        try {
            jpaHabi.edit(habi);
        } catch (Exception ex) {
            Logger.getLogger(BeanHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        }
        public void eliminar(Integer IdHabitacion){
        try {
            jpaHabi.destroy(IdHabitacion);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public Habitacion buscar(Integer IdHabitacion){
            return jpaHabi.findHabitacion(IdHabitacion);
        }
        }
    




