package died.guia06;

import java.util.Comparator;

public class AlumnoNroLibretaComparator implements Comparator<Alumno>{
	@Override
	public int compare(Alumno a1, Alumno a2) {
		if(a1.getNroLibreta() == a2.getNroLibreta()) {
			return a1.compareTo(a2);
		}
		else {
			return (a1.getNroLibreta() - a2.getNroLibreta());
		}
	}

}
