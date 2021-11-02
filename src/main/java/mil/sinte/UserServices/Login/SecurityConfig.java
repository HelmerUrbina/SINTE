package mil.sinte.UserServices.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin().loginPage("/login")//.defaultSuccessUrl("/Login/Principal", true).failureUrl("/login?error=true")
                // .loginProcessingUrl("/login post").permitAll()
                .and()
                //  .logout().logoutUrl("logout").logoutSuccessUrl("logout");
                .exceptionHandling().accessDeniedPage("/errores/403");*/
        http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin().loginPage("/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/errores/403");

    }

}
