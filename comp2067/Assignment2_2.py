"""
Assignment 2 for Programming for Beginners:
    Problem 2
    I chose to make the lower bound of each statement inclusive otherwise we run in
    to problems of 0, 30, 50, 80, and 99 not being included as valid input
Julia Garant
104987469
Feb 27 2020
"""
user = int(input("Enter a positive integer (between 0 to 99) "))
if 0 <= user < 30:
    result = 2**user
    print("You inputted:", user, ". This gives the result of {0:0.2f}".format(result))

elif 30 <= user < 50:
    result = 2 ** (0.3*user)
    print("You inputted:", user, ". This gives the result of {0:0.2f}".format(result))

elif 50 <= user < 80:
    result = 1.5 ** (0.3 * user)
    print("You inputted:", user, ". This gives the result of {0:0.2f}".format(result))

elif 80 <= user <= 99:
    result = 1.2 ** (0.2 * user)
    print("You inputted:", user, ". This gives the result of {0:0.2f}".format(result))

else:
    print("You did not enter a valid input!")
