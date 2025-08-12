#Skriv ett program som läser in ett heltal mindre än 100 och skriver ut det på svenska. Tex 39 ska bli “trettionio”. 
# Gör först en funktion som returnerar en sträng för ett ensiffrigt tal. Använd en lista [“ett, “två”, ...] för
#att slå upp rätt ord. Gör en motsvarande funktion för talen 10-19, och sedan en funktion för 20-99 som använder den första funktionen för att få 
# entalssiffran. Testa funktionen noga



def function_singular(singular):
    list_singular_string=["ett", "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio"]
    if singular == 0: 
        singular_in_word="noll"
    else: 
        singular_in_word=list_singular_string[singular-1]
    return singular_in_word

def function_tens(tens):
    list_tens_string=["tjugo", "tretio", "fyrtio", "femtio", "sextio", "sjutio", "åttio", "nitio"]
    return list_tens_string[tens-2]


def function_teen(teen):
    list_teen_string=["tio", "elva", "tolv", "treton", "fjorton", "femton", "sexton", "sjuton", "arton", "niton"]
    return list_teen_string[teen-10]

def test_function():
    testcases=range(9)
    for test in testcases:
        print(test, "ger resultatet", function_tens(test))

test_function()
