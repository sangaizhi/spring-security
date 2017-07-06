package org.sangaizhi.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring security 注解配置
 *
 * @author sangaizhi
 * @date 2017/7/6
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置认证管理器，并添加内存用户信息
     *
     * @param auth 通过 @Autowired 注解注入
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 暂时使用基于内存的AuthenticationProvider
        auth.inMemoryAuthentication().withUser("sangaizhi").password("sangaizhi").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    /**
     * 配置登录页、凭证参数、面膜参数和登出请求，并且禁用了 csrf
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin().loginPage("/loginPage").failureUrl("/loginPage?error").successForwardUrl("/").loginProcessingUrl("/login.action")
                .usernameParameter("username").passwordParameter("password")
                .and().logout().logoutSuccessUrl("/loginPage?logout");
    }
}
