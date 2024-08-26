package com.Practice.PracticeProject2.Service;

import com.Practice.PracticeProject2.DTO.UserDTO;
import com.Practice.PracticeProject2.Model.User;

/**
 * The purpose of this interface UserService is to serve as a placeholder so later explicit methods can be used in the
 * UserserviceImpl class
 */
public interface UserService
{
    User findByUsername(String username);
    User save (UserDTO userdto);
}
