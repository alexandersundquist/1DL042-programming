/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Arrays;
/**
 *
 * @author alexs
 */
public class Uppgift6 {
    public static void main (String[] args)
    {
        int[] values = {1,2,3,7,8,9};
        System.out.println(Arrays.toString(addThree(values)));
    }
    
    public static int[] addThree(int[] lista)
    {
        lista = Arrays.copyOf(lista, lista.length+1);
        lista[lista.length-1]=3;
        return lista;
    }
}
