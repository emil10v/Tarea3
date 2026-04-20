package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	private String titulo;
	private String texto;
	private String creador;
	private LocalDateTime fechaPublicacion;
	private static int consecutivo = 1;
	private int codigo;
	private List<Comentario> comentarios;
	
	public Publicacion(String titulo, String texto, String creador) {
		codigo = consecutivo;
		consecutivo++;
		this.titulo = titulo;
		this.texto = texto;
		this.creador = creador;
		fechaPublicacion = LocalDateTime.now();
		comentarios = new ArrayList<Comentario>();
	}
	public void comentar(String texto, String email, String ip) {
		Comentario c = new Comentario(texto, email, ip);
		comentarios.add(c);
	}
	public void borrarComentario(int pos) throws Exception {
		if (pos < 0 || pos > comentarios.size() ) {
			throw new Exception("Posición invalida");
		}
		else {
			comentarios.remove(pos);
		}
	}
	public String toString() {
		String res = titulo + "\n" + 
		"Creador: " + creador + "\n" + 
		"Fecha: " + fechaPublicacion.toString() + "\n" +
		texto + "\n\n" + "Comentarios: " + "\n";
		if (comentarios.isEmpty()) {
			res+= "No hay comentarios.";
		}
		else {
			for (Comentario c : comentarios) {
				res += c.toString();
			}
		}
		return res;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getCodigo() {
		return codigo;
	}
}
