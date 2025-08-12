import Redovisningsuppgift_1


def find_all_emails(text):
    list_email = []
    while len(text)>0:
        mail, rest = Redovisningsuppgift_1.email_and_following_text(text)
        if mail == None:
            break
        list_email.append(mail)
        text = rest
    return list_email

def testfunction():
    testfall = ["wdwd alex@hotmail.com dwdw", "alex@@hotmail.com","4@!", "@6","@", "hej", "", "12359@90", "34.@se", "ALLA@GMAIL.", "hej alex@gmail.se o din, är,! !hej@hotmail.com o karl@karlsson.is.io", "a@b och c@g och 4@d $@3 och s@s", "$@hej på dig", "a$@hej"]
    for test in testfall:
        print(test,"ger:",find_all_emails(test))

testfunction()