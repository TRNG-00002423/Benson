import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)  // Enables Mockito annotations
class UserServiceTest {
    
    @Mock
    private UserRepository repository;  // Mock the dependency
    
    @Mock
    private EmailClient emailClient;  // Mock the dependency
    
    @InjectMocks
    private UserService userService;  // Inject mocks automatically

    @Test
    void getUser_existingUser_returnsUser() throws UserNotFoundException{
        User user = new User(1L, "Shuyan", "Shuyan@gmail.com", true);

        when(repository.findById(1L)).thenReturn(Optional.of(user));

        User retrievedUser = userService.getUser(1L);

        assertEquals("Shuyan", retrievedUser.getName());
        assertEquals("Shuyan@gmail.com", retrievedUser.getEmail());
        assertTrue(retrievedUser.isActive());
    }

    @Test
    void getUser_nonExistentUser_throwsException() {
        // Arrange: Mock returns empty Optional
        when(repository.findById(999L)).thenReturn(Optional.empty());
        
        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> {
            userService.getUser(999L);
        });
    }

    @Test
    void createUser_validUser_success() throws DuplicateUserException{
        User user = new User(2L, "Benson", "benson@gmail.com", true);

        when(repository.existsByEmail("benson@gmail.com")).thenReturn(false);
        when(repository.save(user)).thenReturn(user);

        assertFalse(userService.existsByEmail("benson@gmail.com"));
        assertEquals(user.getId(), userService.createUser(user).getId());
    }

    @Test
    void createUser_duplicateUser_throwsDuplicateUserException() throws DuplicateUserException, IllegalArgumentException{
        User user = new User(2L, "Benson", "benson@gmail.com", true);

        when(repository.existsByEmail("benson@gmail.com")).thenReturn(true);

        assertThrows(DuplicateUserException.class, ()->{
            userService.createUser(user);
        });
    }

    @Test
    void createUser_illegalName_throwsIllegalArguementException() throws DuplicateUserException, IllegalArgumentException{
        User user = new User(2L, null, "benson@gmail.com", true);

        assertThrows(IllegalArgumentException.class, ()->{
            userService.createUser(user);
        });
    }

    @Test
    void createUser_illegalEmail_throwsIllegalArguementException() throws DuplicateUserException, IllegalArgumentException{
        User user = new User(2L, "Ben", "bensongmail.com", true);
        
        assertThrows(IllegalArgumentException.class, ()->{
            userService.createUser(user);
        });
    }
}