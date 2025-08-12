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
public class Uppgift5 {
    public static void main (String[] args)
    {
        int[] values = {1,2,3,7,8,9,10};
        System.out.println(followingThrees(values));
    }
    
    public static boolean followingThrees (int[] values)
    {
        int searchedValue = 3;
        for (int i=0; i < values.length; i++)
        {
            if (values[i]==3 && values[i+1]==3)
            {
                return true;
            }
        }
        return false;
    }
}
