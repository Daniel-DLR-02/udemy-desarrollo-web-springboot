package com.udemy.springninja.service.Impl;

import com.udemy.springninja.entity.UserRole;
import com.udemy.springninja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.udemy.springninja.entity.User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
        return buidlUser(user,authorities);

    }

    private User buidlUser(com.udemy.springninja.entity.User user, List<GrantedAuthority> authorities){

        return new User(user.getUsername(),user.getPassword(),user.isEnabled(),true,true,true,authorities);

    }

    private List<GrantedAuthority> buildAuthorities (Set<UserRole> userRole){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for(UserRole role: userRole){
            auths.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }
}
