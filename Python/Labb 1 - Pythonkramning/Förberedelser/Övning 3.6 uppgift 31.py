def celsius(f):
    c=(f-32)/1.8
    return c
x=float(input("Temperatur (grader F):"))
y=celsius(x)
print("Alltså", y, "grader C")
