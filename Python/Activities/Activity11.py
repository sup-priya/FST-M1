fruit_shop = {
    "apple": 200,
    "banana": 55,
    "orange": 80,
    "peaches": 150
              }

my_fruit = input("Which fruit are you looking for? ").lower()

if my_fruit == "apple":
    x = str(fruit_shop.get("apple"))
elif my_fruit == "banana":
    x = str(fruit_shop.get("banana"))
elif my_fruit == "orange":
    x = str(fruit_shop.get("orange"))
else:
    x = str(fruit_shop.get("peaches"))

if(my_fruit in fruit_shop):
    print("This fruit is available" + " and costs Rs." + x)
else:
    print("This fruit is not available")