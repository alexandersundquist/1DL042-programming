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
public class RedoUppgift2 {
    public static void main (String[] args)
    {
        testSiffersumma();
    }
    
    public static int siffersumma(int tal)
    {
        int ackSumma = 0;
    while (tal >0) 
        {   
        ackSumma += tal%10;
        tal/=10;
        }
    return ackSumma;
    }
    
    static void testSiffersumma() 
    {
        int test1 = 2;
        int test2 = 2051125521;
        int test3 = 000;
        int test4 = -38;
        int[] tests = {test1, test2, test3, test4};
        for (int test : tests) 
        {
            System.out.println(siffersumma(test));
        }
    }

}

