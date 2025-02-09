package com.practice.ecommerce.Service;

import com.practice.ecommerce.Model.PrincipalUser;
import com.practice.ecommerce.Model.User;
import com.practice.ecommerce.Repository.GetProductList;
import com.practice.ecommerce.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);

        if(user == null)
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("User found");
        System.out.println(username);
        System.out.println("User: " + user.getUsername() + ", Password: " + user.getPassword());
        return new PrincipalUser(user);
    }
}
