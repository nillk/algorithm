n, l = map(int, input().split())
isFind = False
for i in range(l, 101):
	additional = (i**2 - i)//2;
	x = n - additional
	if x < 0: break
	if x == 0 or x % i == 0:
		start = x / i;
		for j in range(i):
			print(int(j + start), end=' ')
			isFind = True
			break;
	if not isFind:
		print(-1)