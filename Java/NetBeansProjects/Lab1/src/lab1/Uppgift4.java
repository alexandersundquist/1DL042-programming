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
public class Uppgift4 {
    public static void main (String[] args)
    {
        int[] values = {1,2,3,3,3,3,7,8,9,10};
        System.out.println("There are " + countThrees(values) + " threes");
    }
    
    public static int countThrees (int[] values)
    {
        int searchedValue = 3;
        int pos = 0;
        int counterOfThrees = 0;
        while (pos < values.length)
        {
            if (values[pos] == searchedValue)
            {
                counterOfThrees++;
                pos++;
            }
            else
                pos++;
        }
        return counterOfThrees;
    }
}
