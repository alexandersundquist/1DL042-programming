def between_a_b (text):
    if "a" in text:
        index_a = text.find("a")
        text_slice_a=text[index_a+1:] 
    else: 
        return "a is not in", text       
    if "b" in text_slice_a:
        index_b = text_slice_a.find("b")
        text_between_a_b = text_slice_a[:index_b]
    else:
        return "b does not follow a in", text
    return "The word between first a and following b in", text, "is", text_between_a_b
    
def testfunction():
    testfall=["arrb", "arr", "raa", "rrb", "arrarrb", "arrbrrb", "brra", "brr", "rrb", "brrbrra", "brrarra", "brrarrb", "brrarrbrra","arrbrrarrbrrarrb",""]
    for text in testfall:
        print(between_a_b(text))
        

testfunction()
