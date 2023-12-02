/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.controladores;

import com.emergentes.controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Habitacion;
import com.emergentes.entidades.Reserva;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author nogal
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idCliente = reserva.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                reserva.setIdCliente(idCliente);
            }
            Habitacion idHabitacion = reserva.getIdHabitacion();
            if (idHabitacion != null) {
                idHabitacion = em.getReference(idHabitacion.getClass(), idHabitacion.getIdHabitacion());
                reserva.setIdHabitacion(idHabitacion);
            }
            em.persist(reserva);
            if (idCliente != null) {
                idCliente.getReservaList().add(reserva);
                idCliente = em.merge(idCliente);
            }
            if (idHabitacion != null) {
                idHabitacion.getReservaList().add(reserva);
                idHabitacion = em.merge(idHabitacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getIdReserva());
            Cliente idClienteOld = persistentReserva.getIdCliente();
            Cliente idClienteNew = reserva.getIdCliente();
            Habitacion idHabitacionOld = persistentReserva.getIdHabitacion();
            Habitacion idHabitacionNew = reserva.getIdHabitacion();
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                reserva.setIdCliente(idClienteNew);
            }
            if (idHabitacionNew != null) {
                idHabitacionNew = em.getReference(idHabitacionNew.getClass(), idHabitacionNew.getIdHabitacion());
                reserva.setIdHabitacion(idHabitacionNew);
            }
            reserva = em.merge(reserva);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getReservaList().remove(reserva);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getReservaList().add(reserva);
                idClienteNew = em.merge(idClienteNew);
            }
            if (idHabitacionOld != null && !idHabitacionOld.equals(idHabitacionNew)) {
                idHabitacionOld.getReservaList().remove(reserva);
                idHabitacionOld = em.merge(idHabitacionOld);
            }
            if (idHabitacionNew != null && !idHabitacionNew.equals(idHabitacionOld)) {
                idHabitacionNew.getReservaList().add(reserva);
                idHabitacionNew = em.merge(idHabitacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reserva.getIdReserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getIdReserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Cliente idCliente = reserva.getIdCliente();
            if (idCliente != null) {
                idCliente.getReservaList().remove(reserva);
                idCliente = em.merge(idCliente);
            }
            Habitacion idHabitacion = reserva.getIdHabitacion();
            if (idHabitacion != null) {
                idHabitacion.getReservaList().remove(reserva);
                idHabitacion = em.merge(idHabitacion);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Reserva findReserva(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
