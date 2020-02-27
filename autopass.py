import random
import codecs

m = input("パスワードの桁数を入力 ：　")

pw = ['']

i = 0
if m == "" or int(m) == 8:
	while i < 8:
		n = random.randint(48,122)

		if n >= 48 and n <= 58 or n >= 65 and n <= 90 or n >= 97 and n <= 122:
			print(chr(n),end="")
			pw.append(chr(n))
			i += 1
else:
	while i < m:
		n = random.randint(48,122)
		
		if n >= 48 and n <= 58 or n >= 65 and n <= 90 or n >= 97 and n <= 122:
			print(chr(n),end="")
			pw.append(chr(n))
			i += 1

print()
use = input("用途/アカウント名を入力 ; ")
print(*use ,end="/ ",file = codecs.open('autopass.txt' , 'a' , 'utf-8'))

wordlen = len(pw)
i = 0
while i < wordlen:
	word_ord = ord(pw[i])

	if word_ord >= 65 and word_ord <= 90:
		word_ord += 13

		if word_ord >= 91:
			word_ord -= 26
	elif word_ord >= 97 and word_ord <= 122:
		word_ord += 13
		if word_ord >= 123:
			word_ord -= 26

	print(*chr(word_ord) ,end="",file = codecs.open('autopass.txt' , 'a' , 'utf-8'))
	i += 1
	
print(*"\n" ,end="",file = codecs.open('autopass.txt' , 'a' , 'utf-8'))
