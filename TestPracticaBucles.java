import java.util.Scanner;

/**
 * Incluye todo el código dentro del main()
 * No declares ningún nuevo método en esta clase ni atributos
 *  
 */
public class TestPracticaBucles
{

    /**
     *  Punto de entrada a la aplicación
     *  - define y crea el teclado  
     *  - define e instancia un objeto PracticaBucles
     *  - pide al usuario la cantidad máxima de aleatorios a generar
     *    (valida que sea  un nº positivo)
     *  - muestra las estadísticas de números aleatorios
     *  - haz una pausa y borra la pantalla    
     *  
     *  - pide al usuario un valor para la altura de la letra N -
     *          Valida que este valor es correcto, es decir,
     *          está en el intervalo 3 <= altura <= 10
     *  - muestra la letra N
     *  
     */
    public static void main(String[] args)    {
        //Creado el teclado
        Scanner teclado = new Scanner(System.in);
        //Creado un objeto PracticaBucles
        PracticaBucles bucle = new PracticaBucles();
        //pide al usuario la cantidad máxima de aleatorios a generar
        System.out.println("Cantidad maxima de numeros que se van a generar");
        int aux = teclado.nextInt();
        //valida que sea un nº positivo
        while (aux < 0){
            System.out.println("Por favor introduzca un numero mayor que 0");
            aux = teclado.nextInt();
        }
        //muestra las estadísticas de números aleatorios
        bucle.generarNumeros(aux);
        //haz una pausa y borra la pantalla 
        Utilidades.hacerPausa();
        Utilidades.borrarPantalla();
        //Pedir al usuario el valor de la letra "N" y gurdado en el teclado
        System.out.println("Por favor introduzca un numero de altura para la letra N que vamos ha crear:");
        int alt = teclado.nextInt();
        //Validacion de la altura
        while (3 > alt || 10 < alt){
            System.out.println("Por favor escriba un caracter entre el 3 y el 10: ");
            alt = teclado.nextInt();
        }
        // escribir la letra
        bucle.escribirLetraN(alt);
        
    }
}

