#3. Gör en funktion med en url som parameter som kollar om ditt namn finns på den sidan.
#Funktionen ska returnera en boolean som i uppgift 2.

import urllib.request, ssl
ssl._create_default_https_context=ssl._create_unverified_context

name="Datalogi"

def appearance_name (url):
    file=urllib.request.urlopen(url)
    content=file.read()
    text=content.decode("utf-8")
    return name in text

print(appearance_name("http://user.it.uu.se/~joachim/"))

#Ska man göra med en if sats?
