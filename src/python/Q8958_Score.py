for i in range(int(input())):
	str = input().split('X')
	score = 0
	for s in str:
		n = len(s)
		score += (n**2 + n)//2
	print (score)
