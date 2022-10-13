package controlador;

import modelo.Usuario;

import java.util.ArrayList;
/**
 * contenedor del arraylist usuario
 * @author David Huertas
 * @since 06/10/2022
 */
public class Banco {

    public ArrayList<Usuario> clientes;

    /**
     * contructor del banco
     * @author David Huertas
     * @since 06/10/2022
     */
    public Banco() {
        this.clientes = new ArrayList<Usuario>();
    }

    /**
     * setter para usuarios
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setClientes() {
        this.clientes = clientes;
    }

    /**
     * getter para usuarios
     * @return usuarios
     * @author David Huertas
     * @since 06/10/2022
     */
    public ArrayList<Usuario> getClientes() {
        return clientes;
    }

    /**
     * crea un usuario y lo agrega al arraylist clientes
     * @param nombre
     * @param identificacion
     * @param fechaNacimiento
     * @param direccion
     * @return respuesta boolena
     * @author David Huertas
     * @since 06/10/2022
     */
    public boolean crearCliente(String nombre, int identificacion, String fechaNacimiento, String direccion){
        Usuario temp= new Usuario(nombre,identificacion,fechaNacimiento,direccion);
        boolean repetido = false;
        for (Usuario cliente : clientes) {
            if (temp.getIdentificacion() == cliente.getIdentificacion()) {
                repetido = true;
                break;
            }
        }
        if (!repetido) {
            clientes.add(temp);
            return true;
        }else{
            return false;
        }
    }

    /**
     * da el cliente respectivo al id ingresada
     * @param idCliente
     * @return cliente
     * @author David Huertas
     * @since 06/10/2022
     */
    public Usuario mostrarUsuario( int idCliente ){
        for (Usuario cliente : clientes) {
            if (idCliente == cliente.getIdentificacion()) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * crea una cuenta
     * @param idCliente
     * @return respuesta booleana
     * @author David Huertas
     * @since 06/10/2022
     */
    public boolean crearCuentaCliente( int idCliente, Double saldo){
        boolean validacion = false;
        int i;
        if(saldo>=50.000){
            for( i = 0; i<clientes.size(); i++){
                if(idCliente == clientes.get(i).getIdentificacion()){
                    clientes.get(i).crearNuevaCuenta(clientes.get(i),saldo);
                    validacion = true;
                }
            }
        }
        return validacion;
    }

    /**
     * lista todos los clientes y sus cuentas
     * @return informacion de todos los usuarios
     * @author David Huertas
     * @since 06/10/2022
     */
    public String listarClientes() {
        StringBuilder listaTotUsuarios = new StringBuilder();
        for(int i = 0; i < this.clientes.size(); i++){
            listaTotUsuarios.append(i + 1).append(". ").append(this.clientes.get(i)).append("\n");
        }
        return listaTotUsuarios.toString();
    }

    /**
     * deposita el valor definido en la cuenta destinataria
     * @param cliente
     * @param deposito
     * @param indiceCuenta
     * @return respuesta booleana
     * @author David Huertas
     * @since 06/10/2022
     */
    public boolean depositar(Double deposito,int cliente, int indiceCuenta){
        boolean respuesta = false;
        for (Usuario usuario : clientes) {
            if (cliente == usuario.getIdentificacion()) {
                double saldoTotal = usuario.getCuentas().get(indiceCuenta-1).getSaldo() + deposito;
                usuario.getCuentas().get(indiceCuenta-1).setSaldo(saldoTotal);
                respuesta = true;
            }
        }
        return respuesta;
    }

    /**
     * retira el valor para la cuenta del cliente respectivo
     * @param cliente
     * @param retiro
     * @param indiceCuenta
     * @return respuesta booleana
     * @author David Huertas
     * @since 06/10/2022
     */
    public boolean retirar(Double retiro, int cliente, int indiceCuenta){
        boolean respuesta = false;
        for (Usuario usuario : clientes) {
            if (cliente == usuario.getIdentificacion()) {
                double saldoTotal = usuario.getCuentas().get(indiceCuenta-1).getSaldo() - retiro;
                usuario.getCuentas().get(indiceCuenta-1).setSaldo(saldoTotal);
                respuesta = true;
            }
        }
        return respuesta;
    }

    /**
     * retorna toda la informacion del banco
     * @return regresa todos los valores existentes en string
     * @author David Huertas
     * @since 06/10/2022
     */
    @Override
    public String toString() {
        return "banco{" + "clientes=" + clientes.toString() + "}";
    }
}