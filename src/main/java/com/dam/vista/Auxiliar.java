package com.dam.vista;

import com.dam.modelo.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Auxiliar {
    public static List<Paciente> crearPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        Paciente admin = new Paciente();
        admin.setIdPaciente(1);
        admin.setNombre("Juan");
        admin.setTelefono("611");
        admin.setEmail("juan@ejemplo.com");
        pacientes.add(admin);
        return pacientes;
    }
}
