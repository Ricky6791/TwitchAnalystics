@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/login**", "/error**").permitAll()
				.anyRequest().authenticated()
			.and()
			.oauth2Login();
                .loginPage("/login") // customize login page url
                .defaultSuccessURL("/dashboard") // redirect after sucess
                .failureUrl("/login?error=true") // redirect after failure
            .and()
            .logout()
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            .and()
            .exceptionHandling()
                .accessDeniedPage("/403"); // custom page for access denied
        http.csrf().disable();
	}

    @Override
    protected void configure(AuthenticatedManagerBuilder auth) throws Exception {
        // configure authentication provider if needed
    }
}