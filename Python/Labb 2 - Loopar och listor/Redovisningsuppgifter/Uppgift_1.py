def is_sorted(list):
    if list==[]:
            return 2
    for i in range(len(list)-1):
        if list[i]>list[i+1]:
            return False           
    return True


def test_function():
    testcases=[[],[1],[2,5,4,6],[2,2,3,4]]
    for test in testcases:
        if is_sorted(test) == True:
            print(test, "är sorterad")
        elif is_sorted(test) == 2:
            print(test, "är en tom lista och har alltså ingen ordning")
        else:
            print(test, "är inte sorterad")


#test_function()
