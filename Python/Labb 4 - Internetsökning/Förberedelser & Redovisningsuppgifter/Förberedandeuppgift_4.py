#4. Gör en funktion med en text som parameter som returnerar hur många gånger texten
#finns på DNs hemsida. Använd det för att kolla vilken partiledare som nämns mest. Prova
#också med några andra tidningar.

import urllib.request, ssl
ssl._create_default_https_context=ssl._create_unverified_context

def appearance_counter (name):
    file=urllib.request.urlopen(url)
    content=file.read()
    text=content.decode("utf-8")
    return text.count(name)

url="https://www.svd.se/"             #"https://www.dn.se/", "https://www.svd.se/", "https://www.expressen.se/", "https://www.aftonbladet.se/"]    

partiledare = ["Trump", "Löfven", "Tegnell"]

print(url)
for person in partiledare:
    print(person, "nämns", appearance_counter(person), "gång(er)")
