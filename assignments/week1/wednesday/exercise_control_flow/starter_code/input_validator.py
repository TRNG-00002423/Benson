def validate_password(password):
    errors = []
    has_digit = False
    has_special_char = False

    if len(password) < 8:
        errors.append("Password must be at least 8 characters long")
    if password.lower() == password:
        errors.append("Password must contain at least one uppercase letter")
    if password.upper() == password:
        errors.append("Password must contain at least one lowercase letter")
    
    for char in password:
        if char.isdigit():
            has_digit = True
        if not char.isalnum():
            has_special_char = True
    
    if not has_digit:
        errors.append("Password must contain at least one digit")
    if not has_special_char:
        errors.append("Password must contains at least one special character")

    return {
        "valid": True if not errors else False,
        "errors": errors
    }

print(validate_password("Abc123!x"))    # valid
print(validate_password("abc"))         # too short, no upper, no digit, no special
print(validate_password("ABCDEFGH"))    # no lower, no digit, no special
print(validate_password("ABCDefgh1!"))  # valid
                                        

