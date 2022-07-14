"""
Lab 3 for Programming for Beginners
Julia Garant
Feb 3 2020
"""
wattage = int(input("Enter wattage: "))
hours = int(input("Enter number of hours used: "))
price = float(input("Enter price per kWh in cents: "))

electricity = (wattage*hours)/(1000*price)

# This line won't round to 2 decimal points
# print("Cost of electricity: ",electricity)

print("Cost of electricity: {0:0.2f}".format(electricity))
