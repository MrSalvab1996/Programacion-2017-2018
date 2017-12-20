//@author Salvador Bauza

//Importaremos todas las utilidades que vamos a utilizar.
package javaapplication6;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Examen_Parcial_Prog {
    
    //Crearemos el primer metodo el cual pide al usuario que introduzca su combinacion ganadora.
    private static int[] guarda_combinacio_usuari() {
    int[] combinacio_usuari = new int [8];
        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        Scanner sc3=new Scanner(System.in);
        
        //Primero pedimos los 6 numeros de la combinacion.
        System.out.println("Introdueix els nombres de la teva combinacio, un per un. (De l'1 al 49)");
        for (int contador = 0; contador<6;contador++) {
            int combinacio_usuario_matriu=sc.nextInt();
            combinacio_usuari[contador]=combinacio_usuario_matriu;
	}
        
        //Pedimos el numero complementario y lo guardamos junto a los demas.
        System.out.println("Introdueix el nombre complementari");
        combinacio_usuari[6] = sc2.nextInt();
        
        //Pedimos el reintegro y lo guardamos con la combinacion y el complementario.
        System.out.println("Introdueix el reintegrament (Del 0 al 9)");
        combinacio_usuari[7] = sc3.nextInt();
        System.out.println(" ");
        
        //Enseñamos al usuario los valores introducidos.
        System.out.println("La combinacio elegida es:");
        System.out.print(Arrays.toString(combinacio_usuari));
        System.out.println(" ");
        
        return combinacio_usuari;
    }
    
    //En este metodo se crea la combinacion ganadora, generada aleatoriamente.
    private static int[] sorteig_combinacio_guanyadora() {
    int[] combinacio_sorteig = new int [8];
    for (int x=0;x<7;x++) {
    combinacio_sorteig[x] = (int) (Math.random()*49)+1;
    }
    
    combinacio_sorteig[7] = (int) (Math.random()*9);
    
    System.out.print(Arrays.toString(combinacio_sorteig));
    
    
    return combinacio_sorteig;
    }
    
    //Este metodo permite recorrer ambos arrays y ver que numeros coinciden.
    //Y por lo tanto ver que numeros se han acertado.
    private static int comprova_numero_guanyador(int numero_u[], int numero_s[]) {
        
        int numeros_iguales = 0;
        for (int x=0;x<numero_u.length;x++) {
        for (int y=0;y<numero_s.length;y++) {
        if (numero_u[x]==numero_s[y]) {
            numeros_iguales++;
        }
  }
}
        //Enseñamos cuantos numeros se han acertado por pantalla.
        System.out.println(" ");
        System.out.println("Has encertat "+numeros_iguales+ " numeros!");
        return numeros_iguales;
    }
    
    //Este metodo permite, en funcion del numero de aciertos, determinar la categoria del premio.
    private static void determinar_premi (int numeros_correctes, int numero_u[], int numero_s[]){
    
        if (numeros_correctes <= 2 ) {
            System.out.println("Mala sort, no et correspon cap premi.");
        }
        if (numeros_correctes == 3) {System.out.println("Enhorabona, et correspon un premi de categoria 5!");}
        if (numeros_correctes == 4) {System.out.println("Enhorabona, et correspon un premi de categoria 4!");}
        if (numeros_correctes == 5) {System.out.println("Enhorabona, et correspon un premi de categoria 3!");}
        if (numeros_correctes == 5 && numero_u[6]==numero_s[6]) {System.out.println("Enhorabona, et correspon el premi de 2a categoria!");}
        if (numeros_correctes == 6) {System.out.println("Enhorabona, et correspon el premi de 1a categoria!");}
        if (numeros_correctes == 8) {System.out.println("Enhorabona, et correspon el premi especial!");}
        if (numero_u[7]==numero_s[7]) {System.out.println("Enhorabona, ha encertat el reintegrament");}

        
    }
    
    //Método Main donde se ejecuta todo el programa.
    public static void main(String[] args) {
        
        int[] numero1=guarda_combinacio_usuari();
        System.out.println(" ");
        System.out.println("El ticket premiat és el seguent:");
        int[] numero2=sorteig_combinacio_guanyadora();
        System.out.println(" ");
        int numeros_correctes = comprova_numero_guanyador(numero1,numero2);
        determinar_premi(numeros_correctes,numero1,numero2); 
    }
    
}