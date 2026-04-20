package logica;

import java.time.LocalDateTime;


public class Comentario {
	private LocalDateTime fechaCreacion;
	private String email;
	private String ip;
	private String texto;
	
	public Comentario(String texto, String email, String ip) {
		this.texto = texto;
		this.email = email;
		this.ip = ip;
		fechaCreacion = LocalDateTime.now();
	}
	
	public String toString() {
		String res = email + "/" + "ip: " + ip + "\n";
		res+= texto + "\n";
		return res;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
}
