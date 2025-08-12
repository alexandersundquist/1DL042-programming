/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author alexs
 */
public class Uppgift2 {
    
    public static void main(String[] args)
    {
        int[] values = {5,1,6,4,5,9,3,8,9,7};
        System.out.println("Talet tre finns på index " + findIndex(values));
    }
    
    public static int findIndex(int[] values)
    {
        int searchedValue = 3;
        int pos = 0;
        int posSearchedValue = 0;
        boolean found = false;
        while (pos < values.length && !found)
        {
            if (values[pos] == searchedValue)
            {
                posSearchedValue = pos;
                found = true;
            }
            else
            {
                pos++;
            }
        }
        return posSearchedValue;
    }
}
