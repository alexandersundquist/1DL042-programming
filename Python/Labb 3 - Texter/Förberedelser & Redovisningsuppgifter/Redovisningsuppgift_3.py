import random

def open_file (file_path):
    file_name = open(file_path, "r")
    return file_name.read()

def split_function (text):
    return text.split()

def list_of_file (file_path):
    return split_function(open_file(file_path))

def number_of_words (list):
    return len(list)

def words_in_file_function (file_path):
    return number_of_words(list_of_file(file_path))

def create_empty_dictionary (list):
    the_dictionary = {}
    for index in range(len(list)-1):
        the_dictionary[list[index]]=[]
    return the_dictionary 

def append_proceeding_words (list):
    the_dictionary=create_empty_dictionary(list)
    for index in range(len(list)-1):
        the_dictionary[list[index]].append(list[index+1])
    return the_dictionary

def create_dictionary (file_path):
    return append_proceeding_words(list_of_file(file_path))

def get_list_keys(dict):
    return list(dict.keys())

def get_list_values(dict):
    return list(dict.values())

def amount_of_words(number):
    words_in_the_text=words_in_file_function("allswell.txt")
    if number==0:
        print("No words in text")
        return 
    elif number > words_in_the_text:
        print ("Too many words")
        return 
    else:
        return number

def write_text (number):
    the_dictionary=create_dictionary("allswell.txt")
    key_list=get_list_keys(the_dictionary)
    new_list=[]
    word=random.choice(key_list)
    new_list.append(word)
    words_in_new_text=1
    total_words_in_text = amount_of_words(number)
    while words_in_new_text<total_words_in_text:
        element_in_value_list=the_dictionary[word]
        followingword=random.choice(element_in_value_list)
        while followingword not in the_dictionary:
            followingword=random.choice(element_in_value_list)
        new_list.append(followingword)
        word=followingword
        words_in_new_text+=1
    new_text=" ".join(new_list)
    return new_text

def test_function ():
    testcases=[100]
    for test in testcases:
        print(write_text(test))

test_function()