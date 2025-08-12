mpg=float(input('Ange miles per gallon:'))
lpm=10./(mpg*1.609/3.785)
lpm = round(lpm,2)
print(f'Detta svarar mot {lpm} liter per mil')
