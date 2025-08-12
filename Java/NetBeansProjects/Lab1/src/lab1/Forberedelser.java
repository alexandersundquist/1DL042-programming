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
public class Forberedelser {
    
       public static void main(String[] args) 
    {
        // TODO code application logic here
        int[] values = {1,2,3,4,5,6,7,8,9,10};
        
        if (checkThree(values) == true)
        {
            System.out.println("There is a three in " + Arrays.toString(values));
        }
        else
        {
            System.out.println("There is no three in " + Arrays.toString(values));
        }
   
    }
    
    
    public static boolean checkThree(int[] values)
       {
            int searchedValue = 3;
            int pos = 0;
            boolean found = false;
            while (pos < values.length && !found)
            {
                if (values[pos] == searchedValue)
                {
                    found = true;
                }   
                else
                {
                    pos++;
                }
            }             
       return found;
       } 
}
