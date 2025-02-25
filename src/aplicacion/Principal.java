package aplicacion;
import mates.*;

/**
 * Clase para la ejecución del programa. Al ejecutar por terminal, debemos escribir, a continuación de la ejecución y antes de pulsar "enter", el número de puntos con los que queramos trabajar.
 */
public class Principal {

    /**
     * Método para la ejecución del programa.
     * @param args Es el parámetro numérico que pasamos por terminal al ejecutar el programa.
     */
    public static void main(String[] args){
        System.out.println("El numero PI es " +
                Matematicas.generarNumeroPiExprLambda(Double.parseDouble(args[0]), x -> 4.0*x/Double.parseDouble(args[0])));
    }
}

