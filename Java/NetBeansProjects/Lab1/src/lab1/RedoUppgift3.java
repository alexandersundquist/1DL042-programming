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
public class RedoUppgift3 {
     public static void main (String[] args)
    {
        testBubblesort();
    }
     
     public static boolean bytintill(int[]array)
     {
         boolean changeMade = false;
        for (int pos = 0; pos < array.length ; pos++) 
        {
            if (pos + 1 < array.length && array[pos + 1]< array[pos]) 
                {
                int storenumber = array[pos];
                array[pos] = array[pos + 1];
                array[pos + 1] = storenumber;
                changeMade = true;
                }
        }
        //System.out.println(Arrays.toString(array));
        return changeMade;
     }
     
     public static int[] bubblesort(int[] array)
     {
         while(bytintill(array)== true)
            bytintill(array);
        return array;
     }static void testBubblesort() 
     {
        int[] test1 = {};
        int[] test2 = {0,0,0};
        int[] test3 = {-5,23,5,-12};
        int[] test4 = {1,2,3,4,5,6,7,8};
        int[] test5 = {8};
        int[] test6 = {235902,532598,32,-2,9845,924,43,4532,9,3,50,35,0};
        int[][] tests = {test1, test2, test3, test4, test5, test6};
        for (int[] test : tests) {
            System.out.println(Arrays.toString(bubblesort(test)));
        }
     }
}
