#Öppnar en fil för läsning
def open_file (file_path):
    file_name = open(file_path, "r")
    return file_name.read()

#Gör om alla bokstäver i en text till småbokstäver
def lower_case (text):
    return text.lower()

#Gör om en hel fil till små bokstäver (Använder första och andra funktionerna)
def lower_of_files (file_path):
    return lower_case(open_file(file_path))

#Gör om en sträng till en lista av ord
def split_function (text):
    return text.split()

#Skalar bort onödiga tecken från ett ord
def strip_function (text):
    return text.strip("!´-&.,()[]/?*")

#Skalar bort onödiga tecken från en hel text och returnerar en lista
def strip_entire_text (text):
    list=split_function(text)
    for i in range(len(list)):
        list[i] = strip_function(list[i])
    return list

#Tar en fil och gör om allt till små bokstäver och skalar bort onödiga tecken
def lower_strip_function (file_path):
    return strip_entire_text(lower_of_files(file_path))

#Räknar antalet ord i en text, alltså totala antalet ord 
def word_counter (text):
    return len(split_function(text))


#Tar in en lista och returnerar ett uppslagsverk med ord som nycklar och förekomsten av varje ord som värden
def char_appearance_counter (list):
    the_dictionary = {}
    for word in list:
        if word in the_dictionary:
            the_dictionary[word]+=1
        else:
            the_dictionary[word]=1 
    return the_dictionary 

#Räknar antalet ord i ett uppslagsverk, alltså antalet olika ord
def dict_word_counter(list):
    return len(char_appearance_counter (list))

#Tar fram ordet med flest förekomster
def word_max_appearance (list):
    the_dictionary=char_appearance_counter(list)
    times_most_frequent_word_has_appeared=0
    most_frequent_word={}
    for word in the_dictionary:
        if the_dictionary[word]>times_most_frequent_word_has_appeared:
            times_most_frequent_word_has_appeared=the_dictionary[word]
            most_frequent_word=word
    return most_frequent_word, times_most_frequent_word_has_appeared

#En funktion som öppnar en fil, tar bort alla onödiga tecken, gör om allt till små bokstäver, räknar totala antalet ord, räknar antalet olika ord och 

#För in lower_strip_function i max_appearace så får man en dictionary av en hel fil

#Räknar totalt antal ord i en fil
def total_words_in_file (file_path):
    return word_counter(open_file(file_path))

#Räknar antal olika ord från en fil
def total_unique_word_counter_in_file(file_path):
    return dict_word_counter(split_function(open_file(file_path)))

def word_max_appearance_in_file(file_path):
    return word_max_appearance(lower_strip_function(file_path))

def uppgift_1 (file_path):
    print("Det totala antalet ord i filen", file_path, "är", total_words_in_file(file_path))
    print("Antalet unika ord i filen", file_path, "är", total_unique_word_counter_in_file(file_path))
    print("Det ord som förekommer flest gånger i filen", file_path, "är", word_max_appearance_in_file(file_path)[0], "och ordet förekommer", word_max_appearance_in_file(file_path)[1], "gånger")
    return 

uppgift_1("allswell.txt")




