def siffersumma(n):
    summa=0
    while n>0:
        summa=summa+n%10
        n=n//10
    return summa

print(siffersumma(1532))

