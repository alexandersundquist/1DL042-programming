def palindrom ():
    base = 0
    adr = base
    Memory = []
    while True:
        newnum = int(input("skriv tal:"))
        Memory.append(newnum)
        Memory[adr] = newnum
        if newnum == 0:
            break
        adr += 1
    while base <= adr:
        if Memory[base] != Memory [adr-1]:
            return 0
        else:
            base += 1
            adr -= 1
    return 1

print(palindrom())

    
        
