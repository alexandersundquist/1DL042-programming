while 1<2:      #Skriver ett vilkor som alltid kommer stämma för att skapa en loop. Frågan ålder kommer upprepas tills man skriver in åldern 0 då den breakar.
    age=int(input("Ålder (avsluta med nolla):"))
    if age ==0:
        break
    print(65-age, "år till pensionen.") #Så medan man skriver in en ålder som inte är 0 kommer den fortsätta att fråga
print("Tack för den här gången!")