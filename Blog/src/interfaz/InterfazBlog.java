package interfaz;

import control.Controladora;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InterfazBlog {
	
    private static Controladora controladora = new Controladora();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    private static void menuGestionBlog(int idBlog) throws Exception {
        String opcion = "";
        while (!opcion.equals("3")) {
            try {
                System.out.println("\n----Administrando Blog #" + idBlog + "----");
                System.out.println("1. Crear nueva publicación");
                System.out.println("2. Seleccionar publicación para ver/comentar");
                System.out.println("3. Volver al menú principal");
                System.out.print("Opción : ");
                opcion = reader.readLine();

                if (opcion.equals("1")) {
                    System.out.print("Título: "); String t = reader.readLine();
                    System.out.print("Texto: "); String txt = reader.readLine();
                    System.out.print("Autor: "); String a = reader.readLine();
                    controladora.crearPublicacion(idBlog, t, txt, a);
                } else if (opcion.equals("2")) {
                	System.out.println("Publicaciones: \n" + controladora.obtenerPublicaciones(idBlog));
                    System.out.print("Código de la publicación: ");
                    int codPub = Integer.parseInt(reader.readLine());
                    System.out.println("\n----Publicación #" + codPub + "----");
                    System.out.println(controladora.obtenerPublicacion(idBlog, codPub));
                    menuGestionPublicacion(idBlog, codPub);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } 
    }
    private static void menuGestionPublicacion(int idBlog, int codPub) throws Exception {
        String opcion = "";
        while (!opcion.equals("3")) {
            System.out.println(controladora.obtenerPublicacion(idBlog, codPub));
            try {
                System.out.println("1. Agregar un comentario");
                System.out.println("2. Borrar un comentario");
                System.out.println("3. Regresar");
                System.out.print("Opción: ");
                opcion = reader.readLine();
                if (opcion.equals("1")) {
                    System.out.print("Email: "); String e = reader.readLine();
                    System.out.print("IP: "); String ip = reader.readLine();
                    System.out.print("Comentario: "); String c = reader.readLine();
                    controladora.agregarComentario(idBlog, codPub, e, ip, c);
                } else if (opcion.equals("2")) {
                    System.out.print("Posición del comentario a borrar: ");
                    int pos = Integer.parseInt(reader.readLine());
                    controladora.borrarComentario(idBlog, codPub, pos);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        String opcion = "";
        while (!opcion.equals("4")) {
            try {
            	System.out.println("----BLOGS---- \n" + controladora.obtenerBlogs());
                System.out.println("\n----OPCIONES----");
                System.out.println("1. Crear un blog");
                System.out.println("2. Trabajar con blog");
                System.out.println("3. Borrar Blog");
                System.out.println("4. Salir");
                System.out.print("Opción: ");
                opcion = reader.readLine();
                if (opcion.equals("1")) {
                    System.out.print("Nombre: "); 
                    String nombre = reader.readLine();
                    System.out.print("Descripción: ");
                    String desc = reader.readLine();
                    controladora.crearBlog(nombre, desc);
                } else if (opcion.equals("2")) {
                    System.out.print("Código del blog: ");
                    int cod = Integer.parseInt(reader.readLine());
                    controladora.revisarBlogExiste(cod);
                    menuGestionBlog(cod);
                } else if (opcion.equals("3")) {
                    System.out.print("Código del blog a borrar: ");
                    int id = Integer.parseInt(reader.readLine());
                    controladora.borrarBlog(id);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}