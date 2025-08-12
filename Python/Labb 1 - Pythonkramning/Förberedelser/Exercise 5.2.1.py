def check_fermat(a,b,c,n):
    if n>2 and c**n=a**n+b**n:
        print("Holy smokes, Fermat was wrong!")
    else:
        print("No that doesn't work.")
x=int(input("Vad är första basen?"))
y=int(input("Vad är andra basen?"))
z=int(input("Vad är tredje basen som de första ska vara lika med?"))
q=int(input("Vad är exponenten som talen ska höjas upp i(n>2)?"))
check_fermat(x,y,z,q)