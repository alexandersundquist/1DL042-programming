def find_all_emails(text):
    lista = []
    while len(text)>0:
        mail, rest = find_email_and_return_rest(text)
        if mail ==  None:
            break
        lista.append(mail)
        text= rest
    return lista

import string

EMAIL_CHARS = string.ascii_letters + string.digits + '.'


def find_name_start(text, at_index):
    first_index = 0
    for index in range(at_index - 1, -1, -1):  # baklänges!
        if text[index] not in EMAIL_CHARS:
            first_index = index + 1
            break
    return first_index


def find_name_end(text, at_index):
    last_index = 0
    for index in range(at_index + 1, len(text), 1):  # framlänges!
        if text[index] not in EMAIL_CHARS:
            last_index = index - 1
            break
        if index == len(text) - 1:
            last_index = index
    return last_index


def find_first_email(text):
    at_index = text.find('@')
    if at_index < 0:
        return None
    name_start = find_name_start(text, at_index)
    if name_start == at_index:
        return None
    return text[name_start: at_index]


def find_last_email(text):
    at_index = text.find('@')
    if at_index < 0:
        return None
    name_end = find_name_end(text, at_index)
    if name_end == at_index:
        return None

    return text[at_index + 1: name_end + 1]


def find_email(text):
    name = find_first_email(text)
    if name is None:
        return None
    adress = find_last_email(text)
    if adress is None:
        return None
    if check_if_at(name) or check_if_at(adress):
        return None
    email = str(name + "@" + adress)
    return email


def check_if_at(word):
    b = False
    for char in word:
        if char == "@":
            b = True
    return b

def find_email_and_return_rest(text):
    mail = find_email(text)
    at_index = text.find('@')
    rest = str(text[at_index + 1:])
    name_end = find_name_end(text, at_index)
    if at_index < 0:
        mail = None
        rest = None
    if mail is not None:
        rest = str(text[name_end + 1:])
    return mail, rest

def find_all_emails_test():
    testfall = ["wdwd vera@hotmail.com dwdw", "vera@@hotmail.com","4@!", "@6","@", "hej", "", "12359@90", "34.@se", "ALLA@GMAIL.",
                "hej vera@gmail.se o din, är,! !hej@hotmail.com o karl@karlsson.is.io", "a@b och c@g och 4@d $@3 och s@s","$@hej på dig", "a$@hej"]
    for test in testfall:
        print(test, "blir med vår funktion:", find_all_emails(test))

find_all_emails_test()