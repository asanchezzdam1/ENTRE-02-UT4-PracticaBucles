import java.util.Random;
/**
 *    
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private Random generador;
    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {
        //Creamo variables locales para calcular unas cosas
        int gehituZorizko= 0;
        int i = 0;
        int zorizko = generador.nextInt(6001) - 1000;
        int gehienBikoiti = Integer.MIN_VALUE;
        int bikoiti = 0;
        int gehituBakoiti = 0;
        //Se muestra un mensaje en la pantalla
        System.out.println("Numero maximo de aleatorios a generar " + n + "\n o hasta que salga 0 \n");
        // Entra si "n" es mayor que "y" y si aleatorio "zorizko" no es igual a 0
        while(i < n && zorizko != 0){
            //Si es par entra en la parte del if
            if(!esImpar(zorizko)){
                bikoiti++;
                if(zorizko > gehienBikoiti){
                    gehienBikoiti = zorizko;
                }
            }
            //Si es impar hace el else
            else{
                gehituBakoiti += zorizko;
            }
            //Se crea la variable sinCeros y se llama al metodo creado antes 
            int zerorikGabe = obtenerNumeroSinCeros(zorizko);
            //Se muestra el resultado sin ceros
            System.out.printf("%12d:%5d",zorizko, zerorikGabe);
            i++;
            //Almecena los numeros en 5 columnas
            if(i % 5 == 0){
                System.out.println();
            }
            gehituZorizko += zorizko;
            zorizko = generador.nextInt(6001) - 1000;
        }
        if(bikoiti == 0){
            gehienBikoiti = 0;
        }
        //Se hace la media del aleatorio y se divide entre todas la veces que se ha ejecutado el bucle
        double batazBestekoa = gehituZorizko / i;
        System.out.println();
        System.out.printf("\n%25s%10.2f","Media:", batazBestekoa);
        System.out.printf("\n%25s%10d","Suma impares:",gehituBakoiti);
        System.out.printf("\n%25s%10d","Máximo pares:", gehienBikoiti);
    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        while(numero % 2 == 0){
            return false;
        }
        return  true;
    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3
     *   
     *   
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int emaitza = 0;
        int i = numero;
        int berretzaile = 0;
        while(i != 0){
            int cifra = i % 10;
            if(cifra == 0){
                i = i / 10;
            }
            else{
                int berretura = (int)(Math.pow(10,berretzaile));
                emaitza = emaitza + cifra * berretura;
                i = i / 10;
                berretzaile++;
            }
        }
        return emaitza;
    }

    /**
     *  Borrar la pantalla
     *
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  
     *  Hay que usar el método escribirCaracter()
     *  
     *  
     *   
     */
    public void escribirLetraN(int altura)    {
        System.out.println("La letra N va ha ser: " + altura + " Caracteres");
        escribirCaracter(CARACTER, altura);
    }

    /**
     *  escribe n veces el caracter  indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {
        String aux = "";
        for (int a = 0; a < n; a++){
            aux += caracter;
            for (int b = 0; b < a; b++){
                aux += ESPACIO;
            }
            aux += caracter;
            for (int c = n - a; c > 1; c--){
                aux += ESPACIO;
            }
            aux += caracter + "\n";
        }
        System.out.println(aux);
    }
}
