def bytintill(li):
    copy_li = li + []
    for i in range(len(li)-1):
        if li[i] > li[i+1]:
            li[i] = copy_li[i+1]
            li[i+1]= copy_li[i]
            copy_li = li + []
            return True
    return False
  
def bubblesort(li):
    while bytintill(li) == True:
                bytintill(li)              
    return li

def test_function():
    testcases=[[],[1],[8,7,6,5,4,3,2,1],[1,-3,5,6],[1,5,7,5,9,3,22,4],[1,3,2],[2,5,4,6],[2,2,3,4]]
    for test in testcases:
        copy_test=test+[]
        print(copy_test, "sorteras till", bubblesort(test))

#test_function()


