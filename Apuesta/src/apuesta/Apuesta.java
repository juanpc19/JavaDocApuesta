package apuesta;

/**
 * Esta clase nos permite hacer apuestas y cobrarlas
 * 
 * @author jperez
 * @version 1.0
 * 
 */
public class Apuesta {

	/**
	 * Dinero disponible para apostar
	 */
    private int dineroDisp;
    /**
     * Goles del equipo local
     */
    private int golesLocal;
    /**
     * Goles del equipo visitante
     */
    private int golesVisitante;
    /**
     * Cantidad apostada
     */
    private int apostado;

    /*Contructor por defecto*/
    
    /**
     * constructor por defecto que asigna a los atributos los valores por defecto
     */
    
    public Apuesta() {
        //constructor que asigna a los atributos los valores por defecto
    }
    

    
    /**
     * Este metodo es un constructor con parametros guarda informacion de la apuesta
     * 
     * @param dineroDisp guarda el valor dado al atributo dinero_disp
     * @param golesLocal guarda el valor dado al atributo goles_local
     * @param golesVisitante guarda el valor dado al atributo goles_visitante
     */

    /*Contructor con par�metros*/
    public Apuesta(int dineroDisp, int golesLocal, int golesVisitante) {
        this.dineroDisp = dineroDisp;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.apostado = 0;
    }
    
    /**
     * Metodo usado para obtener el valor del atributo dinero_disp
     * @return valor actual del atributo dinero_disp
     */
    
    /*M�todo para obtener el valor del atributo dinero_disp*/
    public int getDineroDisp() {
        return dineroDisp;
    }
    
    /**
     * Metodo usado para modificar el valor del atributo dinero_disp
     * @param dineroDisp variable usada para dar nuevo valor al atributo dinero_disp
     */
    
    /*M�todo para modificar el valor del atributo dinero_disp*/
    public void setDineroDisp(int dineroDisp) {
        this.dineroDisp = dineroDisp;
    }
    
    /**
     * Metodo para apostar una cantidad de dinero 
     * no pudiendo ser esta menor a 0 ni superior a dinero_disp
     * @param dinero guardara la cantidad de dinero apostada
     * @throws Exception mensaje de error mostrado al usuario si se cumple
	 * alguna condicion al introducir el valor de dinero
     */
    
    /* M�todo para apostar una cantidad de dinero
     * Permite elegir la cantidad a apostar, 
     * no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1�");
        }

        if (dinero > dineroDisp) {
            throw new Exception("No se puede apostar m�s de lo que tienes");
        }
        {
            dineroDisp = dinero - dineroDisp;
            apostado = dinero;
        }
    }
    
    /**
     * Metodo que comprueba el resultado del partido devolviendo true de acertarlo
     * @param local guardara los goles del equipo local
     * @param visitante guardara los goles del equipo visitante
     * @return devuelve el valor de variable acertado
     * @throws Exception mensaje de error mostrado por pantalla 
     * en caso de que el valor dado a local o visitante sea menor a 0
     */
    
    /* M�todo que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. 
     * Chequea que no se metan menos de 0 goles
     */
    public boolean comprobarResultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if (local < 0 || visitante < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (golesLocal == local && golesVisitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /**
     * Metodo usado para cobrar la apuesta, comprueba que se acerto el resultado y,
     *  en ese caso, añade el valor apostado multiplicado por 10 al saldo disponible
     * @param golesLocal guarda la cantidad de goles del equipo local
     * @param golesVisit guarda la cantidad de goles del equipo visitante
     * @throws Exception mensaje de error mostrado al usuario si no acierta la apuesta
     */
    
    /* M�todo para cobrar la apuesta.
     * Comprueba que se acert� el resultado y, en ese caso,
     * a�ade el valor apostado multiplicado por 10
     * al saldo disponible
     */
    void cobrarApuesta(int golesLocal, int golesVisit) throws Exception {

        if (!comprobarResultado(golesLocal, golesVisit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dineroDisp = dineroDisp * 10;

    }
}
