package com.example.sb_ecommerce.Service;

import com.example.sb_ecommerce.Api.Model.RegistrationBody;
import com.example.sb_ecommerce.Exception.UserAlreadyExists;
import com.example.sb_ecommerce.Model.DAO.UserDAO;
import com.example.sb_ecommerce.Model.LocalUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExists {
        if( userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent() ) {
            throw new UserAlreadyExists();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        // TODO: Encrypt password
        user.setPassword(registrationBody.getPassword());
        return userDAO.save(user);
    }
}
