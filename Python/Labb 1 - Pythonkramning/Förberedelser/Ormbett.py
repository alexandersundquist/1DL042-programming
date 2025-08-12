def ormbett():
    print("Ormen hugger...")
    print("du har", n, "liv kvar")

n=9
skatt=17
print("Här finns 20 ormhål")
print("I en av dem ligger skatten gömd!")

while n>0:
    x=int(input("Hand ner i hål nummer "))
    if x==skatt:
        print("Yay, du hittade skatten!")
        break
    else:
        n=n-1
        ormbett()