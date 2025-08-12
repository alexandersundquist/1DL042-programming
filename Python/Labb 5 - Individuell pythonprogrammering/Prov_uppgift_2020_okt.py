def count_U (list):
    counter_U = 0
    for grade in list:
        if grade == "U":
            counter_U+=1
    return counter_U

def count_VG (list):
    counter_VG = 0
    for grade in list:
        if grade == "VG":
            counter_VG+=1
    return counter_VG

def final_grade (list):
    total_U = count_U(list)
    total_VG = count_VG(list)
    if total_U/len(list) <= 1/3 and total_VG/len(list) >= 1/2:
        return "VG"
    elif total_U/len(list) <= 1/3 and total_VG/len(list) <= 1/2:
        return "G"
    else:
        return "U"

def test():
    list_of_lists = [["U","G","VG"],["VG"],["U","VG","VG","VG","U"]]
    for list in list_of_lists:
        print(list, "ger betyg", final_grade(list))

test()
