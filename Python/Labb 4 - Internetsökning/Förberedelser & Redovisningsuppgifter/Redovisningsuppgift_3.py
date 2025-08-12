import urllib.request, ssl
ssl._create_default_https_context=ssl._create_unverified_context
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

def find_all_emails(text):
    dict_email = {}
    while len(text)>0:
        mail, rest = email_and_following_text(text)
        if mail == None:
            break
        dict_email[mail]=0
        text = rest
    return dict_email

#Öppnar url och returnerar en text
def open_url (url):
    file=urllib.request.urlopen(url)
    content=file.read()
    text=content.decode("utf-8")
    return text

#Gör om dictionary till lista
def dict_to_list (dictionary):
    return list(dictionary.keys())

def print_list (list):
    for element in list:
        print(element)
    return 

def print_emails_from_url(url):
    return print_list(dict_to_list(find_all_emails(open_url(url))))

def testfunction():
    testfall = ["http://user.it.uu.se/~joachim/","http://www.it.uu.se/katalog/bylastname"]
    for test in testfall:
        print(test, "innehåller följande mail:"), print_emails_from_url(test)

testfunction()