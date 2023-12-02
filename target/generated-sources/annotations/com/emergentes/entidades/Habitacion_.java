package com.emergentes.entidades;

import com.emergentes.entidades.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-01T18:30:14")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> tipo;
    public static volatile SingularAttribute<Habitacion, Integer> precio;
    public static volatile SingularAttribute<Habitacion, Integer> numero;
    public static volatile ListAttribute<Habitacion, Reserva> reservaList;
    public static volatile SingularAttribute<Habitacion, Integer> idHabitacion;
    public static volatile SingularAttribute<Habitacion, Integer> disponible;

}