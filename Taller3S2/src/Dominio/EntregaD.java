package Dominio;

public class EntregaD extends Entregas {
	private int peso;
	private int grosor;
	
	public EntregaD(String codigo, String tipo, String rutRemitente, String rutDestinatario, int peso, int grosor) {
		super(codigo, tipo, rutRemitente, rutDestinatario);
		this.peso = peso;
		this.grosor = grosor;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getGrosor() {
		return grosor;
	}

	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}
	
	
}
