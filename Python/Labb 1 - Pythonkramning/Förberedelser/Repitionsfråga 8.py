def f(x):
    print("A")
    g(x)
    g(x-1)
    print ('B')
    return
def g(y):
    print ("C")
    if y>1: print ("D")
    print ("E")
    return

f(2)