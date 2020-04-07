from math import ceil
 
n, a, b = map(int, input().split())
count = 0
while a != b:
    count += 1
    a = ceil(a / 2)
    b = ceil(b / 2)
print (count)