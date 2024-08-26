package com.Practice.PracticeProject2.Service;

import com.Practice.PracticeProject2.Model.User;
import com.Practice.PracticeProject2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * The purpose of this class CustomUserDetailsService is to provide database methods to load CustomUserDetails
 */
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    /**
     * The field userRepository is @Autowired, so it does not need to be passed as a parameter. It is also a reference
     * to use repository methods
     */

    private  UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * The purpose of this method loadUserByUsername(String username) is to find a user in the Database. It returns a
     * UserDetails which is actually a User. If UsernameNotFoundException is thrown then this application will redirect to
     * error.html where it will display the message "Bad Credentials" and then redirect to index.html
     *
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */

    User user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        user = userRepository.findByUsername(username);
        if (user == null)
        {
            System.out.println("Username or Password not found!");
            throw new UsernameNotFoundException("Username or Password not found!");
        }
        System.out.println("User Details: " + user.getUsername() + " " + user.getPassword() + " " + user.getRole());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication Object: " + authentication.getAuthorities());

        return new CustomUserDetails(user);
    }



}
