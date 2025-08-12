lista=[1,2,3]

def cumsum(t):
    sum=0
    cumsum_lista=[]
    for tal in t:
        sum+=tal              #Ger acumulative sum för pågående omgången av loopen
        cumsum_lista.append(sum)
    return cumsum_lista

print(cumsum(lista))


#t=[[1,2],[3]]
#summa=0
#t1=[]

#for i in range(len(t)):
#	for tal in t[i]:
#		summa=summa+tal
#		t1[i]=[summa]

#Ingen funkar:(

#t=[[1,2],[3]]
#summa=0
#t1=[0,0,0]

#for i in range(len(t)):
#    for tal in t[i]:
#        summa=summa+tal
#        t1[i]=[summa]