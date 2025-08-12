while 1<2:
    cm=float(input("Din längd i cm:"))
    if 130<cm<230:
        break       #Avslutar endast loopen ifall man skriver in en längd som är rimlig, annars kommer programmet fortsätta run:a pga while-satsen.
    print("Orimlig, försök igen!")
