import Förberedandeuppgift_8

def str_occurring_char (text):
    the_dictionary=Förberedandeuppgift_8.create_dictionary(text)
    the_list=[]
    for key in the_dictionary:
        the_list.append(key)
    return "".join(the_list)


print(str_occurring_char("alla"))