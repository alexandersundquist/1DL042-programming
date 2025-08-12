x=float(input("Började jobba:"))
y=float(input("Slutade jobba:"))
n=x
n=n%1
n=n*100
n=n/60
m=n+x//1

r=y
r=r%1
r=r*100
r=r/60
s=r+y//1

z=(97*(s-m))
a=z
a=a%1
if a>=0.5:
    print(int(z//1+1))
else:
    print("Arbodet blir", int(z), "kr")