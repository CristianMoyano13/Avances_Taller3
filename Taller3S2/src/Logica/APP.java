package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class APP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Sistema sistema = (Sistema) new SistemaImpl();
		Carga_Localizaciones(sistema);
		Carga_Clientes(sistema);
		Carga_Entregas(sistema);
		//sistema.desplegar();
	}
	
	private static void Carga_Localizaciones(Sistema sistema) throws NumberFormatException, IOException {
		File archivo = new File ("C:\\Users\\franc\\eclipse-workspace\\Taller3S2\\localizacion"); 
		FileReader text = new FileReader (archivo); 
		BufferedReader reader = new BufferedReader(text); 
		String linea;
		String[] partes;
		while((linea = reader.readLine())!=null){
			partes = linea.split(",");
			String ciudad= partes[0];
			sistema.agregarCiudad(ciudad);
		}
		reader.close();
	}
	
	private static void Carga_Clientes(Sistema sistema) throws NumberFormatException, IOException {
		File archivo = new File ("C:\\Users\\franc\\eclipse-workspace\\Taller3S2\\clientes"); 
		FileReader text = new FileReader (archivo); 
		BufferedReader reader = new BufferedReader(text); 
		String linea;
		String[] partes;
		while((linea = reader.readLine())!=null){
			partes = linea.split(",");
			String rut= partes[0];
			String nombre= partes[1];
			String apellido= partes[2];
			int saldo = Integer.parseInt(partes[3]);
			String ciudad= partes[4];
			sistema.agregarCliente(rut, nombre, apellido, saldo, ciudad);
		}
		reader.close();
	}
	
	private static void Carga_Entregas(Sistema sistema) throws NumberFormatException, IOException {
		File archivo = new File ("C:\\Users\\franc\\eclipse-workspace\\Taller3S2\\entregas"); 
		FileReader text = new FileReader (archivo); 
		BufferedReader reader = new BufferedReader(text); 
		String linea;
		String[] partes;
		while((linea = reader.readLine())!=null){
			partes = linea.split(",");
			String codigo= partes[0];
			String tipo= partes[1];
			String rutRemitente= partes[2];
			String rutDestinatario= partes[3];
			if(tipo.equals("D")) {
				int peso= Integer.parseInt(partes[4]);
				int grosor= Integer.parseInt(partes[5]);
				sistema.agregarEntregaD(codigo, tipo, rutRemitente, rutDestinatario, peso, grosor);
			}
			if(tipo.equals("E")) {
				int peso= Integer.parseInt(partes[4]);
				int largo= Integer.parseInt(partes[5]);
				int ancho= Integer.parseInt(partes[6]);
				int profundidad= Integer.parseInt(partes[7]);
				sistema.agregarEntregaE(codigo, tipo, rutRemitente, rutDestinatario, peso, largo, ancho, profundidad);
			}
			if(tipo.equals("V")) {
				String material= partes[4];
				int peso= Integer.parseInt(partes[5]);
				sistema.agregarEntregaV(codigo, tipo, rutRemitente, rutDestinatario, material, peso);
			}
		}
		reader.close();
	}

}
