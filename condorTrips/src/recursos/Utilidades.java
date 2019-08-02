package recursos;


import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.PaqueteComponent;

/**
 *
 * @author libardo
 */
public class Utilidades {


    public static Date stringToDate(String strFecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {

            ex.printStackTrace();
            return null;
        }
        return fecha;
    }


    /**
     * Determinar si fecha1 es posterior o igual a fecha 2
     *
     * @param fecha1 fecha 1
     * @param fecha2 fecha 2
     * @return true si fecha1 es posterior o igual a fecha2, false en caso contrario
     */
    public static boolean fechaEsPosterior(Date fecha1, Date fecha2) {
        Calendar calFecha1 = dateToCalendar(fecha1);
        Calendar calFecha2 = dateToCalendar(fecha2);
        
        if (calFecha1.getTimeInMillis() >= calFecha2.getTimeInMillis()){
            return true;
        }else{
            return false;
        }


    }

    /**
     * Evalua si fecha está dentro de fecha1 y fecha2
     *
     * @param fecha fecha a examinar
     * @param fecha1 rango 1
     * @param fecha2 rango 2
     * @return true si está en ese rango, false si no
     */
    public static boolean fechaEstaDentroDe(Date fecha, Date fecha1, Date fecha2) {

        Calendar calFecha = dateToCalendar(fecha);
        Calendar calFecha1 = dateToCalendar(fecha1);
        Calendar calFecha2 = dateToCalendar(fecha2);

        if (calFecha.getTimeInMillis() >= calFecha1.getTimeInMillis() && calFecha.getTimeInMillis() < calFecha2.getTimeInMillis()) {
            return true;
        } else {
            return false;
        }


    }

    public static Calendar dateToCalendar(Date fecha) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        return cal;
    }


    public static Date sumarMesAFecha(Date fecha) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        //Le suma un mes
        cal.add(Calendar.MONTH, 1);
        //SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM dd yyyy");
        //return sdf.format(cal.getTime());
        return cal.getTime();
    }

    public static Date sumarHorasAFecha(Date fecha, int horas) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        //Le suma un mes
        cal.add(Calendar.HOUR_OF_DAY, horas);
        //SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM dd yyyy");
        //return sdf.format(cal.getTime());
        return cal.getTime();
    }


    public static Date quitarHoraAFecha(Date fecha) throws ParseException {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        String fechaStr = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
        return sdf.parse(fechaStr);
    }


    public static long calcularDiferenciaEnMinutos(Date fechaInicial, Date fechaFinal) {
        Calendar calFechaInicial = dateToCalendar(fechaInicial);
        Calendar calFechaFinal = dateToCalendar(fechaFinal);
        long totalMinutos = ((calFechaFinal.getTimeInMillis() - calFechaInicial.getTimeInMillis()) / 1000 / 60);
        return totalMinutos;
    }


    public static void mensajeAdvertencia(String mns, String titulo) {
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, new ImageIcon("./src/Recursos/warning.png"));
    }

    public static void mensajeError(String mns, String titulo) {
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, new ImageIcon("./src/Recursos/error.png"));
    }

    public static void mensajeExito( String mns, String titulo) {
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, new ImageIcon("./src/Recursos/success.png"));
    }


    public static void mensajeInformacion(String mns, String titulo) {
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, new ImageIcon("./src/Recursos/customer-service-1.png"));
    }

    public static String formatoMoneda(long valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return nf.format(valor);
    }

    /**
     * Da formato "dd-MM-yyyy hh:mm a" a una fechaHora
     *
     * @param fecha fechaHora ser formateada
     * @return fechaHora formateada
     */
    public static String formatoFecha(Date fecha) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        return formatDate.format(fecha);
    }

    /**
     * Examina si una cadena es numérico
     *
     * @param cadena cadena a ser evaluada
     * @return true si es numérico, false en caso contrario
     */
    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }



    public static int redondearCentenaProxima(int valor) {
        return (int) (Math.ceil(valor / 100.0)) * 100;
    }
    /*
    public  PaqueteComponent devolverContinente(RegionComponent paquete,String nombreContinente) throws Exception{
       if (paquete==null){ return null;}
       
        for (int i = 0; i < paquete.devolverVecRegiones().size(); i++) {
            if(nombreContinente.equals(paquete.getComponent(i).getNombre())){
                try {
                    return paquete.getComponent(i);
                } catch (Exception ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return null;
    
    }

    public  PaqueteComponent devolverPaisEnPaquete(RegionComponent paquete,String nombreContinente,String nombrePais) throws Exception{

        RegionComponent continente =(RegionComponent) devolverContinente(paquete,nombreContinente);
        if(continente ==null) return null;
        for (int i = 0; i < continente.devolverVecRegiones().size(); i++) {
            if(nombrePais.equals(continente.getComponent(i).getNombre())){
                try {
                    return continente.getComponent(i);
                } catch (Exception ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return null;
        
    }
    public  PaqueteComponent devolverCiudadEnPaquete(RegionComponent paquete,String nombreContinente,String nombrePais,String nombreCiudad) throws Exception{

        RegionComponent continente =(RegionComponent) devolverContinente(paquete,nombreContinente);
        if(continente ==null) return null;
        RegionComponent pais =(RegionComponent) devolverPaisEnPaquete(paquete,nombreContinente,nombrePais);
        if(pais ==null) return null;
        for (int i = 0; i < pais.devolverVecRegiones().size(); i++) {
            if(nombreCiudad.equals(pais.getComponent(i).getNombre())){
                return pais.getComponent(i);
            }
            
        }
        return null;
        
    }
*/
}
