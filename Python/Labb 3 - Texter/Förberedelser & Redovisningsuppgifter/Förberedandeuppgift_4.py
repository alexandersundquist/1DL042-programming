#Definierar ord som att funktionen ska dela upp en sträng i en lista av ord som särkildes av mellanslag

def split_function (text):
    return text.split()

def test_function():
    testcases=["", "H", "123", "HeJsAn SvEjSaN", "?!#", "dethärärettjättelångtordutanmelanrum", "ett två tre fyra fem sex sju", "1 2 3 4 5 6 7"]
    for test in testcases:
        print (test, "är", split_function(test))

test_function()