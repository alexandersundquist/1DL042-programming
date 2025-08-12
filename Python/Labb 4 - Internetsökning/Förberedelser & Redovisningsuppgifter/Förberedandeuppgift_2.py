#2. Gör en funktion med en url som parameter och kollar om den finns (dvs går att öppna).
#Änvänd ett exception. Funktionen ska returnera True om den går att öppna och False
#om den inte går att öppna.

import urllib.request, ssl
ssl._create_default_https_context=ssl._create_unverified_context

def can_open (url):
    try:
        urllib.request.urlopen(url)
        sucess=True
    except:
        sucess=False
    return sucess

print(can_open("http://user.it.uu.se/~joachim/"))

