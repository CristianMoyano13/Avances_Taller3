package Logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Dominio.Cliente;
import Dominio.EntregaD;
import Dominio.EntregaE;
import Dominio.EntregaV;
import Dominio.Localizacion;
import Dominio.NodoEntregas;

public class SistemaImpl implements Sistema {
	public ListaEntregas ListaEntregas;
	public LinkedList<Cliente> ListaClientes;
	public ArrayList<Localizacion> ListaCiudades;
	
	public SistemaImpl() {
		ListaEntregas = new ListaEntregas();
		ListaClientes = new LinkedList <Cliente>();
		ListaCiudades = new ArrayList <Localizacion>();
	}
	
	public void agregarCliente(String rut, String nombre, String apellido, int saldo, String ciudad) {
		Cliente c = new Cliente(rut,nombre,apellido,saldo,ciudad);
		ListaClientes.add(c);
	}
	
	public void agregarEntregaD(String codigo, String tipo, String rutRemitente, String rutDestinatario, int peso, int grosor) {
		EntregaD d = new EntregaD(codigo,tipo,rutRemitente,rutDestinatario,peso,grosor);
		ListaEntregas.insertarNodo(d);
	}
	
	public void agregarEntregaE(String codigo, String tipo, String rutRemitente, String rutDestinatario, int peso, int largo,int ancho, int profundidad) {
		EntregaE e = new EntregaE(codigo,tipo,rutRemitente,rutDestinatario,peso,largo,ancho,profundidad);
		ListaEntregas.insertarNodo(e);
	}
	
	public void agregarEntregaV(String codigo, String tipo, String rutRemitente, String rutDestinatario, String material,int peso) {
		EntregaV v = new EntregaV(codigo,tipo,rutRemitente,rutDestinatario,material,peso);
		ListaEntregas.insertarNodo(v);
		
	}
	
	public void agregarCiudad(String ciudad) {
		Localizacion l = new Localizacion(ciudad);
		ListaCiudades.add(l);
	}
	
	public void desplegar() {
		System.out.println("Lista (Principio a Final): ");
		NodoEntregas current = ListaEntregas.getFirst();
		while(current != null) {
			System.out.println("codigo de entrega: "+current.getEntrega().getCodigo()+current.getEntrega().getTipo());
			current = current.getNext();
		}
		System.out.println("Lista (final a principio): ");
		NodoEntregas current2 = ListaEntregas.getLast();
		while(current2 != null) {
			System.out.println("codigo de entrega: "+current2.getEntrega().getCodigo()+current2.getEntrega().getTipo());
			current2 = current2.getPrev();
		}
	}
	public void iniciar_sesion() { 
		boolean llave = true;
		while(llave) {
			System.out.println("INICIAR SESION");
			System.out.println("Escriba su rut con puntos y guion");
			System.out.println("Para finalizar el programa introduzca 0");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String rut = sc.nextLine();
			int posicion=clasificar_rut(CodificaRut(rut));
			if((rut).equals(null)) {
				llave=false;
				System.out.println("Se a finalizado la operacion");
			}
			else if (posicion==-1) {
				System.out.println("Escriba su contraseña");
				String contraseña = sc.nextLine();
				if((contraseña).equals("CHORIPAN123") || (contraseña).equals("choripan123") ) {
					//menu_admin();
				}
			}
			else if (posicion>=0) {
				System.out.println("Acceso Correcto");
				menu_cliente(posicion);
			}
			else if (posicion==-2) {
				System.out.println("Rut Invalido");
			}
			else{
				System.out.println("Usuario no existe");
				System.out.println("Desea crar un nuevo Usuario");
				System.out.println("Y/N");
				String clave = sc.nextLine();
				if((clave).equals("y")||(clave).equals("Y")) {
					nuevo_usuario(rut);
				}
				else if((clave).equals("n")||(clave).equals("N")) {
					/// NO SE HACE NADA
				}
				else{
					System.out.println("ERROR COMANDO NO RECONOCIDO");
				}
				System.out.println("Volviendo al principio de la operacion");
			}
		}
		
	}
	
	public String CodificaRut(String rut) {
		String[] partes;
		partes = rut.split("");
		if(partes.length==12) {
			if(partes[11].equals("k")) {
				partes[11]="K";
			}
			return partes[0]+partes[1]+partes[2]+partes[3]+partes[4]+partes[5]+partes[6]+partes[7]+partes[8]+partes[9]+partes[10]+partes[11];
		}
		else if(partes.length==11) {
			if(partes[10].equals("k")) {
				partes[10]="K";
			}
			return partes[0]+partes[1]+partes[2]+partes[3]+partes[4]+partes[5]+partes[6]+partes[7]+partes[8]+partes[9]+partes[10];
		}
		else {
			return null;
		}
	}
	
	public int clasificar_rut(String rut) {
		if(rut==null) {
			return -2;
		}
		if(rut.equals("ADMIN") || rut.equals("admin")) {
			return -1;
		}
		for(int i=0;i<ListaClientes.size();i++) {
			if(rut.equals(ListaClientes.get(i).getRut())) {
				return i;
			}
		}
		return -3;
	}
	
	public void nuevo_usuario(String rut) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("RUT: "+rut);
		System.out.println("Porfavor indique su nombre:");
		String nombre = sc.nextLine();
		System.out.println("Porfavor indique su apellido:");
		String apellido = sc.nextLine();
		System.out.println("Porfavor indique su ciudad:");
		String ciudad = sc.nextLine();
		agregarCliente(rut,nombre,apellido,0,ciudad);
	}
	
	public void menu_cliente(int posicion) {
		boolean llave =true;
		while(llave) {
			System.out.println("MENU CLIENTE: ");
			System.out.println("1)Realizar entrega");
			System.out.println("2)Recargar saldo");
			System.out.println("3)Ver tus entregas: ");
			System.out.println("4)Salir");
			Scanner sc = new Scanner(System.in);
			String seleccion = sc.nextLine();
			if((seleccion).equals("1")) {
				System.out.println("COMPRAR SKIN");
				realizar_entrega();
			}
			else if((seleccion).equals("2")) {
				System.out.println("COMPRAR PERSONAJE");
				recargar_saldo();
			}
			if((seleccion).equals("3")) {
				System.out.println("SKINS DISPONIBLES");
				ver_entregas();
			}
			else if((seleccion).equals("4")) {
				llave = false;
				System.out.println("Saliendo");
			}
			else {
				System.out.println("ERROR-NO SE RECONOCE EL COMMANDO");
			}
		}
	}
	public void realizar_entrega() {
		System.out.println("Tipo de entrega a realizar");
		Scanner sc = new Scanner(System.in);
		String tipo = sc.nextLine();
		if(tipo.equalsIgnoreCase("D")) {
			
		}
		if(tipo.equalsIgnoreCase("E")) {
			
		}
		if(tipo.equalsIgnoreCase("V")) {
			
		}
	}
	public void recargar_saldo() {
		System.out.println("Recargar Saldo");
		Scanner sc = new Scanner(System.in);
		String saldo = sc.nextLine();
	}
	public void ver_entregas() {
		System.out.println("Historial de entregas");
		for(int i=0;i<ListaClientes.size();i++) {
			
		}
	}
	
}
