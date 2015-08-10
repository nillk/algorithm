A = ord('a')
for i in range(int(input())):
	alphabet = [0] * 26
	for c in input(): alphabet[ord(c) - A] += 1
	for c in input(): alphabet[ord(c) - A] -= 1
	print("Case #{0}: {1}".format(i + 1, sum(map(abs, alphabet))))