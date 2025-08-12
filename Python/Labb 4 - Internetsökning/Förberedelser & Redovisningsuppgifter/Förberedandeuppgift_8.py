import string
EMAIL_CHARS = string.ascii_letters + string.digits + '.'

def find_first_email(text):
    at_index = text.find('@')
    if at_index < 0:
        return None
    name_start = find_name_start(text, at_index)
    if name_start == at_index:
        return None
    name_end = find_name_end(text, at_index)
    if name_end == at_index:
        return None
    return text[name_start : name_end+1]

def find_name_start(text, at_index):
    first_index = 0
    for index in range(at_index-1, 1, -1): #baklänges!
        if text[index] not in EMAIL_CHARS:
            first_index = index +1
            break
    return first_index

def find_name_end(text, at_index):
    last_index = 0
    if at_index == len(text)-1:
        last_index = at_index
    for index in range(at_index+1,len(text),1):
        if text[index] not in EMAIL_CHARS:
            last_index = index -1
            break
        if index == len(text)-1:
            last_index = index
    return last_index

def test_return_epost():
    testfall = ("hej@", "hej@a", "@hej","alex@@gmail.com","@","hej","b@","@b","alex/@gmail.com","12359@90","alex&sundquist%@.com","ALLA@GMAIL.","hej alex@gmail.se o din hej@hotmail.com")
    for test in testfall:
        print(test,"ger texten:",find_first_email(test))

test_return_epost()