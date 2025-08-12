def compute_place (list, time):
    if time not in list:
        return -1
    else:
        count_smaller_number = 0
        for number in list:
            if number < time:
                count_smaller_number+=1
    return 1+count_smaller_number

def test():
    list_of_lists = [[830,815,825,840,825], [815,829],[],[830]]
    list_of_times = [825, 812, 830]
    for list in list_of_lists:
        for time in list_of_times:
            if compute_place(list,time) > -1:
                print(time, "i", list, "har plats", compute_place(list, time))
            else:
                print(time, "i", list, "finns inte i listan")

test()