/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ra3_inscripcionextraescolaresampliacion_danieldr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlumnoD
 */
public class Inscripcion {
    
    String nombre;
    String curso;
    String actividad;
    String turno;
    String nivel;
    String pago;
    int horasSemanales;
    List<String> opcionesElegidas = new ArrayList();
    
    public Inscripcion(String nombre, String curso, String actividad, String turno, String nivel, String pago, int horasSemanales, List<String> opcionesElegidas) {
        this.nombre=nombre;
        this.curso=curso;
        this.actividad=actividad;
        this.turno=turno;
        this.nivel=nivel;
        this.pago=pago;
        this.horasSemanales=horasSemanales;
        this.opcionesElegidas=opcionesElegidas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public String getActividad() {
        return actividad;
    }

    public String getTurno() {
        return turno;
    }

    public String getNivel() {
        return nivel;
    }

    public String getPago() {
        return pago;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public List<String> getOpcionesElegidas() {
        return opcionesElegidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public void setOpcionesElegidas(List<String> opcionesElegidas) {
        this.opcionesElegidas = opcionesElegidas;
    }

    @Override
    public String toString() {
        return nombre + "--" + actividad;
    }
    
}
