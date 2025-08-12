#Kollar om talet 0 förekommer i en lista

#list=[1,5,19,0,6]

#for tal in list:
 #   if tal == 0:
  #      print("Ja! Vi hittade 0:an")
   #     break

#Räknar ut det sammanlagda antalet bokstäver i dina vänners namn

#vänner=["Salina", "Marcus", "Victor"]
#summa_bokstäver=0
#for i in range(len(vänner)):
 #   for namn in vänner[i]:
  #      summa_bokstäver+=len(namn)

#print(summa_bokstäver)
        
#Räknar hur många gånger talet 0 förekommer i en lista

lista=[1,2,6,7,0,4,0]
summa_nollor=0
for tal in lista:
    if tal == 0:
        summa_nollor+=1
print(summa_nollor)        