package com.dam.vista;

import com.dam.modelo.Medico;
import com.dam.modelo.Paciente;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Medico medico = new Medico(1, "Martínez", "Medicina General", "dra.martinez@hospital.com");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        medico.setPacientes(Auxiliar.crearPacientes());

        while (true) {
            System.out.println("\n=== BIENVENIDO AL SISTEMA ===");
            System.out.println("¿Eres médico o paciente?");
            System.out.println("1. Médico");
            System.out.println("2. Paciente");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuMedico(scanner);
                    break;
                case 2:
                    menuPaciente(scanner);
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema. ¡Adiós!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void menuMedico(Scanner scanner) {
        while (true) {
            System.out.println("\n--- MENÚ MÉDICO ---");
            System.out.println("1. Dar de alta paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Editar información de paciente");
            System.out.println("4. Dar de baja paciente");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del paciente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Paciente nuevo = new Paciente(id, nombre, tel, email);
                    medico.darAltaPaciente(nuevo);
                    break;

                case 2:
                    medico.listarPacientes();
                    break;

                case 3:
                    System.out.print("ID del paciente a editar: ");
                    int idEdit = scanner.nextInt();
                    scanner.nextLine();
                    Paciente pEdit = buscarPaciente(medico, idEdit);
                    if (pEdit != null) {
                        System.out.print("Nuevo teléfono: ");
                        String nuevoTel = scanner.nextLine();
                        System.out.print("Nuevo email: ");
                        String nuevoEmail = scanner.nextLine();
                        medico.editarInfoPaciente(pEdit, nuevoTel, nuevoEmail);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("ID del paciente a dar de baja: ");
                    int idBaja = scanner.nextInt();
                    scanner.nextLine();
                    medico.darBajaPaciente(idBaja);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void menuPaciente(Scanner scanner) {
        System.out.print("Introduce tu ID de paciente: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();
        Paciente paciente = buscarPaciente(medico, idPaciente);

        if (paciente == null) {
            System.out.println("Paciente no encontrado. Contacta con tu médico.");
            return;
        }

        while (true) {
            System.out.println("\n--- MENÚ PACIENTE ---");
            System.out.println("1. Ver historial médico");
            System.out.println("2. Solicitar cita");
            System.out.println("3. Editar perfil");
            System.out.println("4. Volver al menú principal");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    paciente.verHistorial();
                    break;

                case 2:
                    System.out.print("Fecha (dd/mm/aaaa): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());
                    System.out.print("Síntomas: ");
                    String sintomas = scanner.nextLine();
                    System.out.print("Diagnóstico: ");
                    String diagnostico = scanner.nextLine();
                    paciente.solicitarCita(fecha, sintomas, diagnostico);
                    break;

                case 3:
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTel = scanner.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    paciente.editarPerfil(nuevoTel, nuevoEmail);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static Paciente buscarPaciente(Medico medico, int idPaciente) {
        for (Paciente p : medico.getPacientes()) {
            if (p.getIdPaciente() == idPaciente) {
                return p;
            }
        }
        return null;
    }
}
