import Uppgift_4

def sequence(y):
    maximum_längd=0
    x=1
    while x<=50:
        print(x, "has sequence length", Uppgift_4.sekvenslängd(x))
        if Uppgift_4.sekvenslängd(x)>maximum_längd:
            maximum_längd=Uppgift_4.sekvenslängd(x)
            a=x
        x=x+1
    print("Maximum at", a, "is", maximum_längd)
    return x

sequence(50)