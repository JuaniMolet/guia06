package died.guia06;

public class CreditosInsuficientes extends Exception {
	//Constructores.
	public CreditosInsuficientes(){
	}
	public CreditosInsuficientes(String mensaje) {
		super(mensaje);
	}
}
