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
print(*pw ,end="\n", file = codecs.open('autopass.txt', 'a', 'utf-8'))
