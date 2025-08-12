def strip_function (text):
    return text.strip("!´-&.,()[]/?*")

def test_function():
    testcases=["", "!?.,", "Hej!!!!!", "??**Kan", "!Hej!"]
    for test in testcases:
        print (test, "är", strip_function(test))

test_function()