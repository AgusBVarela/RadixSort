package RadixSort;

import java.util.ArrayList;
import java.util.HashMap;

import static RadixSort.StringUtil.*;

public class RadixSortEjerc {

    public static void radixSort(int[] arr) {
        String[] sArray = toStringArray(arr);
        lNormalize(sArray, '0');
        sArray = recorrerElementos(sArray);
        int[] finalArray = toIntArray(sArray);

        toOtherIntArray(arr, finalArray);
    }

    public static  String[] recorrerElementos(String[] arr){
        /*Recorre las el arreglo tantas veces como caracteres del string del arreglo.
          Recorriendo del ultimo caracter al primero. */

        int maxLenght = maxLength(arr);
        for (int i = maxLenght-1; i >= 0 ; i--){
            HashMap listas = getListas(10);
            for(String arrayElement: arr){
                String key = "L" + arrayElement.charAt(i);

                ArrayList<String> itemsList = (ArrayList<String>) listas.get(key);
                itemsList.add(arrayElement);
            }
            arr = getNewArray(listas);
        }
        return arr;
    }

    private static String[] getNewArray(HashMap listas){
        /*Genera un arreglo de strings de recorrer las listas en orden*/
        ArrayList<String> result =  new ArrayList<String>();
        for (int i = 0; i< listas.size(); i++ ){
            String key = "L" + i;
            ArrayList<String> itemsList = (ArrayList<String>) listas.get(key);
            result.addAll(itemsList);
        }
        return result.toArray(new String[0]);
    }

    public static HashMap getListas(int cantidad){
        /*Crea en un hasMap tantas listas como reciba por parametro*/
        HashMap map = new HashMap();
        for (int i = 0; i < cantidad; i++){
            String name = "L" + String.valueOf(i);
            map.put(name, new ArrayList<String>());
        }
        return map;
    }

    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}
