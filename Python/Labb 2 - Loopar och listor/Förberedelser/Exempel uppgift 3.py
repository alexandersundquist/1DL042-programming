#Gör en funktion som kollar hur många gånger talet 3 finns i en lista.
def total_number_threes(list):
    totalthrees = 0
    for number in list:
        if number == 3:
            totalthrees+=1
    return totalthrees

print(total_number_threes([1,3,5,6,3,1,3]))
