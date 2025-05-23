package com.dam.modelo;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private int idMedico;
    private String nombre;
    private String especialidad;
    private String email;
    private List<Paciente> pacientes;

    // Constructor
    public Medico(int idMedico, String nombre, String especialidad, String email) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.email = email;
        this.pacientes = new ArrayList<>();
    }

    // --- Getters y setters ---

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    // --- Métodos de gestión de pacientes ---

    public void darAltaPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente " + paciente.getNombre() + " dado de alta.");
    }

    public void darBajaPaciente(int idPaciente) {
        boolean eliminado = pacientes.removeIf(p -> p.getIdPaciente() == idPaciente);
        if (eliminado) {
            System.out.println("Paciente con ID " + idPaciente + " dado de baja.");
        } else {
            System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
        }
    }

    public void editarInfoPaciente(Paciente paciente, String nuevoTelefono, String nuevoEmail) {
        paciente.setTelefono(nuevoTelefono);
        paciente.setEmail(nuevoEmail);
        System.out.println("Información del paciente actualizada.");
    }

    public void listarPacientes() {
        System.out.println("Pacientes del Dr. " + nombre + ":");
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            for (Paciente p : pacientes) {
                p.mostrarDatos();
                System.out.println("--------------------");
            }
        }
    }
}

