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
    if at_index == 1:
        if text[at_index-1] not in EMAIL_CHARS:
            first_index = at_index
    for index in range(at_index-1, 0, -1): #baklänges!
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


def email_and_following_text (text):
    at_index = text.find("@")

    if at_index < 0:
        return None, None

    if find_name_start(text, at_index) == at_index:
        return None, text[at_index+1:]
        
    rest = text[find_name_end(text, at_index)+1:]
    mail = find_first_email(text)
    
    return mail, rest

def testfunction():
    testfall = ["svara till joachim@hotmail.com eller pelle@gmail.com", "@hi joachim@hotmail.com", "Hejsan svejsan", "Hej2@bla alex.sundquist@gmail.com", "alex@ hej på dig", "svara @på den här mailen alex.sundquist@gmail.com", "$@hej på dig", "a$@hej"]
    for test in testfall:
        print(test,"ger:",email_and_following_text(test))

#testfunction()