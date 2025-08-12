import random
import Uppgift_1
import Uppgift_3

def randomizer():
    randomlist=[]
    for n in range(0,9):
        randomlist.append(random.randint(-30,30))
    return randomlist

the_randomlist=randomizer()
the_randomlist_copy=the_randomlist+[]
if Uppgift_1.is_sorted(the_randomlist) == False:
    print(the_randomlist_copy, "sorterades till", Uppgift_3.bubblesort(the_randomlist))
