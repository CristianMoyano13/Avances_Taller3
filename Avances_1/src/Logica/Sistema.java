package Logica;

public interface Sistema {
	void agregarCliente(String rut, String nombre, String apellido, int saldo, String ciudad);
	void agregarEntregaD(String codigo, String tipo, String rutRemitente, String rutDestinatario, int peso, int grosor);
	void agregarEntregaE(String codigo, String tipo, String rutRemitente, String rutDestinatario, int peso, int largo,int ancho, int profundidad);
	void agregarEntregaV(String codigo, String tipo, String rutRemitente, String rutDestinatario, String material,int peso);
	void agregarCiudad(String ciudad);
	void iniciar_sesion();
	int clasificar_rut(String rut);
	void nuevo_usuario(String nombre);
	void desplegar();
}
