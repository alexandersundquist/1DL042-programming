myfriends=["Bo", "Siv"]
yourfriends=["Ann", "Per"]
friendlist=[myfriends,yourfriends]
allfriends=myfriends+yourfriends        #Skapar en klon
myfriends.extend(yourfriends)           #Skapar inte en klon
yourfriends.remove("Per")               #Skapar inte en klon
myfriends.remove("Ann")

