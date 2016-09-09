def Adding(n):
  if n == 1: return 1
  elif n == 2: return 2
  elif n == 3: return 4
  else: return Adding(n - 1) + Adding(n - 2) + Adding(n - 3)
 
for i in range(int(input())):
  num = int(input())
  print(Adding(num))