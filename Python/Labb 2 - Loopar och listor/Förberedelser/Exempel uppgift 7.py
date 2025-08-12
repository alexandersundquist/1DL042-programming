#Gör en funktion som tar en lista och lägger till talet 3 på slutet.
list1=[1,2,3]
def add_three(list):
    list.append(3)
    return list

print(add_three(list1))