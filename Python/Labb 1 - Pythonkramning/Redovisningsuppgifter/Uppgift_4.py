def sekvenslängd (n):
    m=1
    while n!=1:
        if n%2==0:
            n=n/2    
        else:
            n=n*3+1
        m=m+1    
    return m
print(sekvenslängd(8))