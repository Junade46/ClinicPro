package com.dam.vista;

import com.dam.modelo.Medico;
import com.dam.modelo.Paciente;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Medico medico = new Medico(1, "Martínez", "Medicina General", "dra.martinez@hospital.com");

    /**
     * Metodo principal que inicia la ejecucion del sistema de gestion medica.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     * @param args array de Strings.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        medico.setPacientes(Auxiliar.crearPacientes());

        while (true) {
            System.out.println("\n=== BIENVENIDO AL SISTEMA ===");
            System.out.println("¿Eres médico o paciente?");
            System.out.println("1. Medico");
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
                    System.out.println("Gracias por usar el sistema. ¡Adios!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    /**
     * Muestra y gestiona el menu interactivo del medico en la consola.
     *
     * El metodo continuara ejecutandose en bucle hasta que
     * el usuario seleccione la opcion para volver al menu principal.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     */
    public static void menuMedico(Scanner scanner) {
        while (true) {
            System.out.println("\n--- MENU MEDICO ---");
            System.out.println("1. Dar de alta paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Editar informacion de paciente");
            System.out.println("4. Dar de baja paciente");
            System.out.println("5. Volver al menu principal");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del paciente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Telefono: ");
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
                        System.out.print("Nuevo telefono: ");
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
                    System.out.println("Opcion no válida.");
            }
        }
    }

    /**
     * Muestra y gestiona el menú interactivo para pacientes en la consola.
     *
     * El metodo continuara ejecutándose en bucle hasta que
     * el usuario seleccione la opción para volver al menu principal.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     */
    public static void menuPaciente(Scanner scanner) {
        System.out.print("Introduce tu ID de paciente: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();
        Paciente paciente = buscarPaciente(medico, idPaciente);

        if (paciente == null) {
            System.out.println("Paciente no encontrado. Contacta con tu medico.");
            return;
        }

        while (true) {
            System.out.println("\n--- MENU PACIENTE ---");
            System.out.println("1. Ver historial medico");
            System.out.println("2. Solicitar cita");
            System.out.println("3. Editar perfil");
            System.out.println("4. Volver al menu principal");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    paciente.verHistorial();
                    break;

                case 2:
                    System.out.print("Fecha (dd/mm/aaaa): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());
                    System.out.print("Sintomas: ");
                    String sintomas = scanner.nextLine();
                    System.out.print("Diagnostico: ");
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
                    System.out.println("Opcion no valida.");
            }
        }
    }

    /**
     * Busca un paciente especifico por su ID en la lista de pacientes de un medico.
     *
     * @author Juande
     * @version 1.0
     * @since 23/05/2025
     * @param  idPaciente El ID del paciente que se desea buscar.
     * @return Devuelve el paciente a buscar si lo encuentra, si no, devuelve nulo
     */
    public static Paciente buscarPaciente(Medico medico, int idPaciente) {
        for (Paciente paciente : medico.getPacientes()) {
            if (paciente.getIdPaciente() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }
}
