package no.hvl.dat250.Votesphere.securingWeb;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		//...
		.antMatchers(
			HttpMethod.GET,
			"/index*", "/static/**", "/*.js", "/*.json", "/*.ico")
			.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/index.html")
		.loginProcessingUrl("/perform_login")
		.defaultSuccessUrl("/homepage.html",true)
		.failureUrl("/index.html?error=true");
		//...
    }
		/*
		http
		.authorizeRequests()
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/#/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();*/



	
		/*
			
	.csrf().disable()   
        .authorizeRequests()
        .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
            //.formLogin().and()
            .httpBasic();
    }

*/
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
