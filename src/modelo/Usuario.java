package modelo;
import java.util.ArrayList;
public class Usuario {
    private String nombre;
    private int identificacion;
    private String fechaNacimiento;
    private String direccion;

    private ArrayList<Cuenta> Cuentas;

    /**
     * contructor para "persona"
     * @param nombre
     * @param identificacion
     * @param fechaNacimiento
     * @param direccion
     * @author David Huertas
     * @since 06/10/2022
     */
    public Usuario(String nombre, int identificacion, String fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.Cuentas = new ArrayList<Cuenta>();
    }

    /**
     * setter para nombre
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * getter para nombre
     * @author David Huertas
     * @since 06/10/2022
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * setter para identificacion
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * getter para identificacion
     * @author David Huertas
     * @since 06/10/2022
     */
    public int getIdentificacion() {
        return identificacion;
    }

    /**
     * setter para fecha de nacimiento
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * getter para fecha de nacimiento
     * @author David Huertas
     * @since 06/10/2022
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * setter para direccion
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * getter para direccion
     * @author David Huertas
     * @since 06/10/2022
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * setter para cuentas
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setCuentas(ArrayList<Cuenta> Cuentas) {
        this.Cuentas = Cuentas;
    }

    /**
     * getter para cuentas
     * @author David Huertas
     * @since 06/10/2022
     */
    public ArrayList<Cuenta> getCuentas() {
        return Cuentas;
    }

    /**
     * crea una cuenta nueva
     * @param c
     * @param saldo (>50.000)
     * @author David Huertas
     * @since 06/10/2022
     */
    public boolean crearNuevaCuenta(Usuario c,double saldo){
        int id = (int) Math.floor(Math.random()*(9999999-1000000+1)+1000000);
        Cuenta temp= new Cuenta(id,saldo);
        boolean validador = false;
        for (Cuenta cuenta : Cuentas) {
            if (temp.equals(cuenta)) {
                validador = true;
                break;
            }
        }
        if (saldo < 50.000){
            validador= true;
        }
        if(!validador) {
            Cuentas.add(temp);
        }
        return validador;
    }

    /**
     * compara dos variables usuario
     * @param o es el objeto a comparar
     * @author David Huertas
     * @since 06/10/2022
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return getIdentificacion() == usuario.getIdentificacion();
    }

    /**
     * imprime Usuario
     * @author David Huertas
     * @since 06/10/2022
     */
    @Override
    public String toString() {
        return "usuario{" + "nombre='" + nombre + '\'' +", identificacion=" + identificacion + ", fechaNacimiento='" + fechaNacimiento + '\'' + ", direccion='" + direccion + '\'' + ", cuentas=" + Cuentas + '}';
    }
}
