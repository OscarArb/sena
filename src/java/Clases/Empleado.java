package Clases;

/**
 *
 * @author Usuario
 */
public class Empleado {
    int id;
    String dni;
    String nombre;
    String telefono;
    String user;
    

    public Empleado() {
    }

    public Empleado(int id, String dni, String nombre, String telefono, String user) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.user = user;
        this.telefono=telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}

