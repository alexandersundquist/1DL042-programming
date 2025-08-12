#nummer 1
temp = float(input("Utetemperatur: "))
if temp<5:
    print("Ta på dej halsduken!")
else:
    print("Då slipper du halsduken!")

#nummer 2
if age<18:
    print("Barnbiljett")
else:
    if age>=65:
        print("Pensionärsbiljett")
    else:
        print("Vuxenbiljett")

#nummer 3 (variant av #2)
if age<18:
    print("Barnbiljett")
elif age>=65:
    print("Pensionärsbiljett")
else:
    print("Vuxenbiljett")