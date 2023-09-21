package ingenieria;

public class ProfesorDTO {
    public String nombrep;
    public String apellidop;
    public String usuariop;
    public String contraseniap; 
    
    public ProfesorDTO(String usuariop,String contraseniap,String nombrep,String apellidop) {
        this.usuariop =usuariop;
        this.contraseniap=contraseniap;
        this.nombrep = nombrep;
        this.apellidop = apellidop;
    }

}