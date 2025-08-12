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
public class Uppgift8 {
    public static void main (String[] args)
    {
        int[] values = {1,2,3,7,4,9};
        System.out.println(Arrays.toString(switchThirdAndFourth(values)));
    }
    
    public static int[] switchThirdAndFourth(int[] array)
    {
        int storeValue = array[3];
        array[3]=array[2];
        array[2]=storeValue;
        return array;
    }
}
