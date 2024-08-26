package com.Practice.PracticeProject2.Repositories;

import com.Practice.PracticeProject2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The purpose of this class is to interact with the PostGres Database
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    /**
     * The purpose of this method is to find users/employees in the Database based on username. It will return a User.
     * It is called by CustomUserDetailsService and UserServiceImpl
     * @return User
     */
    User findByUsername(String username);
}
