def dict_char_counter (text):
    the_dictionary = {}
    for character in text:
        if character in the_dictionary:
            the_dictionary[character]+=1
        else:
            the_dictionary[character]=1 
    return the_dictionary 

print(dict_char_counter(["Hej", "på", "dig", "Monika"]))