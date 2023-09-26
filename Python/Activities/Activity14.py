my_num = int(input("Enter a number: "))

def fibonacci(numb):
    if numb <= 1:
        return numb
    else:
        return(fibonacci(numb-1) + fibonacci(numb-2))

if my_num <= 0:
    print("Oops! enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(my_num):
        print(fibonacci(i))