package com.Practice.PracticeProject2.Service;

import com.Practice.PracticeProject2.DTO.UserDTO;
import com.Practice.PracticeProject2.Model.User;
import com.Practice.PracticeProject2.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The purpose of this class UserServiceImpl is to provide concrete methods for the interface UserService.
 */
@Service
public class UserServiceImpl implements UserService
{
    /**
     * This field passwordEncoder is needed to reference a password encoder in order to use the password for
     * userDTO.getPassword()
     */
    private PasswordEncoder passwordEncoder;

    /**
     * This field  userRepository is needed to reference userRepository methods
     */
    private UserRepository userRepository;


    /**
     * The purpose of this constructor is to make use of userRepository in order to call its methods
     * @param userRepository
     */
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    /**
     * The purpose of this method is to find a user by username inside the database
     * @param username
     * @return User
     */
    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    /**
     * The purpose of this method save is to store or insert a new user inside the database
     * @param userDTO
     * @return
     */
    @Override
    public User save(UserDTO userDTO)
    {
        User user = new User(userDTO.getRole(), userDTO.isEnabled(), userDTO.getUsername(), userDTO.getJobtitle(),
                userDTO.getFirstname(), userDTO.getLastname(), userDTO.getPhone(), userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()), userDTO.getDatehired(), userDTO.getDatefired());
        return userRepository.save(user);
    }
}
