def b_follow_a (text):
    if "a" in text:
        index_a = text.find("a")
        text_slice_a=text[index_a+1:]
    else:
        return False        
    if "b" in text_slice_a:
        return True
    else:
        return False

def testfunction():
    testfall=["arrb", "arr", "raa", "rrb", "arrarrb", "arrbrrb", "brra", "brr", "rrb", "brrbrra", "brrarra", "brrarrb", "brrarrbrra","arrbrrarrbrrarrb",""]
    for text in testfall:
        result=b_follow_a(text)
        if result == True:
            print("b följer a i", text)
        else:
            print("b följer inte a i", text)

testfunction()



