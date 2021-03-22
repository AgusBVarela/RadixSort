package RadixSort;

import java.lang.reflect.Array;

public class StringUtil
{
    int v;

    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        String result = "";
        for(int i=0 ; i<n ; i++){
            result += c;
        }
        return result;

    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005" lpad("50",3,'0' -> 050
    public static String lpad(String s, int n, char c)
    {
        int cantInicio = n-s.length();
        String inicio = replicate(c, cantInicio);
        return inicio+s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++){
            result[i] = String.valueOf(arr[i]);
        }
        return result;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            result[i] = Integer.valueOf(arr[i]);
        }
        return result;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int result = 0;
        for(String a: arr){
            if(a.length() > result) result = a.length();
        }
        return result;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c) {
        int largo = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], largo, c);
        }
    }

    public static void toOtherIntArray(int[] toArray, int[] fromArray){
        for(int i = 0; i < fromArray.length; i++){
            toArray[i] = fromArray[i];
        }
    }
}
