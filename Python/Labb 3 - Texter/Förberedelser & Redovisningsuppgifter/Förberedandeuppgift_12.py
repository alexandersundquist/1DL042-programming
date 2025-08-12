import Förberedandeuppgift_11

def max_appearances (text):
    the_dictionary=Förberedandeuppgift_11.dict_char_counter(text)
    place_holder=0
    highest_key={}
    for key in the_dictionary:
        if the_dictionary[key]>place_holder:
            place_holder=the_dictionary[key]
            highest_key=key
    return highest_key

print(max_appearances("aoolll"))

#metod för dictionary och kolla hur max
