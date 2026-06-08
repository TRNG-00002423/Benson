import random

def guessing_game():
    answer = random.randint(1, 100)
    i = 0

    while i < 7:
        guess = int(input("Take a guess: "))
        if guess == answer:
            print("You win!")
            return
        if guess > answer:
            print("Too high!")
        else:
            print("Too low!")
        i += 1

    print(f"Game over! The answer was {answer}")

guessing_game()