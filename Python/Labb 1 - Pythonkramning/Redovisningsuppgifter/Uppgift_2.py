def udda_jämn (n):
    print(n)
    while n!=1:
        if n%2==0:
            n=n/2
            print(int(n))
        else:
            n=n*3+1
            print(int(n))
    return n

udda_jämn(8)