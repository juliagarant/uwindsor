"""
Lab 5 for Programming for Beginners
Julia Garant
104987469
Feb  2020
"""
list1 = [chr(100),"Audi","FCA","General Motors","Ford", "Dodge", "5" +chr(102)]
list1.sort()
print(list1)

flowers = [("Marigold", -5),("Tulips",2),("Daffodils",6),("Alstroemeria", 1)]
flowers.sort()
print(flowers)

x1 = 5
y1 = 5
x2 = 'Agapanthus'
y2 = 'Star of Bethlehem'
x3 = [1,2,3]
y3 = [1,2,3]
print(x1 is not y1) #false (integers can be equal)
print(x2 is y2) #false (strings can be equal)
print(x3 is y3) #false (they are equal but have different memory locations)

x = 'Bee Balm Flower'
y = {1:-1,2:'a'}
print('F' in x) #true
print('Balm' not in x)  #false
print(1 in y)   #true
print('a' in y) #false('a' is the VALUE at 2, 2 is the index)

txt = " Hello from the outside At least, I can say that I've tried"
x = txt.startswith("outside", 17, 23)   #becomes true if start=16 and end=23
print("x is "+ str(x))  #false

tuplex = 5, 10, 15, 20, 25
print(tuplex)   #tuple's are mutatable
tuplex = 5, 15
print(tuplex)

tup = ('r','o','l','e','y','p','o','l','e','y')
tup1 = ''.join(tup)
print(tup1)
tuplex = 2, 4, 5, 6, 2, 3, 4, 4, 7
print(tuplex)
