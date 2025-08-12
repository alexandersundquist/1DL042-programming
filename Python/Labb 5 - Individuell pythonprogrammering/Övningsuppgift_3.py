#Som	vokaler	i	engelska	språket	räknar	vi	i	denna	uppgift	bokstäverna	
#aeuio,	och	som	konsonanter	alla	andra	bokstäver	utom	y	(y	fungerar	
#ibland	som	konsonant	och	ibland	som	vokal	och	därför	struntar	vi	i	den	
#just nu).	Skriv	ett	program	som	räknar	ut	hur	många	engelska	ord	har	
#precis	lika	många	konsonanter	som	vokaler.	En	lista	av	engelska	ord	finns	
#i	filen	words.txt.	



def is_vowel (char):
    vocals = "aeuio"
    if char in vocals:
        return True
    else:
        return False

def is_consonant (char):
    if is_vowel(char):
        return False
    if char =="y":
        return False
    return True

def count_vowel (word):
    counter_vowels = 0
    for char in word:
        if is_vowel(char):
            counter_vowels+=1
    return counter_vowels

def count_consonant (word):
    counter_consonant = 0
    for char in word:
        if is_consonant(char):
            counter_consonant+=1
    return counter_consonant

def vowel_consonant (word):
    if count_vowel(word) == count_consonant(word):
        return True


def open_file (file_path):
    file_name = open(file_path, "r")
    return file_name.read()

def string_to_list (text):
    return text.split()

def file_to_list(file_path):
    return string_to_list(open_file(file_path))

def check_vowel_and_consonant_in_file (file_path):
    counter_even_words = 0
    list_of_words = file_to_list(file_path)
    for word in list_of_words:
        if vowel_consonant(word):
            counter_even_words+=1
    return counter_even_words

print(check_vowel_and_consonant_in_file("words.txt"))
