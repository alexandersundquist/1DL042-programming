n=0
summa=0
while True:
    x=int(input("Betyg:"))
    if x==0:
        break
    n=n+1
    summa=summa+x
print("Medelbetyget är", summa/n)

    


#Varje gång den går runt resettas n och summa till 0

