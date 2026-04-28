package control;
import java.util.Map;
import java.util.TreeMap;

import logica.Blog;


public class Controladora {
	private Map<Integer, Blog> blogs;
	
	private void revisarBlogExiste(int codigoBlog) throws Exception {
		if (!blogs.containsKey(codigoBlog))
			throw new Exception("Código de Blog no existe.");
	}
	private void agregarBlog1() throws Exception {
		crearBlog("Conociendo CR", "Lugares de Costa Rica para visitar en vacaciones");
		crearPublicacion(1, "Playa Tamarindo", "De las playas mas populares de la país, es muy buena para surfear.", "Araya Vlogs");
	    agregarComentario(1, 1, "anavargas102@gmail.com", "832.202.0.1", "Excelente lugar");
	    agregarComentario(1, 1, "luisfonseca@gmail.com", "842.532.0.2", "Quiero ir!");
	    crearPublicacion(1, "Monteverde", "Un lugar increíble para conectar con la naturaleza y relajarse", "Luisito Comunica");
	    agregarComentario(1, 2, "pedrocr123@gmail.com", "129.294.0.1", "Hermosas vistas!");
	    agregarComentario(1, 2, "mochilerosoy@gmail.com", "403.193.0.2", "Recomiendo llevar buen abrigo");
	}
	private void agregarBlog2() throws Exception {
	    crearBlog("Postres Deliciosos", "Recetas fáciles y ricas para amantes del dulce");
	    crearPublicacion(2, "Tres Leches", "Un postre suave y húmedo bañado en tres tipos de leche.", "Tia Florita");
	    agregarComentario(2, 3, "rositagonzalez@gmail.com", "372.722.0.1", "A mis nietos les encantó!");
	    agregarComentario(2, 3, "maumora@gmail.com", "431.238.0.2", "Yo le pondría un poco menos de azúcar");
	    crearPublicacion(2, "Brownies de Chocolate", "Postre clásico, ideal para los amantes del chocolate.", "Vivi cocina");
	    agregarComentario(2, 4, "juanitaperez@gmail.com", "129.294.0.1", "Se ven deliciosos!");
	    agregarComentario(2, 4, "davidvilla@gmail.com", "403.193.0.2", "Me quedaron como carbón");
	}
	
	public Controladora() throws Exception {
		blogs = new TreeMap<Integer, Blog>();
		agregarBlog1();
		agregarBlog2();
				
	}
	public void crearBlog(String nombre, String descripcion) {
		Blog b = new Blog(nombre, descripcion);
		blogs.put(b.getCodigo(), b);
	}
	public void borrarBlog(int codigoBlog) throws Exception {
		revisarBlogExiste(codigoBlog);
		blogs.remove(codigoBlog);
	}
	public Map<Integer, String> obtenerBlogs() {
		Map<Integer, String> res = new TreeMap<Integer, String>();
		for (Blog b : blogs.values()) {
			res.put(b.getCodigo(), b.getNombre());
		}
		return res;
	}
	public void crearPublicacion(int codigoBlog, String titulo, String texto, String creador) throws Exception {
		revisarBlogExiste(codigoBlog);
		Blog b = blogs.get(codigoBlog);
		b.crearPublicacion(titulo, texto, creador);
	}
	public Map<Integer, String> obtenerPublicaciones(int codigoBlog) throws Exception {
		revisarBlogExiste(codigoBlog);
		Blog b = blogs.get(codigoBlog);
		Map<Integer, String> res = b.getTitulos();
		return res;
	}
	public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) throws Exception {
		revisarBlogExiste(codigoBlog);
		Blog b = blogs.get(codigoBlog);
		String res = b.getPublicacion(codigoPublicacion);
		return res;
	}
	public void agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) throws Exception {
		revisarBlogExiste(codigoBlog);
		Blog b = blogs.get(codigoBlog);
		b.crearComentario(codigoPublicacion, texto, email, ip);
	}
	public void borrarComentario(int codigoBlog, int codigoPublicacion, int pos) throws Exception {
		revisarBlogExiste(codigoBlog);
		Blog b = blogs.get(codigoBlog);
		b.borrarComentario(codigoPublicacion, pos);
	}
}

