def a_follow_b (text):
    if "b" in text:
        index_b = text.find("b")
        text_slice_b=text[index_b+1:]
    else:
        return False        
    if "a" in text_slice_b:
        return True
    else:
        return False

def testfunction():
    testfall=["arrb", "arr", "raa", "rrb", "arrarrb", "arrbrrb", "brra", "brr", "rrb", "brrbrra", "brrarra", "brrarrb", "brrarrbrra","arrbrrarrbrrarrb",""]
    for text in testfall:
        result=a_follow_b(text)
        if result == True:
            print("a följer b i", text)
        else:
            print("a följer inte b i", text)

testfunction()