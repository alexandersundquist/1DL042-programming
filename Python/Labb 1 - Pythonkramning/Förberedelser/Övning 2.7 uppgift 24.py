print("Hur många sekunder önskar du konvertera till dagar, timmar, minuter och sekunder?")
sekunder=input()
sekunder=int(sekunder)
print(sekunder, "sekunder")
sekunder /=60
print(sekunder, "minuter")
sekunder /=60
print(sekunder, "timmar")
sekunder /=24
print(sekunder, "dagar")
