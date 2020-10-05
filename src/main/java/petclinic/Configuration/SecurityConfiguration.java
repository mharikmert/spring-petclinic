package petclinic.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration  extends AbstractSecurityConfiguration {

    private UserDetailsService userDetailsService;


    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
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
                /* pages authentication according to user roles*/
                .antMatchers("/actuator/**").access("hasRole('ADMIN')")
                /* Request methods are accessed by just authenticated users*/
                .anyRequest().authenticated();

        /* unauthenticated users redirect login page by default*/
        http.formLogin()
            .loginPage("/login.html") //login path
            .loginProcessingUrl("/login") //submit uri
            .failureForwardUrl("/login.html?loginFailed=true"); //authentication failure
        http.rememberMe().userDetailsService(userDetailsService); //remember be ability
//        http.httpBasic(); // enabling basic authentication
    }
}
