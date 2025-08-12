#3. Gör en funktion som importerar funktionerna i 1 och 2 ovan. Resultatet ska bli
#en funktion som öppnar en fil och returnerar texten med alla versaler omvandlade till
#gemener. Testa funktionen på samma sätt som i uppgift 1 (förmodligen kan samma
#testprogram återanvändas)

#def open_file (file_path):
   # file_name = open(file_path, "r")
    #print("Filnamnet som associerats till file_name:", file_name)
    #print("Den utskrivna filen är:", file_name.read())
  #  return file_name.read()

#def lower_case (text):
    #print("Texten som används", text)
    #print("Gemenerna av listan är:",text.lower())
 #   return text.lower()

import Förberedandeuppgift_2
import Förberedandeuppgift_1

def lower_of_files (file_path):
    #print("Här är argumentet som skickas in i lower_case och open_path:", file_path)
    #print(file)
    return Förberedandeuppgift_2.lower_case(Förberedandeuppgift_1.open_file(file_path))

def test_function():
    testcases=["basketball_player_nicknames.txt", "employees.txt", "MLK_quote.txt", "soccer_players.txt", "testfil.txt"]
    for test in testcases:
        print ("filen", test, "är:\n", lower_of_files(test))

#test_function()