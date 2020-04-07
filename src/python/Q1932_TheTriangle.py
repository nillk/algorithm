n = int(input())
DP = [0] * (n + 1)
for i in range(n):
	for j, num in enumerate(list(map(int, input().split()))[::-1]):
		DP[i - j + 1] = max(DP[i - j + 1], DP[i - j]) + num

print (max(DP))