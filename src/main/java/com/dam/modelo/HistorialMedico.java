package com.dam.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class HistorialMedico implements Serializable {

    private LocalDate fecha;
    private String sintomas;
    private String diagnostico;

    public HistorialMedico(LocalDate fecha, String sintomas, String diagnostico) {
        this.fecha = fecha;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

}