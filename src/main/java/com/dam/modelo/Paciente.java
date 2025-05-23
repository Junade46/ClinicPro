package com.dam.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int idPaciente;
    private String nombre;
    private String telefono;
    private String email;
    private List<HistorialMedico> historial;

    // Constructor


    public Paciente() {
    }

    public Paciente(int idPaciente, String nombre, String telefono, String email) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.historial = new ArrayList<>();
    }

    public void mostrarDatos() {
        System.out.println("ID: " + idPaciente);
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
    }

    // --- Getters ---

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public List<HistorialMedico> getHistorial() {
        return historial;
    }

    // --- Setters ---

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHistorial(List<HistorialMedico> historial) {
        this.historial = historial;
    }

    // --- Métodos funcionales ---

    public void editarPerfil(String telefono, String email) {
        this.telefono = telefono;
        this.email = email;
        System.out.println("Perfil del paciente actualizado.");
    }

    public void solicitarCita(LocalDate fecha, String sintomas, String diagnostico) {
        historial.add(new HistorialMedico(fecha, sintomas, diagnostico));
        System.out.println("Cita registrada en historial.");
    }

    public void verHistorial() {
        System.out.println("Historial médico de " + nombre + ":");
        if (historial.isEmpty()) {
            System.out.println("No hay registros médicos.");
        } else {
            List<HistorialMedico> historiales = getHistorial();
            historiales.forEach(System.out::println);
        }
    }
}
