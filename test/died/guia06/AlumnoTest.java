package died.guia06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	Alumno a1, a2, a3;
	Curso c1, c2;
	
	@BeforeEach
	public void init() {
	a1 = new Alumno("A", 23200);
	a2 = new Alumno("B", 23300);
	a3 = new Alumno("B", 23400);
	c1 = new Curso(1, "Curso1", 1, 35, 100, 50);
	c2 = new Curso(2, "Curso2", 2, 35, 200, 100);
	a1.inscripcionAceptada(c1);
	a1.inscripcionAceptada(c2);
	a2.inscripcionAceptada(c1);
	a2.inscripcionAceptada(c2);
	a2.aprobar(c1);
	a2.aprobar(c2);
	
	}
	
	@Test
	void testInscripcionAceptada() {
		//Testea que se agregue un curso al ejecutar el metodo InscripcionAceptada.
		boolean prueba = a1.getCursando().contains(c1);
		assertTrue(prueba,"La inscripcion se ha realizado con exito");
	}
	
	@Test
	void testResultadoCorrectoCreditosObtenidos() {
	    //Testea que creditosObtenidos() sume bien los creditos de todos los cursos.
		Integer prueba = a2.creditosObtenidos();
		assertEquals(300, prueba,  "Los resultados son iguales");
	}

	
	@Test
	void testAprobarEliminaCursoDeCursando() {
		//Testea que al ejecutar el metodo Aprobar() se elimina el curso de la lista de cursos cursando.
		a1.aprobar(c1);
		boolean prueba1 = a1.getCursando().contains(c1);
		assertFalse(prueba1, "Se ha eliminado el curso de la lista");
	}
	
	@Test
	void testAprobarAgregaCursoAprobados() {
		//Testea que al ejecutar el metodo Aprobar() se agrega el curso a la lista de Aprobados.
		a1.aprobar(c1);
		boolean prueba1 = a1.getAprobados().contains(c1);
		assertTrue(prueba1, "Se ha agregado el curso a la lista");
	}
	
	@Test
	void testCompareToResultadoMayorACero() {
		//Testea que compareTo devuelva un resultado mayor a cero.
		int resultado = a1.compareTo(a2);
		boolean esperado1 = resultado>0;
		assertTrue(esperado1);
	}
	@Test
	void testCompareToResultadoCero() {
		//Testea que compareTo devuelva un resultado menor a cero.
		int resultado = a2.compareTo(a3);
		boolean esperado = (resultado == 0);
		assertTrue(esperado);
	}
	
	@Test
	void testCompareToResultadoMenorACero() {
		//Testea que compareTo devuelva un resultado igual a cero.
		int resultado = a2.compareTo(a1);
		boolean esperado = resultado<0;
		assertTrue(esperado);
	}
	
	

}
