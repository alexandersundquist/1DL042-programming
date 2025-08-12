#Gör en funktion som kollar om talet 3 finns i en lista två gånger precis efter varandra. 

list1=[1,4,2,3,0]
list2=[1,2,3,3,5]
list3=[1,3,5,3,6]

def consequtive_threes (list):
    found=False
    for i in range(len(list)-1):
        if list[i] == 3 and list[i+1] == 3:
            found = True
            break
    if found==True:
        print("Ja talet 3 finns i listan två gånger precis efter varandra")
    else:
        print("Tyvärr, talet 3 finns inte i listan två gånger precis efter varandra")

consequtive_threes(list3)

