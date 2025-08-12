def seconds(d,h,m,s):
    seconds=d*(24*60*60)+h*(60*60)+m*(60)+s
    return seconds
print(seconds(1,2,3,4))
