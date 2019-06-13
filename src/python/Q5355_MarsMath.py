for i in range(0, int(input())):
     str = input().split()
     result = float(str[0])
     for j in str[1:]:
         if j == '@': result *= 3
         elif j == '%': result +=5
         elif j == '#': result -= 7
     print ("%.2f" % result)