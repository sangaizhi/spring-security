package org.sangaizhi.security.service;

import org.sangaizhi.security.constants.State;
import org.sangaizhi.security.model.Profile;
import org.sangaizhi.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户身份验证管理
 * 采用数据中数据构建 Spring Security 中 User 对象
 * @author sangaizhi
 * @date 2017/7/10
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)

    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        User user = userService.findByUsername(ssoId);
        if (null == user) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Objects.equals(user.getState(), State.ACTIVE.getValue()),
                true,
                true,
                true,
                getGrantedAuthorities(user));
    }

    public List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Profile profile : user.getProfileSet()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+profile.getType()));
        }
        return authorities;
    }

}
