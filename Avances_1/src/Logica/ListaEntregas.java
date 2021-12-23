package Logica;

import Dominio.Entregas;
import Dominio.NodoEntregas;

public class ListaEntregas {
	NodoEntregas first;
	NodoEntregas last;
	
	public ListaEntregas() {
		first=null;
		last=null;
	}
	
	public boolean isEmpty(){
		 return first==null; 
	}
	
	public void insertarNodo(Entregas entregas) {
		NodoEntregas nuevo = new NodoEntregas(entregas);
		if(isEmpty()) {
			last = nuevo;
		}
		else{
			first.setPrev(nuevo);
		}
		nuevo.setNext(first);
		first = nuevo;
		/*
		if(first==null) {
			first=nuevo;
			last=nuevo;
			first.setNext(first);
			last.setPrev(last);
		}
		else {
			last.setNext(nuevo);
			nuevo.setNext(first);
			nuevo.setNext(last);
			last=nuevo;
			first.setNext(last);
		}
		*/
	}

	public NodoEntregas getFirst() {
		return first;
	}

	public void setFirst(NodoEntregas first) {
		this.first = first;
	}

	public NodoEntregas getLast() {
		return last;
	}

	public void setLast(NodoEntregas last) {
		this.last = last;
	}
	

}
