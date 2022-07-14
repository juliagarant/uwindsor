"""
Lab 6 for Programming for Beginners
Julia Garant
104987469
Feb 29 2020
"""

# integer value
order = int(input("Amount of oil is? "))

# real value
# if less than 150
if order < 150:
    cost = float(order * 2.25)

# if less than 250
elif order < 250:
    cost = float((150 * 2.25) + (order - 150) * 2.10)

# if greater than 250
else:
    cost = float((150 * 2.25) + (100 * 2.10) + (order - 250) * 1.99)

# display the cost of oil being purchased
print("The cost of the oil is ${0:0.2f}".format(cost))
