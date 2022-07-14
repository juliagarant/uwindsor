"""
Assignment 1 for Programming for Beginners:
    This program determines how many grapevines one can plant
    dependant on the space given
Julia Garant
104987469
Feb 3 2020
"""
# This line displays the user prompt as well as assigns a value to r
r= float(input("Enter the length of the row, in feet: "))

# This line displays a user prompt as well as assigns a value to e
e = float(input("Enter the amount of space, in feet, used by an end-post assembly: "))

# This line displays a user prompt as well as assigns a value to s
s = float(input("Enter the distance, in feet, between each vine: "))

v =(r - 2 * e)/s


print("You have enough space for ", v, " vines.")
