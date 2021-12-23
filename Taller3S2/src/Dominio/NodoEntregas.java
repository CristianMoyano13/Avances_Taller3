package Dominio;

public class NodoEntregas {
	private Entregas entrega;
	NodoEntregas next;
	NodoEntregas prev;
	
	public NodoEntregas(Entregas entrega) {
		this.entrega = entrega;
		next = null;
		prev = null;
	}
	
	public Entregas getEntrega() {
		return entrega;
	}
	public void setEntrega(Entregas entrega) {
		this.entrega = entrega;
	}
	public NodoEntregas getNext() {
		return next;
	}
	public void setNext(NodoEntregas next) {
		this.next = next;
	}
	public NodoEntregas getPrev() {
		return prev;
	}
	public void setPrev(NodoEntregas prev) {
		this.prev = prev;
	}
	

}
