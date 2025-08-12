/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexs
 */
import java.util.Arrays;

public class lab2
{
    public static void main(String[] args) 
    {
        System.out.println("The average amount dead in vaccinated village: " + averageAmountDead(true));
        System.out.println("The average amount dead in non-vaccinated village: " + averageAmountDead(false));
    }
    
    static int averageAmountDead (boolean isVaccinated)
    {
        final int SIMULATION_RUNS = 10;
        int totalDeadAllRuns = 0;
        for (int i=0; i<SIMULATION_RUNS; i++)
        {
            Village uppsala = new Village(isVaccinated);
            while (uppsala.countSick()>0)
            {
                uppsala.dayPassesAll();
            }
            totalDeadAllRuns = totalDeadAllRuns + uppsala.countDead();
        }
        return totalDeadAllRuns/SIMULATION_RUNS;
    }
}

class Village 
{
    private final int SIZE = 1000;
    Person[] population = new Person[SIZE];    //Ska det här skrivas i konstruktorn?
    
    public Village(boolean isVaccinated)
    {
       for (int i = 0 ; i < SIZE ; i++) 
       {
           Person individual = new Person(isVaccinated);
           population[i]=individual;
       }    
    }
    int countSick() 
    {    
        int count = 0;
        for (Person individual : population) {
            if (individual.isSick != false)
            {
                count ++;
            }
        }
        return count;
    }
    
    void dayPassesAll()
    {
        for (Person individual : population) 
        {
            individual.dayPasses(population);
            if (individual.daysLeftImmune != 0);
            {
                individual.daysLeftImmune --;
            }
        }
    }    
    
    int countDead()
    {
        int count = 0;
        for (Person individual : population)
        {
            if(individual.isDead != false)
            {
                count ++;
            }
        }
        return count;
    }
}

class Person 
{
    boolean isSick;
    boolean isDead;
    boolean isVac;
    double xPos, yPos;
    int daysLeftImmune;
    final double INIT_SICK_PROB = 20.0;
    final double GET_WELL_PROB = 25.0;
    final double DIE_PROB = 20.0;
    double INFECT_PROB = 15.0;
    final double RANGE = 2.0;
    final int DAYS_IMMUNE = 7;
    final double VACCINE_PROB = 80.0;
    final double VACCINE_EFFICIENCY = 80.0;
    
    Person(boolean isVaccinated)       
    {
        daysLeftImmune = 0;
        xPos = Math.random()*1000;
        yPos = Math.random()*1000;
        isDead = false;
        double chanceVac = Math.random()*100;
        if (isVaccinated != false && chanceVac <= VACCINE_PROB)
        {
            isVac = true;
            INFECT_PROB = INFECT_PROB * (1-VACCINE_EFFICIENCY/100);
        }
        else 
        {
            double chance = Math.random()*100;
            if (chance <= INIT_SICK_PROB)
            {
                isSick = true;
            }
            else
            {
                isSick = false;
            }
        }
        
    }
    
    /*void dayPasses()
    {
        double chance = Math.random()*100;
        if (isSick != false)
            {
            if (chance <= GET_WELL_PROB && chance > DIE_PROB)
            {
                isSick = false;
            }
            else if (chance <= DIE_PROB)
            {
                isDead = true;
                isSick = false;
            }
        }
    } */
    
    void dayPasses(Person[] allPersons)
    {
        double chance = Math.random()*100;
        if (isSick != false) //Person är sjuk
        {
            if (chance <= GET_WELL_PROB)
            {
                isSick = false;
                daysLeftImmune = DAYS_IMMUNE;
            }
            else
            {   
                double risk = Math.random()*100;
                if (risk <= DIE_PROB)
                {
                    isDead = true;
                    isSick = false;
                }
                else 
                {
                    for (Person individual : allPersons)
                    {
                        infect(individual);
                    }
                }
            }
        }
    }
    
    void becomesInfected() 
    {
        if (isDead != true && isSick != true && daysLeftImmune == 0)
        {
            double riskSick = Math.random()*100;
            if (riskSick <= INFECT_PROB)
            {
                isSick = true;
            }
        }
    }
    
    void infect(Person victim)
    {
        if (victim != this && Math.sqrt(xPos*xPos+yPos*yPos)<RANGE)
        {
            victim.becomesInfected();
        }
    }
     
}