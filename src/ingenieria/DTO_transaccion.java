
package ingenieria;

public class DTO_transaccion {
    //ALUMNO
    public String nombre;
    public String apellido;
    public String usuario;
    public String contrasenia;
    //PROFESOR
    public String nombrep;
    public String apellidop;
    public String usuariop;
    public String contraseniap; 
    
    public DTO_transaccion(String usuarioa,String contraseniaa,String nombrea,String apellidoa) {
        this.usuario =usuarioa;
        this.contrasenia=contraseniaa;
        this.nombre = nombrea;
        this.apellido = apellidoa;
    }

}
