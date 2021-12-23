package Dominio;

public class EntregaV extends Entregas{
	private String material;
	private int peso;
	
	public EntregaV(String codigo, String tipo, String rutRemitente, String rutDestinatario, String material,int peso) {
		super(codigo, tipo, rutRemitente, rutDestinatario);
		this.material = material;
		this.peso = peso;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
}
