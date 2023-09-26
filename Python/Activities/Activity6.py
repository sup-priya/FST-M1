for i in range(10):
    print(str(i) * i)

rows = 8
#Reverse loop
for i in range(rows, 0, -1):
    num = i
    for j in range(0, i):
        print(num, end='')
    print("\r")