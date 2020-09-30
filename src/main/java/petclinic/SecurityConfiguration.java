package petclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                /* open sources path's for any user*/
                .antMatchers("/**/favicon.ico",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "webjars/**",
                        "/login.html").permitAll()
                /* Request methods are accessed by just authenticated users*/
                .anyRequest().authenticated();

        /* unauthenticated users redirect login page by default*/
        http.formLogin()
            .loginPage("/login.html") //login path
            .loginProcessingUrl("/login") //submit uri
            .failureForwardUrl("/login.html?loginFailed=true"); //authentication failure
        http.rememberMe().userDetailsService(userDetailsService); //remember be ability
    }
}
