import java.util.Optional;

public class UserService {
    private final UserRepository repository;
    private final EmailClient emailClient;

    public UserService(UserRepository repository, EmailClient emailClient) {
        this.repository = repository;
        this.emailClient = emailClient;
    }

    public User getUser(long id) throws UserNotFoundException{
        Optional<User> optionalUser = repository.findById(id);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException();
        }

        User user = optionalUser.get();

        return user;
    }

    public User createUser(User user) throws DuplicateUserException, IllegalArgumentException{
        if(user.getName() == null || !user.getEmail().contains("@")){
            throw new IllegalArgumentException();
        }
        if(repository.existsByEmail(user.getEmail())){
            throw new DuplicateUserException();
        }
        return repository.save(user);
    }

    public boolean existsByEmail(String email){
        return repository.existsByEmail(email);
    } 
}

class UserNotFoundException extends Exception{

}

class DuplicateUserException extends Exception{

}