x=float(input("Ett decimaltal:"))
n=x
n=n%1
if n>=0.5:
    print(x//1 + 1)
else:
    print(x//1)

x=float(input("Ett decimaltal:"))
n=x
n=int(n)
if n>=0.5:
    print(int(x)+1)
else:
    print(n)
