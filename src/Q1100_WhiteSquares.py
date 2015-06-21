count = 0
for i in range(0, 8):
    str = input()
    for j in str[i%2:8:2]:
        if (j == 'F'):count += 1
print (count)