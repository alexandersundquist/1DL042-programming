def create_dictionary (text):
    the_dictionary = {}
    for character in text:
        the_dictionary[character]=0
    return the_dictionary 

def test_function():
    testcases=["", "!?.,", "!Hej!", "!Hej! !på? dig! !Malin!", "H"]
    for test in testcases:
        print (test, "är", create_dictionary(test))

test_function()



