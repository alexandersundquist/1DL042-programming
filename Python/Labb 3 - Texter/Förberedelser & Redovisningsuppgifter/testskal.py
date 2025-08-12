def total_words_in_file (file_path):
    return word_counter(open_file(file_path))

def word_counter (text):
    return len(split_function(text))

def split_function (text):
    return text.split()

def open_file (file_path):
    file_name = open(file_path, "r")
    return file_name.read()

print(total_words_in_file("testfil.txt"))

