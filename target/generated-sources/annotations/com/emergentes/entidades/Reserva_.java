package com.emergentes.entidades;

import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Habitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-12-01T18:30:14")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Cliente> idCliente;
    public static volatile SingularAttribute<Reserva, String> fechaSalida;
    public static volatile SingularAttribute<Reserva, String> fechaEntrada;
    public static volatile SingularAttribute<Reserva, Habitacion> idHabitacion;
    public static volatile SingularAttribute<Reserva, Integer> idReserva;

}