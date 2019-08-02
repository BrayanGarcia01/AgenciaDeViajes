    package negocio;

public class Cliente {
    private long idCliente;
    private String nombres;
    private String apellidos;
    private String fechaNac;
    private char genero;
    private String direccion;
    private String ciudadResidencia;
    private long celular;
    private String email;
    
    
    
    public Cliente() {
    }
    /**
     * 
     * @param idCliente id del cliente
     * @param nombres   nombres del cliente, primer nombre y segundo nombre separados por un espacio
     * @param apellidos apellidos del cliente, primer y segundo apellido separados por un espacio
     * @param fechanNac fecha nacimiento, en formayo yyyy-MM-dd
     * @param genero genero del cliente
     * @param direccion direccion del cliente
     * @param ciudadResidencia  ciudad de residencia del cliente
     * @param celular   celular del cliente 
     * @param email  email del cliente
     */
    public Cliente(long idCliente, String nombres, String apellidos, String fechanNac, char genero, String direccion, String ciudadResidencia, long celular, String email) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechanNac;
        this.genero = genero;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
        this.celular = celular;
        this.email = email;
    }

    

    public long getIdentificacion() {
        return idCliente;
    }

    public void setIdentificacion(long identificacion) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechanNac) {
        this.fechaNac = fechanNac;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * método para imprimir la informacion del cliente
     */
    public void imprimirInformacion(){
        System.out.println("Identificacion: "+idCliente);
        System.out.println("nombres: "+nombres);
        System.out.println("apellidos: "+apellidos);
        System.out.println("fechaNac: "+fechaNac);
        System.out.println("genero: "+genero);
        System.out.println("direccion: "+direccion);
        System.out.println("ciudadResidencia: "+ciudadResidencia);
        System.out.println("celular: "+celular);
        System.out.println("email: "+email);
        
    }
    
    
}
