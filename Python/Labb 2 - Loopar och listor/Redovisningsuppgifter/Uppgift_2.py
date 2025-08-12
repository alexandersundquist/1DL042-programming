def initials(namn):
    initial_list=""
    namnlista=namn.split()
    for namn in range(len(namnlista)):
        initial_list+=(namnlista[namn][0])
        initial_list+=(".")
    return initial_list

def test_function():
    testcases=["","Saga", "","Alexander Håkan Sundquist", "Hannes Bertil Karlsson Birgitta Johan", "Karl-Gustav Johansson"]
    for test in testcases:
        print(test, "har initialerna", initials(test))

test_function()

