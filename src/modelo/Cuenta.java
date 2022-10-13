package modelo;
/**
 * esta clase contiene un id y un saldo
 * @author David Huertas
 * @since 06/10/2022
 */
public class Cuenta {
    private int id;
    private double saldo;

    /**
     * contructor para cuenta
     *
     * @param id
     * @param saldo
     * @author David Huertas
     * @since 06/10/2022
     */
    public Cuenta(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    /**
     * setter para id
     *
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter para id
     *
     * @return id
     * @author David Huertas
     * @since 06/10/2022
     */
    public int getId() {
        return id;
    }

    /**
     * setter para saldo
     *
     * @param saldo
     * @author David Huertas
     * @since 06/10/2022
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * getter para saldo
     *
     * @return id
     * @author David Huertas
     * @since 06/10/2022
     */
    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", saldo=" + saldo + "}";
    }
}