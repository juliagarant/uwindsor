"""
Assignment 3 for Programming for Beginners
Julia Garant
104987469
Mar 29 2020
"""


def main():
    user_num = int(input("Enter an integer greater than 1: "))
    numbers = []
    for count in range(2, user_num + 1):    # range is (inclusive,exclusive) which is why I need +1
        numbers.append(count)

    for i in range(len(numbers)):
        prime_or_composite(numbers[i])


def prime_or_composite(n):
    has_divisor = False

    for i in range(2, n):
        if n % i == 0:
            has_divisor = True

    if has_divisor:  # if true
        print(n, " is composite.")
    elif not has_divisor:  # if false
        print(n, " is prime.")


main()
