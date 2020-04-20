package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	//CONSTRUCTORES
	public Alumno (String unNombre, Integer unNroLibreta) {
		nombre = unNombre;
		nroLibreta = unNroLibreta;
		cursando = new ArrayList<Curso>();
		aprobados = new ArrayList<Curso>();
	}
	
	//METODOS
	public int creditosObtenidos() {
		Integer creditos = 0;
		for(Curso unCurso : aprobados ) {
			creditos += unCurso.creditos();
		}
		return creditos;
	}
	
	public void aprobar(Curso a) {
		cursando.remove(a);
		aprobados.add(a);
	}
	
	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}
	
	public boolean equals(Alumno unAlumno) {
		if(nroLibreta == unAlumno.nroLibreta) {
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Alumno unAlumno) {
		return unAlumno.nombre.compareTo(nombre);
	}
	
	//SETERS Y GETTTERS.
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}
	
	public List<String> getCursandoPorNombre() {
		List<String> lista = new ArrayList<String>();
		for(Curso unCurso : cursando) {
			lista.add(unCurso.getNombre());
		}
		return lista;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}
	
		
}
