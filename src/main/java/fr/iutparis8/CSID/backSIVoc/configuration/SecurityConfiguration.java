package fr.iutparis8.CSID.backSIVoc.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import fr.iutparis8.CSID.backSIVoc.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, proxyTargetClass = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static DataSource dataSource;

	@Autowired
	UserService userService;

	public SecurityConfiguration(DataSource dataSource) {
		SecurityConfiguration.dataSource = dataSource;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().disable().authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/connexion").permitAll()
				.antMatchers("/connexion/creation").permitAll()
				.antMatchers("/users/*").permitAll()
				.antMatchers("/users").permitAll()
				.antMatchers("/events").permitAll()
				.antMatchers("/events/*").permitAll()
				.antMatchers("/events/*/*").permitAll()
				.antMatchers("/articles").permitAll()
				.antMatchers("/articles/*").permitAll()
				.anyRequest().authenticated()

				.and().csrf().disable();

		http.httpBasic();

		http.headers().frameOptions().sameOrigin();
		http.httpBasic();
		http.headers().frameOptions().sameOrigin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Bean
	public static JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
		userDetailsService.setDataSource(getDataSource());
		return userDetailsService;
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}
