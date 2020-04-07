ships = []
for i in range(0, int(input())):
	day = int(input()) - 1
	if (day and all(day % term for term in ships)):ships.append(day)

print (len(ships))