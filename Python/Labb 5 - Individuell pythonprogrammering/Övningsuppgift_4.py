#Skriv	en	funktion	som	har	en	lista	med	tal	som	argument	och	returnerar	
#True om	något	tal	i	listan	förkommer	minst	två	gånger,	och	annars	
#False.		Skriv	en	testfunktion	som	testar	funktionen	med	väl	valda	testfall.

def duplicate_number (list):
    for i in range(len(list)):
        for following_number in list[i+1:]:
            if following_number == list[i]:
                return True 

def test():
    list_of_lists = [[1,2,3,4],[2,4,6,2],[6,4,2,5,8,2]]
    for list in list_of_lists:
        if duplicate_number(list):
            print(list, "has following numbers")
        else:
            print(list, "dose not have following numbers")

test()
