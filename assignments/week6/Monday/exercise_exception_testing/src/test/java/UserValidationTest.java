import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidationTest {
    private final UserValidation userValidation = new UserValidation();
    @Test
    void validateEmail_nullEmail_shouldThrowsIllegalArgumentException(){
        var e = assertThrows(IllegalArgumentException.class, () -> {
            userValidation.validateEmail(null);
        });

        assertEquals(e.getMessage(), "Email cannot be null");
    }

    @Test
    void validateEmail_emptyEmail_shouldThrowsIllegalArgumentException(){
        var e = assertThrows(IllegalArgumentException.class, () -> {
            userValidation.validateEmail("");
        });

        assertEquals(e.getMessage(), "Email cannot be empty");
    }

    @Test
    void validateEmail_noAtSign_shouldThrowsIllegalArgumentException(){
        var e = assertThrows(IllegalArgumentException.class, () -> {
            userValidation.validateEmail("gmail");
        });

        assertEquals(e.getMessage(), "Email must contain @");
    }

    @Test
    void validateEmail_atNoDomain_shouldThrowsIllegalArgumentException(){
        var e = assertThrows(IllegalArgumentException.class, () -> {
            userValidation.validateEmail("@domain");
        });

        assertEquals(e.getMessage(), "Email has invalid format");
    }
    
    @Test 
    void validatePassword_null_shouldThrowValidationException(){
        var e = assertThrows(ValidationException.class, () -> {
            userValidation.validatePassword(null);
        });

        assertEquals(e.getMessage(), "Password cannot be null");
    }

    @Test 
    void validatePassword_shortPassword_shouldThrowValidationException(){
        var e = assertThrows(ValidationException.class, () -> {
            userValidation.validatePassword("1");
        });

        assertEquals(e.getMessage(), "Password must be at least 8 characters");
    }

    @Test 
    void validatePassword_noUpperCaseLetter_shouldThrowValidationException(){
        var e = assertThrows(ValidationException.class, () -> {
            userValidation.validatePassword("password");
        });

        assertEquals(e.getMessage(), "Password must contain an uppercase letter");
    }

    @Test 
    void validatePassword_noLowerCaseLetter_shouldThrowValidationException(){
        var e = assertThrows(ValidationException.class, () -> {
            userValidation.validatePassword("PASSWORD");
        });

        assertEquals(e.getMessage(), "Password must contain a lowercase letter");
    }

    @Test
    void validateAge_negativeAge_shouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            userValidation.validateAge(-1);
        });
    }

    @Test
    void validateAge_ageOver150_shouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            userValidation.validateAge(151);
        });
    }

    @Test
    void validateAge_ageBetween0To150_shouldNotThrowIllegalArgumentException(){
        assertDoesNotThrow(() -> {
            userValidation.validateAge(55);
        });
    }

    @Test 
    void validateAge_multipleInvalidInputs_allThrowsException(){
        assertAll("Invalid age input throws exceptions", 
            () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                    userValidation.validateAge(-1);
                });
            },
            () -> {
                assertThrows(IllegalArgumentException.class, () -> {
                    userValidation.validateAge(151);
                });
            }
        );
    }
}
