package mates;

import java.util.function.*;
import java.util.stream.*;


/**
 * Clase Matematicas, en la que encontramos los métodos que realizan los cálculos numéricos para obtener una aproximación a pi.
 */
public class Matematicas {

    /**
     * Método para generar puntos aleatorios.
     * <p>
     * En primer lugar, se definen las variables coordenadaX y coordenadaY,
     * que son las que tendrá cada punto generado y cuyos valores serán aleatorios;
     * para esto, empleamos el método random(), de la librería Math de Java.
     * <p>
     * Después, si el punto generado por dichas coordenadas cumple que está dentro o en el borde de un círculo de radio 1,
     * aumentaremos en 1 el contador de dardos, indicando que ahora hay un dardo más dentro;
     * si no se da el caso de que el punto está dentro o en el borde del círculo, no sucede nada.
     */
    public static int generarPuntoAleatorio(){
        double coordenadaX = Math.random();
        double coordenadaY = Math.random();

        if (coordenadaX*coordenadaX+coordenadaY*coordenadaY<=1){
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Método funcional para calcular el número pi a partir de los puntos generados.
     * <p>
     *
     * @param pasos Es el parámetro numérico que indica la cantidad de puntos totales con los que queremos trabajar.
     * @param funcion Es el parámetro de tipo DoubleUnaryOperator que indica la función con la que se van a realizar los cálculos.
     * @return Retornamos la aplicación de la función, que, según la que hayamos pasado como parámetros,
     * realizará el cálculo sustituyendo la variable que hayamos escrito por dardosDentro.
     */

    public static double generarNumeroPiExprLambda(long pasos, DoubleUnaryOperator funcion){

        int dardosDentro = IntStream.generate(()->generarPuntoAleatorio()).limit(pasos).reduce((num1, num2) -> num1 + num2).orElse(0);

        return funcion.applyAsDouble(dardosDentro);

    }
}

