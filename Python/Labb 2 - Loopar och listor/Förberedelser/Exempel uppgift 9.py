#Gör en funktion som tar en lista och byter plats på 3e och 4e elementen.
list1=[1,2,3,4]

def element_swap(list):
    c=list+[]
    list[2]=c[3]
    list[3]=c[2]
    return list
        
print(element_swap(list1))