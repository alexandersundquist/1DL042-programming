#5. Gör en funktion med en text som parameter som kollar om bokstaven ”b” förekommer
#någonstans efter (inte nödvändigtvis omedelbart efter) en bokstav ”a”. Funktionen ska
#returnera en boolean. Tips: börja med att skissa på exempel, som sedan blir testfall.
#Exempelvis när det finns noll, ett eller flera ”a”, noll, ett eller flera ”b”, där ”a”
#respektive ”b” står allra först eller allra sist etc. Det blir säkert ett dussin sådana testfall.
#Bygg in dem i en testfunktion. Fördelen med att göra dem innan man börjar koda är att 
#uppgiften blir mer väldefinierad. Ett tips för kodningen är att använda strängmetoden
#find(). Testa den i så fall först i skalet så du begriper vad den gör


def b_follow_a (text):
    a_list=[]
    b_list=[]
    for i in range(len(text)):
        if text[i]=="a":
            a_list.append(i)
        elif text[i]=="b":
            b_list.append(i)
    for index in range(len(b_list)):
        for number in range(len(a_list)):
            if a_list[number]<b_list[index]:
                return True
    return False

def testfunction():
    testfall=["arrb", "arr", "raa", "rrb", "arrarrb", "arrbrrb", "brra", "brr", "rrb", "brrbrra", "brrarra", "brrarrb", "brrarrbrra","arrbrrarrbrrarrb",""]
    for text in testfall:
        result=b_follow_a(text)
        if result == True:
            print("b följer a i", text)
        else:
            print("b följer inte a i", text)

testfunction()

