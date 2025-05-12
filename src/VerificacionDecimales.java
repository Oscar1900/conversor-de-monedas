import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VerificacionDecimales { //Se declara una clase pública llamada VerificacionDecimales.
    // Esta clase contendrá lógica relacionada con mostrar resultados de conversiones de monedas.

    public static void mostrarResultado(String codigoOrigen, String simboloOrigen, String simboloDestino,
                                        String monedaOrigen, String monedaDestino, double monto, double convertido,
                                        double tipoCambio, LocalDateTime fechaHora, DateTimeFormatter formato,
                                        List<String> historial) {

        //Se define un método público y estático llamado mostrarResultado.
        //
        //Este método recibe muchos parámetros: códigos y nombres de las monedas, los montos, el tipo de cambio, la fecha y el historial.
        //
        //static permite llamar al método sin crear una instancia de la clase.

        boolean usaFormatoLargo = codigoOrigen.equals("JPY") || codigoOrigen.equals("ARS") ||
                codigoOrigen.equals("CLP") || codigoOrigen.equals("RUB") ||
                codigoOrigen.equals("COP");

        //Se define una variable booleana que será true si el código de origen corresponde a una moneda que requiere más
        // decimales (por ser monedas con valores pequeños como el peso chileno o el yen japonés).
        //
        //equals() compara cadenas en Java.

        String registro = String.format("[%s] De %s %.2f a %s %.2f (Tipo: %." + (usaFormatoLargo ? "10" : "3") + "f)",
                fechaHora.format(formato), simboloOrigen, monto, simboloDestino, convertido, tipoCambio);
        //Se crea un texto con el formato: [fecha] De $ 100.00 a € 90.00 (Tipo: 0.900).
        //
        //Si la moneda está en el grupo especial, muestra 10 decimales (%.10f), si no, solo 3 (%.3f).
        //
        //String.format() se usa para crear textos con formato numérico.
        //
        //fechaHora.format(formato) convierte la fecha y hora a un texto legible.

        historial.add(registro);//Se añade el registro creado a la lista historial.



        DecimalFormat df = new DecimalFormat(usaFormatoLargo ? "#,###.0000000000" : "#,###.000");
        //Se define cómo se mostrará el número al usuario:
        //
        //Si es usaFormatoLargo, se muestran 10 decimales.
        //
        //Si no, se muestran solo 3 decimales.
        //
        //DecimalFormat es útil para dar formato numérico legible.
        String mensaje = String.format("<html>%s %s equivalen a %s %s<br>"
                        + "<div style='text-align:center;'>Tipo de Cambio:</font></b> %s</div>"
                        + "</html>",
                monedaOrigen, df.format(monto), monedaDestino, df.format(convertido), df.format(tipoCambio));
        //Se arma un mensaje en formato HTML (porque JOptionPane lo soporta).
        //
        //El HTML permite saltos de línea (<br>) y centrado del texto (<div style='text-align:center;'>).
        //
        //df.format(...) aplica el formato decimal a los valores.

        JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        //Muestra una ventana emergente con el mensaje formateado.
        //
        //"Resultado" es el título de la ventana.
        //
        //JOptionPane.INFORMATION_MESSAGE indica el tipo de ícono que se mostrará (una “i” de información).
    }
}

