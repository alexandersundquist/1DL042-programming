import Förberedandeuppgift_4
import Förberedandeuppgift_5

def split_remove (text):
    list=Förberedandeuppgift_4.split_function(text)
    for i in range(len(list)):
        list[i] = Förberedandeuppgift_5.strip_function(list[i])
    return list

def test_function():
    testcases=["", "!?.,", "!Hej!", "!Hej! !på? dig! !Malin!"]
    for test in testcases:
        print (test, "är", split_remove(test))

#test_function()

#strip fungerar inte på listor utan bara på strängar verkar det som