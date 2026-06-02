age = 28
price = 19.99
name = "Alice"
is_active = True
result = None

print("Variable Exploration:")
print(f"{f'age = {age}':<24} (type: {type(age).__name__})")
print(f"{f'price = {price}':<24} (type: {type(price).__name__})")
print(f"{f'name = {name}':<24} (type: {type(name).__name__})")
print(f"{f'is_active = {is_active}':<24} (type: {type(is_active).__name__})")
print(f"{f'result = {result}':<24} (type: {type(result).__name__})")
print("\n")

a = [1, 2, 3]
b = [1, 2, 3]
print("Operators Demo:")
print(f"{f'17 // 5 = {17 // 5}':<24} (floor division)")
print(f"{f'17 / 5 = {17 / 5}':<24} (true_division)")
print(f'"QA " * 3 = {"QA " * 3}')
print(f"True + True = {True + True}")
print(a == b)
print(a is b)
print("\n")

print("Precision Gotcha:")
print(f"0.1 + 0.2 = {0.1 + 0.2} (not exactly 0.3!)")