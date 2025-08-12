#6. Gör samma sak, med den skillnaden att funktionen ska kolla om bokstaven ”b”
#förekommer någonstans före en bokstav ”a”.

def b_follow_a (text):
    a_list=[]
    b_list=[]
    for i in range(len(text)):
        if text[i]=="a":
            a_list.append(i)
        elif text[i]=="b":
            b_list.append(i)
    for index in range(len(b_list)):
        for number in range(len(a_list)):
            if a_list[number]>b_list[index]:
                return True
    return False

def testfunction():
    testfall=["arrb", "arr", "raa", "rrb", "arrarrb", "arrbrrb", "brra", "brr", "rrb", "brrbrra", "brrarra", "brrarrb", "brrarrbrra","arrbrrarrbrrarrb",""]
    for text in testfall:
        result=b_follow_a(text)
        if result == True:
            print("b kommer före a i", text)
        else:
            print("b kommer inte före a i", text)

testfunction()