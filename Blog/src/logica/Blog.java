package logica;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Blog {
	private String nombre;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private static int consecutivo = 1;
	private int codigo = 1;
	private Map<Integer, Publicacion> publicaciones;
	
	private void revisarPublicacionExiste(int codigo) throws Exception {
		if (!publicaciones.containsKey(codigo))
			throw new Exception("Codigo de publicación invalido.");
	}
	
	public Blog (String nombre, String descripcion) {
		codigo = consecutivo;
		consecutivo++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		fechaCreacion = LocalDateTime.now();
		publicaciones = new TreeMap<Integer, Publicacion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void crearPublicacion(String titulo, String texto, String creador) {
		Publicacion p = new Publicacion(titulo, texto, creador);
		publicaciones.put(p.getCodigo(), p);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getPublicacion(int codigo) throws Exception {
		revisarPublicacionExiste(codigo);
		Publicacion p = publicaciones.get(codigo);
		return p.toString();
	}
	
	public void crearComentario(int codigo, String texto, String email, String ip) throws Exception {
		revisarPublicacionExiste(codigo);
		Publicacion p = publicaciones.get(codigo);
		p.comentar(texto, email, ip);
	}
	
	public void borrarComentario(int codigo, int pos) throws Exception {
		revisarPublicacionExiste(codigo);
		Publicacion p = publicaciones.get(codigo);
		p.borrarComentario(pos);
	}
	
	public Map<Integer, String> getTitulos() {
		Map<Integer, String> titulos = new TreeMap<Integer, String>();
		for ( Publicacion p: publicaciones.values()) {
			titulos.put(p.getCodigo(), p.getTitulo());
		}
		return titulos;
	}
	
	
}
