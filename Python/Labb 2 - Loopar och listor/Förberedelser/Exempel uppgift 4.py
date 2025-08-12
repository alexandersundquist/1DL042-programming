#Gör en funktion som kollar om talet 3 finns i en lista.
list1=[1,2,3,4,5,3,2,1]


def wanted_number(list):
    wanted_number=3
    found = False
    for number in list:
        if number==wanted_number:
            found=True
            break
    if found:
        print("Yes, there is a three in the list")
    else:
        print("No, there is no three")

wanted_number(list1)