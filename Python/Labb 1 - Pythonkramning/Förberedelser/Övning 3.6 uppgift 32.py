def idealvikt(längd):
    i=längd-105
    return i
x=float(input("Din längd (cm): "))
y=idealvikt(x)
print("Din idealvikt är", int(y), "kg")
