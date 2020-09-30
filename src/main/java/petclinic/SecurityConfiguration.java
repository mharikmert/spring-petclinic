package petclinic;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                /* open sources path's for any user*/
//                .antMatchers("/**/favicon.ico",
//                        "/css/**",
//                        "/js/**",
//                        "/images/**",
//                        "webjars/**").permitAll()
                /* Request methods are accessed by just authenticated users*/
                .anyRequest().authenticated();

        /* unauthenticated users redirects login page by default*/
        http.formLogin();
    }
}
