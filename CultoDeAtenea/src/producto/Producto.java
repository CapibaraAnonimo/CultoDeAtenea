package producto;

import java.net.URL;
import java.util.Locale.IsoCountryCode;

public class Producto {
	private String nombre;
	private URL imagen;
	private String marca;
	private String categoria;
	private int precio;
	private String descripcion;
	//Campos Opcionales
	private double longitudTotal; //cm
	private double longitudHoja; //cm
	private String filo; //Tipo de filo: afilado, sin afilar, practica(hema)
	private double peso; //kg
	private double grosor; //mm
	private double anchura; //mm
	private String pomo; //Tipo de pomo
	private double pdb; //Punto de balance a partir de la guarda, cm
	private double longitudMango; //cm
	private String acero; //tipo de acero
	private String dimensiones; //dimensiones especificas
	private String tipo;
	private String fabricante;
	private IsoCountryCode pais;
	

}
