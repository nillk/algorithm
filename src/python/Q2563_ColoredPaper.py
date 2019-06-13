board = [[0] * 101 for i in range(101)]

for i in range(int(input())):
	left, bottom = map(int, input().split())
	for y in range(bottom, bottom + 10):
		for x in range(left, left + 10):
			board[x][y] = 1

print(sum(sum(board, [])))