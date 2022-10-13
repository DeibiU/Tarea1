package view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import controlador.Banco;
import modelo.Usuario;

/**
 * Clase con todos los valores de la UI.
 * @author David Huertas
 * @since 06/10/2022
 */
public class Menu {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//leer datos

    /**
     * Brinda lastodas opciones
     * @return int
     * @author David Huertas
     * @since 06/10/2022
     */
    public static int menu () throws IOException {
        int opcion;

        System.out.println("Bienvenido al banco leron, por favor seeccione una opcion");
        System.out.println("1. listar clientes");
        System.out.println("2. registrar cliente");
        System.out.println("3. registrar cuenta");
        System.out.println("4. depositos");
        System.out.println("5. retiros");
        System.out.println("6. mostrar saldo");
        opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    /**
     * directorio segun la escogencia de menu()
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void dirigirOpciones( Banco banco1) throws IOException {
        int opcion;
        loadData(banco1);
        do{
            opcion = menu();
            switch (opcion) {
                case 1 -> listarClientes(banco1);
                case 2 -> registrarClientes(banco1);
                case 3 -> registrarCuentaCliente(banco1);
                case 4 -> deposito(banco1);
                case 5 -> retiro(banco1);
                case 6 -> mostrarCuentasySaldo(banco1);
                default -> {}
            }
        }while (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5 || opcion == 6);
    }

    /**
     * lista de todos los clientes registrados
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */

    public static void listarClientes( Banco banco1){
        System.out.println("Lista De Clientes");
        System.out.println(banco1.listarClientes());
    }

    /**
     * registro de un cliente nuevo
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void registrarClientes( Banco banco1) throws IOException {
        String nombre, direccion, nacimiento;
        int identificacion;
        boolean e;
        System.out.println("Por favor, digite el nombre completo del cliente a agregar");
        nombre = in.readLine();
        System.out.println("Por favor, digite la cédula de la persona (sin espacios)");
        identificacion = Integer.parseInt(in.readLine());
        System.out.println("Por favor, digite la fecha de nacimiento de la persona(dd/mm/yyyy)");
        nacimiento = in.readLine();
        System.out.println("Por favor, digite la direccion");
        direccion = in.readLine();
        e= banco1.crearCliente(nombre,identificacion,nacimiento,direccion);
        if (!e){
            System.out.println("Error al registrar. Por favor, vuelva a intentarlo.");
        }else{
            System.out.println("Cliente registrado con exito");
        }
    }

    /**
     * registro de un cuenta nueva
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void registrarCuentaCliente( Banco banco1) throws IOException {
        double monto;
        int idCliente;
        System.out.println("Por favor, ingrese la id del cliente a agregar");
        idCliente = Integer.parseInt(in.readLine());
        System.out.println("Por favor, digite el monto a ingresar (debe ser mayor a 50.000, y dividido por puntos)");
        monto = Double.parseDouble(in.readLine());
        banco1.crearCuentaCliente(idCliente,monto);
        if(banco1.crearCuentaCliente(idCliente,monto)){
            System.out.println("Cuenta realizada con exito");
            System.out.println("datos: " +banco1.mostrarUsuario(idCliente));
        }else {
            System.out.println("Error al crear la cuenta. Por favor, vuelva a intentarlo.");
        }
    }

    /**
     * funcion de deposito
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void deposito(Banco banco1) throws IOException {
        double deposito;
        int idCliente, indiceCuenta;
        System.out.println("Por favor, digite la cedula de la persona a depositar");
        idCliente = Integer.parseInt(in.readLine());
        System.out.println("Por favor, ingrese el indice de cuenta");
        indiceCuenta = Integer.parseInt(in.readLine());
        System.out.println("Por favor, digite el monto a depositar");
        deposito = Double.parseDouble(in.readLine());
        boolean e = banco1.depositar(deposito,idCliente,indiceCuenta);
        if (e){
            System.out.println("Deposito realizado con exito");
            System.out.println("datos: " +banco1.mostrarUsuario(idCliente));
        }else{
            System.out.println("Error al depositar. Por favor, vuelva a intentarlo.");
        }
    }
    /**
     * funcion de retiro
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void retiro(Banco banco1) throws IOException {
        double deposito;
        int idCliente, indiceCuenta;
        System.out.println("Por favor, digite la cedula de la persona a retirar");
        idCliente = Integer.parseInt(in.readLine());
        System.out.println("Por favor, ingrese el indice de la cuenta");
        indiceCuenta = Integer.parseInt(in.readLine());
        System.out.println("Por favor, digite el monto a retirar");
        deposito = Double.parseDouble(in.readLine());
        boolean e = banco1.retirar(deposito,idCliente,indiceCuenta);
        if (e){
            System.out.println("Retiro realizado con exito");
            System.out.println("datos: " +banco1.mostrarUsuario(idCliente));
        }else{
            System.out.println("Error al retirar. Por favor, vuelva a intentarlo.");
        }
    }

    /**
     * exhibe usuario y todos sus fondos
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void mostrarCuentasySaldo(Banco banco1) throws IOException{
        int idCliente;
        Usuario temp;
        System.out.println("Por favor, digite la cedula del cliente");
        idCliente = Integer.parseInt(in.readLine());
        temp = banco1.mostrarUsuario(idCliente);
        System.out.println(temp.toString());
    }
    /**
     * ingresa valores como ejemplo
     * @param banco1
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void loadData(Banco banco1){
        banco1.crearCliente("Clark",1111555511,"12/31/2012"," San Jose, Centro");
        banco1.crearCliente("Bruce",2222222,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Diana",3333333,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Barry",44444344,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Hal",111111111,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Tim",666234234,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Luffy",445645646,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Zoro",32342344,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Nami",4234234,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Usopp",8676784,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Sanji",67867864,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Chopper",46678657,"12/31/2012","San Jose, Centro");
        banco1.crearCliente("Robin",56755454,"12/31/2012","San Jose, Centro");
        banco1.crearCuentaCliente(1111555511,70.000);
        banco1.crearCuentaCliente(56755454,70.000);
        banco1.crearCuentaCliente(8676784,70.000);
        banco1.crearCuentaCliente(46678657,70.000);
        banco1.crearCuentaCliente(111111111,70.000);
        banco1.crearCuentaCliente(445645646,70.000);
        banco1.crearCuentaCliente(67867864,70.000);
        banco1.crearCuentaCliente(8676784,70.000);
        banco1.crearCuentaCliente(46678657,70.000);
        banco1.crearCuentaCliente(32342344,70.000);
    }
}