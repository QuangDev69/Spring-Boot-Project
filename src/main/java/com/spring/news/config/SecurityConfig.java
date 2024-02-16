package com.spring.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests(authorizeRequests -> authorizeRequests.requestMatchers("/auth/**", "/WEB-INF/**")
						.permitAll().anyRequest().authenticated())
				.formLogin(formLogin -> formLogin.loginPage("/auth/login") // Đặt trang login tùy chỉnh
						.defaultSuccessUrl("/users/listUser", true) // Điều hướng tới trang userList sau khi đăng nhập
																	// thành công
				).logout(logout -> logout.logoutUrl("/auth/logout") // URL để kích hoạt đăng xuất
						.logoutSuccessUrl("/auth/login?logout") // URL để chuyển hướng sau khi đăng xuất thành công
						.invalidateHttpSession(true) // Vô hiệu hóa session
						.deleteCookies("JSESSIONID") // Xóa cookie session
						.clearAuthentication(true) // Xóa thông tin xác thực
						.permitAll());
		return http.build();
	}

//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler() {
//        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
//        handler.setUseReferer(true);
//        handler.setDefaultTargetUrl("/users/listUser");
//        return handler;
//    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}