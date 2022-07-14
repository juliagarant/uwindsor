"""
Lab 9 for Programming for Beginners
Julia Garant
104987469
Mar 25 2020
"""
user = input("Please enter a positive integer between 1 and 10: ")
row = int(user)  # you need to type cast row and col in order to use range
col = int(user)

# using range(1, row+1 (or col+1)) makes it inclusive, so it starts at 1
# and goes up to and including its bound (row or col)
for i in range(1, row+1):
    for j in range(1, col+1):
        print(i*j, "\t", end="")
        # print('{:4d}'.format(i*j), end='')
    print()
