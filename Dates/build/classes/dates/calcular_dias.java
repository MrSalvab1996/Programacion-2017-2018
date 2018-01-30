/*
 *@author Salvador Bauza
 *1ºDAM
 */
package dates;
import java.util.Scanner;
import java.util.GregorianCalendar;
public class calcular_dias {
    
    //Este metodo devuelve, mediante la introduccion de un integrer que corresponde
    //a un año en concreto, si ese año es bisiesto o no.
    private static boolean Bisiesto(int any) {
        boolean bisiesto = false;
        if ((any % 4 == 0) && (any% 100 != 0) || (any % 400 == 0)) {
            bisiesto = true;
        } else {
            bisiesto = false;
        }
        return bisiesto;
    }
    
    //Este metodo és el que se encarga de sumar los dias entre las dos fechas
    //precisa de 3 numeros para funcionar que corresponden a año, mes y dia.
    private static int Suma (int any, int mes, int dia ){
       int resul = 0;
       int bisiesto = 0;
       int dias_mes = 0;
       int dias_any = 0;
       
       
       //Calculamos si el año introducido por el usuario es bisiesto o no.
       for (int contador = 1; contador>any;contador++){
       if ((any % 4 == 0) && (any % 100 != 0) || (any % 400 == 0)) {
       bisiesto += 1;
       } else {bisiesto += 0;}
       }
       
       //Calculamos los dias por año.
       dias_any = any*365;
       
       //En funcion del mes introducido se suman los dias correspondintes al 
       //computo total.
        switch (mes){
           case 1: dias_mes = 0; //Enero
           break;
           case 2: dias_mes = 31; //Febrero
           break;
           case 3: dias_mes = 59; //Marzo
           break;
           case 4: dias_mes = 90; //Abril
           break;
           case 5: dias_mes = 120; //Mayo
           break;
           case 6: dias_mes = 151; //Junio
           break;
           case 7: dias_mes = 181; //Julio
           break;  
           case 8: dias_mes = 212; //Agosto
           break;
           case 9: dias_mes = 243; //Septiembre
           break;
           case 10: dias_mes = 273; //Octubre
           break;
           case 11: dias_mes = 304; //Noviembre
           break;
           case 12: dias_mes = 334;//Diciembre
           break;
       }
        
       //Sumamos todos los datos anteriormente recopilados para caclular los
       //dias totales ente las dos fechas.
       resul = dias_any + dias_mes + dia + bisiesto;
       return resul;
   }

    public static void main(String[] args) {
        //Mediante este parrafo se consgiue la fecha actual del sistema y se
        //imprime por pantalla
        GregorianCalendar data = new GregorianCalendar();
        int dia = (data.get(GregorianCalendar.DATE));
        int mes = (data.get(GregorianCalendar.MONTH)+1);
        int año = (data.get(GregorianCalendar.YEAR));
        System.out.println("La fecha de hoy es:");
        System.out.println(dia+"/"+mes+"/"+año);
        System.out.println("");
        
        Scanner valor = new Scanner(System.in);
        
        //Pedimos al usuario la fecha que desee.
        System.out.println("Introduce un día:");
        int dia2 = valor.nextInt();
        
        System.out.println("Introduce el més:");
        int mes2 = valor.nextInt();
        
        System.out.println("Introduce el año:");
        int año2 = valor.nextInt();
        
        //Enseñamos, si el año es bisiesto o no, con el método Bisiesto.
        if (Bisiesto(año2)) {
                System.out.println("Este año es bisiesto.");}
        else {
                System.out.println("Este año no es bisiesto");
        }
        
        //Calculamos los dias entre las dos fechas con el metodo anterior Suma
        int dias_actual = Suma (año,mes,dia);
        int dias_usuario = Suma (año2,mes2,dia2);
        
        //Mostramos al usuario os dias que faltan o que han pasado enter las dos fechas o si estas coinciden.
        if (dias_actual == dias_usuario) {
            System.out.println("La fecha de hoy y la introducida es la misma.");
        } else if (dias_actual>dias_usuario) {
            int dias = (dias_actual) - dias_usuario;
            System.out.println("Han pasado " +dias+ " dias para llegar a la fecha actual.");
        } else {
            int dias = (dias_usuario) - dias_actual;
            System.out.println("Faltan " +dias+ " dias desde la fecha actual.");
        }
        
    }
}
