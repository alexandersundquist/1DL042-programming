#test_file = open("employees.txt", "r")
#print(test_file.read())
#test_file.close()

#1. Gör en funktion med ett filnamn som parameter. Funktionen ska öppna filen och
#returnera texten i den. Gör sedan en funktion som testar att det fungerar på minst fem
#(små!) filer genom att skriva ut innehållet.

def open_file (file_path):
    file_name = open(file_path, "r")
    return file_name.read()
 
def test_function():
    testcases=["basketball_player_nicknames.txt", "employees.txt", "MLK_quote.txt", "soccer_players.txt", "testfil.txt"]
    for test in testcases:
        print ("filen", test, "är:\n", open_file(test))

test_function()
