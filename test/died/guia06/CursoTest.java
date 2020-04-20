package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	
	Alumno a1, a2, a3, a4;
	Curso c1, c2, c3, c4, c5;
	
	@BeforeEach
	public void init() {
	a1 = new Alumno("A", 23200);
	a2 = new Alumno("B", 23300);
	a3 = new Alumno("C", 23400);
	a4 = new Alumno("D", 23500);

	c1 = new Curso(1, "Curso1", 1, 35, 100, 50);
	c2 = new Curso(2, "Curso2", 1, 0, 200, 100);
	c3 = new Curso(3, "Curso3", 1, 30, 300, 100);
	c4 = new Curso(4, "Curso4", 1, 40, 50, 100);
	c5 = new Curso(4, "Curso5", 1, 40, 400, 100);
	
	//Creditos insuficientes.
	a1.inscripcionAceptada(c1);
	a1.inscripcionAceptada(c2);
	
	//Curso sin cupos.
	a2.inscripcionAceptada(c1);
	a2.inscripcionAceptada(c2);
	a2.aprobar(c1);//creditos 100.
	a2.aprobar(c2);//creditos 300.
	
	//Falla cantidad de cursos del mismo ciclo lectivo.
	a3.inscripcionAceptada(c1);
	a3.inscripcionAceptada(c2);
	a3.inscripcionAceptada(c3);
	a3.inscripcionAceptada(c4);//alumno con 4 cursos del mismo ciclo lectivo.
	a3.inscripcionAceptada(c5);
	a3.aprobar(c5);//creditos 300.
	
	//Inscripcion correcta.
	a4.inscripcionAceptada(c1);
	a4.inscripcionAceptada(c3);
	a4.inscripcionAceptada(c5);
	a4.aprobar(c5);
	
	//Alumnos en forma alfabetica.
	c1.inscribir(a4);//D
	c1.inscribir(a3);//C
	c1.inscribir(a2);//B
	c1.inscribir(a1);//A

	
	
	}
	
	/**
	 * Testea la situacion donde el metodo falla porque el alumno no tiene los creditos necesarios para inscribirse a un curso.
	 * Alumno con cupos disponibles y sin estar inscripto en mas de 3 cursos del mismo ciclo lectivo.
	 * El alumno a1 no aprobó ningun curso, por ende, no tiene creditos necesarios.
	 */
	@Test
	void alumnoSinCreditosNecesarios() {
		boolean esperado = c1.inscribir(a1);
		assertFalse(esperado, "No tiene los creditos necesarios para inscribirse en el curso");
	}
	
	/**
	 * Testea la situacion donde el metodo falla proque el curso no tiene cupos disponibles.
	 * Alumno con creditos necesarios para inscribirse y sin estar inscripto en mas de 3 cursos del mismo ciclo lectivo.
	 * El curso c2 es inicializado con 0 cupos disponibles.
	 */
	@Test
	void cursoSinCuposDisponibles() {
		boolean esperado = c2.inscribir(a2);
		assertFalse(esperado, "El curso no puede inscribir por falta de cupos");
	}
	
	/**
	 * Testea la situación donde el metodo fallá porque el alumno está inscripto en mas de 3 cursos del mismo ciclo lectivo.
	 * Alumno con creditos necesarios para inscribirse y el curso con cupos disponibles.
	 * El alumno esta inscripto en mas de 3 cursos de un mismo ciclo lectivo. 
	 */
	@Test 
	void alumnoInscriptoEnMasDeTresCursosDelMismoCicloLectivo() {
		boolean esperado = c4.inscribir(a3);
		assertFalse(esperado, "El alumno esta inscripto en mas de tres cursos del mismo ciclo lectivo");
	}
	
	/**
	 * Testea la situacion donde el metodo inscribe un alumno en un curso dado que cumple con todas las condiciones.
	 */
	@Test
	void AlumnoInscriptoEnCurso() {
		boolean esperado = c4.inscribir(a4);
		assertTrue(esperado, "El alumno se ha podido inscribir al curso");
	}
	

}
