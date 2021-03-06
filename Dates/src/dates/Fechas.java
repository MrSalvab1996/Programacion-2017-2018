/*
 *@author Salvador Bauza
 *1ºDAM
 */
package dates;
import java.util.Scanner;
import java.util.GregorianCalendar;
public class Fechas {
    
    //Creamos el metodo para saber si la fecha introducida por el usuario es Bisiesta o no.
    private static int Bisiesto(int x) {
        int c = 0;
        if ((x % 4 == 0) && (x % 100 != 0) || (x % 400 == 0)) {
            c += 1;
        } else {
            c += 0;
        }
        return c;
    }
    
    //Creamos el motodo para realizar la converin de las fechas a dias.
    private static int Suma (int x1, int x2, int x3 ){
       int resul = 0;
       int c = 0;
       int dias_mes = 0;
       int dias_any = 0;
       
       for (int contador = 1; contador>x1;contador++){
       if ((x1 % 4 == 0) && (x1 % 100 != 0) || (x1 % 400 == 0)) {
       c += 1;
       } else {c += 0;}
       }
       
       //Calculamos los dias por año.
       dias_any = x1*365;
       
        switch (x2){
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
       resul = dias_any + dias_mes + x3 + c;
       return resul;
   }
    //Mostramos la fecha actual del sistema
    public static void main(String[] args) {
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
        
        //Enseñamos, mediante el metodo anterior si el año es bisiesto o no, con el método Bisiesto.
        switch (Bisiesto(año2)) {
            
            case 1:
                System.out.println("Este año es bisiesto.");
                break;
            case 0:
                System.out.println("Este año no es bisiesto");
                break;
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
