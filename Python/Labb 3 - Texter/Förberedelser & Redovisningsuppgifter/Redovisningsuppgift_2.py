def open_file (file_path):
    file_name = open(file_path, "r")
    return file_name.read()

def lower_case (text):
    return text.lower()

def lower_of_files (file_path):
    return lower_case(open_file(file_path))

def split_function (text):
    return text.split()

def strip_function (text):
    return text.strip("!´'-&.,()[]/?*")

def split_strip_function (text):
    list=split_function(text)
    for i in range(len(list)):
        list[i] = strip_function(list[i])
    return list

def lower_remove_function (file_path):
    return split_strip_function(lower_of_files(file_path))
#Retunerar en lista

def create_dictionary (list):
    the_dictionary = {}
    for index in range(len(list)-1):
        the_dictionary[list[index]]=[]
    return the_dictionary 

def append_proceeding_words (list):
    the_dictionary=create_dictionary(list)
    for index in range(len(list)-1):
        the_dictionary[list[index]].append(list[index+1])
    return the_dictionary

print(append_proceeding_words(lower_remove_function("allswell.txt")))