#Alexander Sundquist

def get_first_average (list):
    first_value = list[0]
    second_value = list[1]
    average = (first_value + second_value)/2 
    return round(average,2)

def get_last_average (list):
    last_value = list[-1]
    second_last_value = list[-2]
    average = (last_value + second_last_value)/2 
    return round(average,2)

def get_average_inbetween (list):
    value1 = list[0]
    value2 = list[1]
    value3 = list[2]
    average = (value1 + value2 + value3)/3
    return round(average,2)

def noise_reduce (list):
    new_list = []
    first_average = get_first_average(list)
    new_list.append(first_average)
    for i in range(len(list)-2):
        list_variant = list[i:i+3]
        average_inbetween = get_average_inbetween(list_variant)
        new_list.append(average_inbetween)
    last_average = get_last_average(list)
    new_list.append(last_average)
    return new_list

def test_function ():
    list_of_lists = [[1.0,2.0,4.0], [2.0,5.0], [3.0,3.0], [10000.0,5000.0], [2.3333333,5.8888888], [3.0,4.2,6.0,10.5,3.15], [3.0,5.0,4.0,6.0,2.0,2.0,5.0,8.0], [2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0], [2.12345678910,3.6583219876,7.2863256473], [1000.0,10000.0,100000.0,1000.0], [1,2.0,4,6.5]]
    for list in list_of_lists:
        print(list, "ger", noise_reduce(list))

def uppgift():
    test_function()

uppgift()


