lista1=[[1,2],[3],[4,5,6]]

def nested_sum(main_list):
    summa=0
    for i in range(len(main_list)):
        for tal in main_list[i]:
            summa=summa+tal
    return summa

print(nested_sum(lista1))

