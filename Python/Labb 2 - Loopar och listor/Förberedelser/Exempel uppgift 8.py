#Gör en funktion som tar en lista och ändrar alla tal 3 till 4.

list1=[1,2,3,5,3]

def number_change(list):
    for index in range(len(list)):
            if list[index]==3:
                list[index]=4
    return list

print(number_change(list1))
