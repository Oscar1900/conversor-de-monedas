// Utilidades.java
public class Utilidades {
    public static String obtenerCodigoMoneda(String entrada) {
        int inicio = entrada.indexOf('(');
        int fin = entrada.indexOf(')');
        if (inicio != -1 && fin != -1 && fin > inicio) {
            return entrada.substring(inicio + 1, fin);
        }
        return entrada;
    }
}
