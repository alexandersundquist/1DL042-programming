#Gör en funktion som kollar var talet 3 finns i en lista.
list1=[1,3,5,3]

def locate_number(list):
    for i in range(len(list)):
        if list[i] == 3:
            print("Talet 3 hittas på plats", (i+1))

locate_number(list1)