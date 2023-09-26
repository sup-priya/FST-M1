#Enter user name
username = input("Enter your name:")
#Enter user age
userage = input("Enter your age:")
print("Your name is: " + username + " & your age is: " + userage)

userfutureage = 100 - int(userage)
userfutureyear = 2023 + int(userfutureage)
a = "You will turn 100 years in: {}"
print(a.format(userfutureyear))