#Hitta alla länkar på en websida
from urllib.parse import urljoin

import urllib.request, ssl
ssl._create_default_https_context=ssl._create_unverified_context

def lower_case (text):
    return text.lower()

def remove_space (text):
    return text.replace(" ", "")
    
def lower_and_remove_space (text):
    return lower_case(remove_space(text))

def find_link_beginning (text):
    link_start_index = text.find('<ahref="')
    if link_start_index < 0:
        return None
    return link_start_index +8

def slice_link_start (text):
    if find_link_beginning(text) == None:
        return None
    return text[find_link_beginning(text):]

def find_link_ending (sliced_text):
    return sliced_text.find('"')

def get_link (text):
    sliced_text = slice_link_start (text)
    link = sliced_text[:find_link_ending(sliced_text)]
    return link 
    
def find_first_link (text):
    return get_link(lower_and_remove_space(text))

def link_and_rest (text):
    sliced_text = slice_link_start(lower_and_remove_space(text))
    if sliced_text == None:
        return None
    link = find_first_link(text)
    rest = sliced_text[find_link_ending(sliced_text)+1:]
    return link, rest

def find_all_links(text):
    dict_links = {}
    while len(text)>0:
        if link_and_rest(text) == None:
            break
        link, rest = link_and_rest(text)
        dict_links[link]=0
        text = rest
    return dict_links

#Öppnar url och returnerar en text
def open_url (url):
    file=urllib.request.urlopen(url)
    content=file.read()
    text=content.decode("utf-8")
    return text

#Gör om dictionary till lista
def dict_to_list (dictionary):
    return list(dictionary.keys())

#Vi har en lista av alla länkar på en sida. Kan vi loopa över lista

def create_complete_urls (url):
    list_complete_urls = []
    list_incomplete_urls = dict_to_list(find_all_links(open_url(url)))
    for link in list_incomplete_urls:
        list_complete_urls.append(urljoin(url, link))
    return list_complete_urls

def print_list (list):
    for element in list:
        print(element)
    return 

print_list(create_complete_urls("http://user.it.uu.se/~joachim/"))