package com.example.LibraryManagementSysrem.Util;

import com.example.LibraryManagementSysrem.Entities.User;
import com.example.LibraryManagementSysrem.Repositories.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByName(userName).orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username or email : " + userName));
        return new MyUserDetailImpl(user);
    }
}
