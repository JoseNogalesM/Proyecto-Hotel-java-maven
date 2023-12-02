/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.BEAN;

import com.emergentes.controladores.ReservaJpaController;
import com.emergentes.controladores.exceptions.NonexistentEntityException;
import com.emergentes.entidades.Reserva;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nogal
 */
public class BeanReserva {
          private EntityManagerFactory enf;
    private ReservaJpaController jpaReserva;
    
    
    public BeanReserva(){
        enf= Persistence.createEntityManagerFactory("hotlepersistence");
        jpaReserva = new ReservaJpaController(enf);
    }
    public List<Reserva> listartodo(){
        return jpaReserva.findReservaEntities();
    }
    public void insertar(Reserva res){
        jpaReserva.create(res);
    }
        public void editar (Reserva res){
        try {
            jpaReserva.edit(res);
        } catch (Exception ex) {
            Logger.getLogger(BeanReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        }
        public void eliminar(Integer id){
        try {
            jpaReserva.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public Reserva buscar(Integer id){
            return jpaReserva.findReserva(id);
        }

}
