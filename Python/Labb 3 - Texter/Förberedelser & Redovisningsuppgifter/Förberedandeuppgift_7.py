import Förberedandeuppgift_6
import Förberedandeuppgift_3

def lower_remove_function (file_path):
    return Förberedandeuppgift_6.split_remove(Förberedandeuppgift_3.lower_of_files(file_path))

def test_function():
    testcases=["basketball_player_nicknames.txt", "employees.txt", "MLK_quote.txt", "soccer_players.txt", "testfil.txt"]
    for test in testcases:
        print ("filen", test, "är:\n", lower_remove_function(test))

test_function()