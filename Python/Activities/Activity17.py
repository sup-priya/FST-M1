# Import pandas
import pandas

# Create a Dictionary that will hold data
data = {
  "Usernames": ["admin", "John", "Ronald"],
  "Passwords": ["password", "Ben", "Stone"]
}

# Create DataFrame using that data
dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

dataframe.to_csv("pandas.csv", index=False)