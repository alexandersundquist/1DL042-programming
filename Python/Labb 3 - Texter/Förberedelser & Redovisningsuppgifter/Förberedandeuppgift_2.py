#2. Gör en funktion med en text (alltså typ str) som parameter. Funktionen ska
#returnera texten där alla versaler (stora bokstäver) omvandlats till gemener (små
#bokstäver). Det finns en bra strängmetod för detta, leta i dokumentationen! Gör sedan
#en funktion som testar att det fungerar på minst sju texter. Glöm inte hörnfallen i
#området, t.ex. tomma strängen, en sträng med bara ett tecken, en sträng med bara ickealfabetiska tecken etc.

def lower_case (text):
    return text.lower()

def test_function():
    testcases=["", "H", "h", "123", "HeJsAn SvEjSaN", "?!#"]
    for test in testcases:
        print (test, "är", lower_case(test))

test_function()