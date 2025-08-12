n=float(input("Vilket tresiffrigt tal vill du ha siffersumman av?"))
summa=0
summa=summa+n%10
n=n//10
summa=summa+n%10
n=n//10
summa=summa+n%10
print("siffersumman av", int(n), "är", int(summa))
