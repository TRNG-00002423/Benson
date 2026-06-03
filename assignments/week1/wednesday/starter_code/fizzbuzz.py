def fizzbuzz(n):
    for i in range(1, n + 1):
        if i % 3 == 0 and i % 5 == 0 and i % 7 == 0:
            print("FizzBuzzBoom")
        elif i % 3 == 0 and i % 5 == 0:
            print("FizzBuzz")
        elif i % 3 == 0 and i % 7 == 0:
            print("FizzBoom")
        elif i % 5 == 0 and i % 7 == 0:
            print("BuzzBoom")
        elif i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("Buzz")
        elif i % 7 == 0:
            print("Boom")
        else:
            print(i)

fizzbuzz(105)
