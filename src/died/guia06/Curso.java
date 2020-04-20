package died.guia06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;
import died.guia06.Comparator;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */

public class Curso{
	
	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	private Registro log;
	
	//CONSTRUCTORES.
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, Integer creditos,
			Integer creditosRequeridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.inscriptos = new ArrayList<Alumno>();
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.log = new Registro();
	}
	
	//METODOS.
	/**
	 * Este metodo, verifica si el alumno se puede inscribir y si es asi lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que esta inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultaneo a no mas de 3 cursos del mismo ciclo lectivo.
	 */
	
	public boolean inscribir(Alumno a) {
		int contadorCursos = 0;
		for(Curso unCurso : a.getCursando()) {
			if(unCurso.getCicloLectivo() == cicloLectivo) {
				contadorCursos++;
			}
		}
		if((a.creditosObtenidos()>creditosRequeridos) && (cupo>0) && contadorCursos<4) {
			this.inscriptos.add(a);
			return true;
		}
		return false;
	}
	
	/**
	 * imprime los inscriptos en orden alfabetico. 
	 */
	public void imprimirInscriptos() {
		ArrayList<String> lista = new ArrayList<String>();
		lista = this.getInscriptosPorNombre();
		Collections.sort(lista);
		System.out.println(lista);
	}
	
	/**
	 * Imprime los inscriptos ordenados por los creditos de cada alumno, de menor a mayor.
	 */
	public void imprimirInscriptosPorCreditos() {
		Collections.sort(inscriptos, new AlumnoCreditosComparator());
		System.out.println(this.getInscriptosPorNombre());
	} 
	/**
	 * Imprime los inscriptos ordenados por los numeros de libreta de cada alumno, de menor a mayor.
	 */
	
	public void imprimirInscriptosPorLibreta() {
		Collections.sort(inscriptos, new AlumnoNroLibretaComparator());
		System.out.println(this.getInscriptosPorNombre());
	}
	

	//SETERS Y GETERS.
	public Integer creditos(){
		return creditos; 
	}
	
	public void setCreditos(Integer unCredito) {
		this.creditos = unCredito;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	
	/**
	 * Devuelve la lista de inscriptos por nombre.
	 */
	public ArrayList<String> getInscriptosPorNombre() {
		ArrayList<String> a = new ArrayList<String>();
		for(Alumno unAlumno : inscriptos) {
			a.add(unAlumno.getNombre());
		}		
		return a;
	}
	
	/**
	 * Devuelve la lista de inscriptos por Nro de libreta.
	 */
	public List<Alumno> getInscriptosPorNroLibreta() {
		ArrayList a = new ArrayList<Integer>();
		
		for(Alumno unAlumno : inscriptos) {
			a.add(unAlumno.getNroLibreta());
		}		
		return a;
	}

	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}
	
} 
