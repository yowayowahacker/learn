import random

i = 0
while i < 8:
	a = 0
	n = random.randint(48,122)

	if n >= 58 and n <= 64 or n >= 91 and n <= 96:
		a = 1
	elif a == 0:
		print(chr(n),end="")
		i += 1

print()
