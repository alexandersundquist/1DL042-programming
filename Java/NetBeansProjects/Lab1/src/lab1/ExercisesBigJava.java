/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//P4.13
package lab1;
/**
 *
 * @author alexs
 */
public class ExercisesBigJava {
    public static void main (String[] args)
    {
        exponentAv2();
    }
    public static void exponentAv2 ()
    {
       for (int i=0; i<=20; i++)
       {
           System.out.println(Math.pow(2,i));
       }
    }
    
}

/*Suppose x and y are variables of type double. 
Write a code fragment that sets y to x if x is positive and to 0 otherwise.*/

/* double x;
double y;
if (x < 0) 
{
    y = 0;
}
else 
{
    y = x;
}
*/

/*Suppose x and y are variables of type double. Write a code fragment that sets y 
to the absolute value of x without calling the Math.abs function. Use an if statement.*/

/*
double x;
double y;
if (x < 0) 
{
    y = -x;
}            
else 
{
    y = x;
}
*/

/*Write a while loop that prints
 a. All squares less than n. For example, if n is 100, print 0 1 4 9 16 25 36 49 64 81.

/*
int number;
int startnumber = 0;
while (Math.pow(startnumber, 2) < Math.pow(number,2)) 
{
    System.out.println(Math.pow(startnumber, 2));
    startnumber++;
}
*/


