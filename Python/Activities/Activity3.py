# Enter player names
player1 = input("Enter Player1 name:")
player2 = input("Enter Player2 name:")

# Enter player choices
player1_answer = input(player1 + ", What do you choose - rock, paper or scissors? ").lower()
player2_answer = input(player2 + ", What do you choose - rock, paper or scissors? ").lower()

# Checking who is the winner
if player1_answer == player2_answer:
    print("It is a tie")
elif player1_answer == 'rock':
    if player2_answer == 'scissors':
        print("player1 wins")
    else:
        print("player2 wins")
elif player1_answer == 'scissors':
    if player2_answer == 'paper':
        print("player1 wins")
    else:
        print("player2 wins")
elif player1_answer == 'paper':
    if player2_answer == 'rock':
        print("player1 wins")
    else:
        print("player2 wins")
else:
    print("Invalid input - You did not enter either rock, paper or scissors")