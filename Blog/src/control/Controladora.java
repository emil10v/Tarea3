package control;
import java.util.Map;
import java.util.TreeMap;

import logica.Blog;
import logica.Publicacion;


public class Controladora {
	private Map<Integer, Blog> blogs;
	
	private void revisarBlogExiste(int codigoBlog) throws Exception {
		if (!blogs.containsKey(codigoBlog))
			throw new Exception("Codigo de Blog no existe.");
	}
	
	public Controladora() {
		blogs = new TreeMap<Integer, Blog>();
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
			res.put(b.getCodigo(), b.getNombre())
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
	
	
}

