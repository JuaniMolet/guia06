package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class App {
	public static void main(String[] args) throws IOException {
		Alumno a1, a2, a3;
		Curso c1, c2;
		
		a1 = new Alumno("Juan Perez", 23200);
		a2 = new Alumno("Bruno agreti", 23300);
		a3 = new Alumno("Pepe Lomas", 23400);
		c1 = new Curso(1, "Curso1", 1, 35, 100, 50);
		c2 = new Curso(2, "Curso2", 2, 35, 200, 100);
		
		a1.inscripcionAceptada(c1); //a1 en cursando.
		a1.inscripcionAceptada(c2);
		a2.inscripcionAceptada(c1);
		a2.inscripcionAceptada(c2);
		
		a3.aprobar(c2);
		a3.aprobar(c1);
		a1.aprobar(c2);
		//a1.aprobar(c1);
		//a2.aprobar(c2);
		a2.aprobar(c1);
		
		c1.inscribir(a3);
		c1.inscribir(a2);
		c1.inscribir(a1);
		
		//c1.imprimirInscriptos();
		//c1.imprimirInscriptosPorCreditos();
		c1.imprimirInscriptosPorLibreta();
		
	}
}
