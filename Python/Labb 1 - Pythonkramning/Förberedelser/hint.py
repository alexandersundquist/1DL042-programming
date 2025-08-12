# Joachim Parrow december 2020

import random,urllib.request,ssl
ssl._create_default_https_context = ssl._create_unverified_context

def hint():
    print ("Goda råd från STS2 2020")

    # Följande fyra rader läser in en textfil till en lista med textrader
    file_object = urllib.request.urlopen("http://user.it.uu.se/~joachim/hints.txt")
    content = file_object.read()
    text_content = content.decode('utf-8')
    hints = text_content.split('\n')

    answer = input("Vill du ha ett gott råd? (j/n)")
    while answer == "j":
        thehint = random.choice(hints)
        hints.remove(thehint)
        print (thehint)
        if hints == []: break
        answer = input("Ett råd till? (j/n)")
    return

hint()
