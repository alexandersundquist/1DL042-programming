#1. Gör en funktion med en url som parameter, som öppnar en sida och skriver ut texten.
#Jämför med att öppna den i webläsaren och välj visa källkod – det bör bli samma sak.
#Prova tex på min hemsida http://user.it.uu.se/~joachim/

import urllib.request, ssl
ssl._create_default_https_context=ssl._create_unverified_context

def open_url (url):
    file_object=urllib.request.urlopen(url)
    content=file_object.read()
    text=content.decode("utf-8")
    return text

print(open_url("http://user.it.uu.se/~joachim/"))

#Vad är det som ska skrivas ut? Själva texten eller koden? För nu skrivs koden ut
#Vad är källkod och hur gör man den saken?