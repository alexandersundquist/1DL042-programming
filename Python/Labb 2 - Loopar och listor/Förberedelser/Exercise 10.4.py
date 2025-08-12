t=[1,2,3,4]

def chop(lista):
    del lista[0]
    del lista[-1]

print(chop(t))