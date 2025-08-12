#Hitta alla länkar
def lower_case (text):
    return text.lower()

def remove_space (text):
    return text.replace(" ", "")
    
def lower_and_remove_space (text):
    return lower_case(remove_space(text))

def find_link_beginning (text):
    link_start_index = text.find('<ahref="')
    if link_start_index < 0:
        return None
    return link_start_index +8

def slice_link_start (text):
    if find_link_beginning(text) == None:
        return None
    return text[find_link_beginning(text):]

def find_link_ending (sliced_text):
    return sliced_text.find('"')

def get_link (text):
    sliced_text = slice_link_start (text)
    link = sliced_text[:find_link_ending(sliced_text)]
    return link 
    
def find_first_link (text):
    return get_link(lower_and_remove_space(text))

def link_and_rest (text):
    sliced_text = slice_link_start(lower_and_remove_space(text))
    if sliced_text == None:
        return None
    link = find_first_link(text)
    rest = sliced_text[find_link_ending(sliced_text)+1:]
    return link, rest

def find_all_links(text):
    list_links = []
    while len(text)>0:
        if link_and_rest(text) == None:
            break
        link, rest = link_and_rest(text)
        list_links.append(link)
        text = rest
    return list_links

def testfunction():
    testfall = ['<a href="Joachim-Parrow.jpeg"> hejsan svejsan <A HREF="http://www.it.uu.se/contact/">How to get here</A></b></center>','<A HREF="http://www.it.uu.se/contact/">How to get here</A></b></center>','<a href = "gomoku.html">Gomoku<a/>','<A HREF="http://user.it.uu.se/~joachim/">Joachim Parrow</A>','<a href="piano.html">']
    for test in testfall:
        print(find_all_links(test))

testfunction()