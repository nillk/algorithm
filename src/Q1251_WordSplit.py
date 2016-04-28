word = input()
wordList = [word[i::-1] + word[j:i:-1] + word[:j:-1] for i in range(0, len(word) - 2) for j in range(i + 1, len(word) - 1)]
print (min(wordList))