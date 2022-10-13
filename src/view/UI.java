package view;
import controlador.Banco;
import java.io.IOException;

/**
 * Interfaz grafica
 * @author David Huertas
 * @since 06/10/2022
 */
public class UI {
    private static final Banco banco1 =new Banco();
    /**
     * Funcion para iniciar el menu
     * @author David Huertas
     * @since 06/10/2022
     */
    public static void main(String[]args)throws IOException {
        Menu.dirigirOpciones(banco1);
    }
}
