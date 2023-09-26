my_num = 10

#defining function to calculate sum
def calculateSum(numb):
  if numb:
    # Recursive function call
    return numb + calculateSum(numb-1)
  else:
    return 0

# Call function
result = calculateSum(my_num)

# Print result
print(result)