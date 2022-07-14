"""
Assignment 2 for Programming for Beginners:
    Problem 1
Julia Garant
104987469
Feb 27 2020
"""
import math

total_cost = float(input("What is the cost of your dream house: $"))  # 100000
portion_down_payment = float(total_cost * 0.25)  # 25000
current_savings = 0.00
num_of_months = 0
r = 0.04    # interest rate

annual_salary = float(input("What is your annual salary: $"))  # 60000
monthly_salary = annual_salary / 12  # 5000

portion_saved = float(input("What portion of that do you want to save(%): "))
portion_saved = portion_saved / 100  # 10%
temp = portion_saved * monthly_salary  # 500

while current_savings < portion_down_payment:    # at the end of each month
    current_savings += temp + (temp * r / 12)
    num_of_months += 1
"""
# originally I asked my dad, who is a math teacher, for help on this question and this was the solution
# he came up with. I believe it works, it just looked a little complicated for this material.
num_of_months = (math.log( ((portion_down_payment*r/12)/current_savings)+1 , 10))/ math.log(1+r/12,10)
"""

print("It will take", num_of_months, "months to save $", portion_down_payment)
