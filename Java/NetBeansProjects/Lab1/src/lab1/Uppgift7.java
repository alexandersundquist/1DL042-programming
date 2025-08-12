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
public class Uppgift7 {
    public static void main (String[] args)
    {
        int[] values = {1,2,3,7,3,9};
        System.out.println(Arrays.toString(changeThree(values)));
    }
    
    public static int[] changeThree(int[] array)
    {
        int searchedValue = 3;
        int newValue = 4;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == searchedValue)
            {
                array[i] = newValue;
            }
        }
        return array;
    }
}
