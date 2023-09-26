#Enter a number
userinput = int(input("Enter a number:"))
mod = userinput % 2
if mod > 0:
    x ="Entered number is an odd number: {}"
    print(x.format(userinput))
else:
    y ="Entered number is a even number: {}"
    print(y.format(userinput))