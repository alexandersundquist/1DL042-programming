def herons_formel(a,b,c):
    s=int((a+b+c)/2)
    area=s*(s-a)*(s-b)*(s-c)
    return area

def testfunction ():
    testfall = [(2,2,2), (4,4,4), (6,4,2), (5,5,4), (10,10,10)]
    