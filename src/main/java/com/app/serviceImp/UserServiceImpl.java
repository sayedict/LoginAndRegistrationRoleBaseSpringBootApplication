package com.app.serviceImp;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;	
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.model.Role;
import com.app.model.Users;
import com.app.service.UserService;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Users save(Users registration){
        Users user = new Users();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
       // user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
       // user.setRoles(Arrays.asList(new Role("ROLE_STUDENT")));
       user.setRoles(Arrays.asList(new Role("ROLE_PROFESSOR")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
       
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
