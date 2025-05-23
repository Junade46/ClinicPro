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

    /**
     *  Actualiza el perfil del paciente con nuevos datos de contacto.
     *
     *  Este metodo modifica el número de teléfono y el correo electrónico del paciente
     *  con los valores proporcionados y muestra un mensaje de confirmación en la consola.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     * @param telefono El nuevo numero de telefono del paciente.
     * @param email El nuevo correo electronico del paciente.
     */
    public void editarPerfil(String telefono, String email) {
        this.telefono = telefono;
        this.email = email;
        System.out.println("Perfil del paciente actualizado.");
    }

    /**
     * Registra una nueva cita medica en el historial del paciente.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     * @param fecha La fecha de la cita médica.
     * @param sintomas Descripcion de los sintomas del paciente.
     * @param diagnostico Diagnostico realizado en la cita.
     */
    public void solicitarCita(LocalDate fecha, String sintomas, String diagnostico) {
        historial.add(new HistorialMedico(fecha, sintomas, diagnostico));
        System.out.println("Cita registrada en historial.");
    }

    /**
     * Muestra en consola el historial medico completo del paciente.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     */
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
