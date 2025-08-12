#Skriv	en	funktion som har	ett	heltalsargument	och	returnerar	en	lista	med	
#de	tal	som	talet	är	jämnt	delbart	med	(utom	talet	självt).	För	till	exempel	
#12	ska	listan	bli	[1,2,3,4,6]. Skriv	en	testfunktion	som	testar	funktionen	
#med	väl	valda	testfall.

def divisible (num):
    list_divisible = []
    for i in range(1, (num//2)+1):
        if (num % i) == 0:
            list_divisible.append(i)
    return list_divisible

print(divisible(12))