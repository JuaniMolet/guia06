package died.guia06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class App {
	public static void main(String[] args){
		
		Alumno a1 = new Alumno("Juan", 10);
		Alumno a2 = new Alumno("Pablo", 11);
		Alumno a3 = new Alumno("Gabriel", 16);
		Alumno a4 = new Alumno("Hugo", 19);
		Alumno a5 = new Alumno("Maria", 14);
		Alumno a6 = new Alumno("Pepe", 8);
		
		Curso c1 = new Curso(1, "Curso1", 1, 35, 15, 5);
		Curso c2 = new Curso(1, "Curso2", 1, 20, 20, 10);
		Curso c3 = new Curso(1, "Curso3", 1, 25, 30, 20);
		Curso c4 = new Curso(1, "Curso4", 1, 30, 40, 30);
		
		//Inscribir al alumno Juan al curso c2.
		a1.inscripcionAceptada(c1);
		System.out.println("Lista de cursos actualmente cursando de Juan: "+a1.getCursandoPorNombre());
		a1.aprobar(c1);//Juan 15 Creditos
		System.out.println("Cursos aprobados por Juan:" +a1.getAprobadosPorNombre());
		System.out.println("Creditos de Juan: "+a1.creditosObtenidos());
		c2.inscribir(a1);
		System.out.println("Alumnos en curso c2: "+c2.getInscriptosPorNombre());
		
		//Inscribir alumnos al curso c2.
		a2.aprobar(c1);//Pablo 15 Creditos
		a3.aprobar(c2);//Gabriel 20 Creditos
		a4.aprobar(c3);//Hugo 30 Creditos
		a5.aprobar(c1);
		a5.aprobar(c2);//Maria 35 Creditos
		c2.inscribir(a2);
		c2.inscribir(a3);
		c2.inscribir(a4);
		c2.inscribir(a5);
		System.out.println("Alumnos en curso c2: "+c2.getInscriptosPorNombre());
		System.out.println("Mostrar el curso en orden alfabetico: ");
		c2.imprimirInscriptos();
		System.out.println("Mostrar el curso ordenado por Nro de libreta: ");
		c2.imprimirInscriptosPorLibreta();
		System.out.println("Mostrar el curso ordenado por Creditos: ");
		c2.imprimirInscriptosPorCreditos();
		
		
	}
}
