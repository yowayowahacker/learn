word = input('文字列を入力してください：')
wordlen = len(word)

i = 0
while i < wordlen:
	word_ord = ord(word[i])

	word_ord += 13
	
	if word_ord <= 60 or word_ord >= 71 and word_ord <= 77 or word_ord >= 104  and word_ord <= 109 or word_ord >= 136:
		word_ord -= 13

	elif word_ord >= 61 and word_ord <= 70:
		word_ord -= 10
		if word_ord >= 58 and word_ord <= 60:
			word_ord -= 10

	elif word_ord >= 91 and word_ord <= 103 or word_ord >= 123:
		word_ord -= 26

	print(chr(word_ord),end="")
	i += 1

print()
