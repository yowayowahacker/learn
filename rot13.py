word = input('文字列を入力してください：')
wordlen = len(word)

i = 0
while i < wordlen:
	word_ord = ord(word[i])

	if word_ord >= 65 and word_ord <= 90:
		word_ord += 13

		if word_ord >= 91:
			word_ord -= 26
	elif word_ord >= 97 and word_ord <= 122:
		word_ord += 13
		if word_ord >= 123:
			word_ord -= 26

	print(chr(word_ord),end="")
	i += 1

print()
