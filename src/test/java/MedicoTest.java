import com.dam.modelo.Medico;
import com.dam.modelo.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class MedicoTest {

    private Medico medico;

    @BeforeEach
    void setUp() {
        medico = new Medico(1, "Martínez", "Medicina General", "dr.martinez@hospital.com");
    }

    @Test
    void testDarAltaPaciente() {
        Paciente paciente = new Paciente(1, "Juan Pérez", "611234567", "juan@ejemplo.com");
        medico.darAltaPaciente(paciente);

        // Verificar que el paciente ha sido añadido correctamente
        List<Paciente> pacientes = medico.getPacientes();
        assertTrue(pacientes.contains(paciente), "El paciente debería estar en la lista.");
    }

    @Test
    void testDarBajaPaciente() {
        Paciente paciente = new Paciente(1, "Juan Pérez", "611234567", "juan@ejemplo.com");
        medico.darAltaPaciente(paciente);
        medico.darBajaPaciente(1);

        // Verificar que el paciente ha sido eliminado correctamente
        List<Paciente> pacientes = medico.getPacientes();
        assertFalse(pacientes.contains(paciente), "El paciente debería haber sido eliminado.");
    }

    @Test
    void testListarPacientes() {
        Paciente paciente = new Paciente(1, "Juan Pérez", "611234567", "juan@ejemplo.com");
        medico.darAltaPaciente(paciente);

        // Verificar que se lista el paciente correctamente
        assertEquals(1, medico.getPacientes().size(), "Debería haber un paciente en la lista.");
    }
}
