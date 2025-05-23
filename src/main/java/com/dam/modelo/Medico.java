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

    /**
     * Agrega un nuevo paciente a la lista de pacientes del médico.
     *
     * Este metodo registra un nuevo paciente en el sistema añadiéndolo a la lista interna
     * de pacientes del medico.
     * Después de la adicion, se muestra un mensaje de confirmación
     * en la consola indicando el nombre del paciente dado de alta.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     */
    public void darAltaPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente " + paciente.getNombre() + " dado de alta.");
    }

    /**
     * Elimina un paciente de la lista de pacientes del medico según su ID.
     *
     * Este metodo busca al paciente con el ID especificado dentro de la lista de pacientes del medico.
     * Si lo encuentra, lo elimina de la lista y muestra un mensaje de confirmacion.
     * Si no se encuentra un paciente con ese ID, se muestra un mensaje indicando que no se encontro.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     * @param idPaciente El ID del paciente que se desea dar de baja.
     */
    public void darBajaPaciente(int idPaciente) {
        boolean eliminado = pacientes.removeIf(p -> p.getIdPaciente() == idPaciente);
        if (eliminado) {
            System.out.println("Paciente con ID " + idPaciente + " dado de baja.");
        } else {
            System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
        }
    }

    /**
     * Actualiza la informacion de contacto de un paciente.
     *
     * Este metodo modifica el numero de telefono y el correo electronico de un paciente
     * utilizando los nuevos valores proporcionados. Despues de actualizar los datos,
     * se muestra un mensaje de confirmacion en la consola.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     * @param nuevoTelefono El nuevo numero de telefono del paciente.
     * @param nuevoEmail El nuevo correo electronico del paciente.
     */
    public void editarInfoPaciente(Paciente paciente, String nuevoTelefono, String nuevoEmail) {
        paciente.setTelefono(nuevoTelefono);
        paciente.setEmail(nuevoEmail);
        System.out.println("Informacion del paciente actualizada.");
    }

    /**
     * Muestra en consola la lista de pacientes asignados al medico.
     *
     * Este metodo imprime el nombre del medico seguido de una lista de sus pacientes.
     * Si no hay pacientes registrados, se muestra un mensaje indicandolo.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     */
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

