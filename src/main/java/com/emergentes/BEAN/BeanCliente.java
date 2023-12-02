/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.BEAN;

import com.emergentes.controladores.ClienteJpaController;
import com.emergentes.controladores.exceptions.NonexistentEntityException;
import com.emergentes.entidades.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nogal
 */
public class BeanCliente {
        private EntityManagerFactory enf;
    private ClienteJpaController jpaCli;
    
    
    public BeanCliente(){
        enf= Persistence.createEntityManagerFactory("hotlepersistence");
        jpaCli= new ClienteJpaController(enf);
    }
    public List<Cliente> listartodo(){
        return jpaCli.findClienteEntities();
    }
    public void insertar(Cliente cli){
        jpaCli.create(cli);
    }
        public void editar (Cliente cli){
        try {
            jpaCli.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(BeanHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        }
        
         public void eliminar(Integer id){
        try {
            jpaCli.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public Cliente buscar(Integer idCliente){
            return jpaCli.findCliente(idCliente);
        }

}
