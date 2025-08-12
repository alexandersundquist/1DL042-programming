/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prelab1;

import java.util.Arrays;

/**
 *
 * @author veragrunewald
 */
public class lab1 {
    
        public static void main(String[] args) {
        int[] values = {1,2,3,8,5,6,9,3,9,10};
        //System.out.println(Arrays.toString(values));
        //System.out.println(bytintill(values));
        //testSiffersumma();
        testBubblesort();
        //System.out.println(bubblesort());
    }

/*Skriv ett program som har ett positivt tal som parameter och skriver ut dess siffersumma.
Tex, om talet är 1338 blir siffersumman 15. Testa genom att skriva en testmetod som anropar
din kod med utvalda testfall. Undvik att använda javas input från tangentbordet,
det är lite krångligt och tar längre tid om du ska testa upprepade gånger.*/

/*def siffersumma(tal):
    if type(tal) != int:
        print("Endast positiva tal tack!")
        return
    ack_summa = 0
    while tal>0:
        ack_summa += tal%10
        tal//=10
    return ack_summa*/

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
    
    static void testSiffersumma() {
        int test1 = 2;
        int test2 = 2051125521;
        int test3 = 000;
        int test4 = -38;
        int[] tests = {test1, test2, test3, test4};
        for (int test : tests) {
            System.out.println(siffersumma(test));
        }
    }

/*3. Skriv en metod bytintill() som går igenom en array. 
Om två intilliggande tal ligger i minskande ordning ska dessa två tal byta plats.
Skriv sedan en metod bubblesort() som kör bytintill() upprepade gånger tills 
inga mer byten sker. Testa metoden ordentligt med en testmetod*/

/* def bytintill(li):
    change_made = False
    for k in range(len(li)):
        if k + 1 < len(li) and li[k] > li[k+1]:
                li[k], li[k+1] = li[k+1], li[k]
                change_made = True
    return change_made */
    
    public static boolean bytintill(int[] array) {
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
        
/*def bubblesort(li):
    while bytintill(li) == True:
            bytintill(li)
    return li*/

    public static int[] bubblesort(int[] array) {
        while (bytintill(array)== true)
            bytintill(array);
        return array;
    }
    
        static void testBubblesort() {
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
