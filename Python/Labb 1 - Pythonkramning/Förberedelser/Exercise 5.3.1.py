def is_triangle(a,b,c):
    if a>b+c or b>a+c or c>a+b:
        print("No")
    else:
        print("Yes")
x=float(input("Vad är längden av första pinnen:"))
y=float(input("Vad är längden av andra pinnen:"))
z=float(input("Vad är längden av tredje pinnen:"))
is_triangle(x,y,z)

