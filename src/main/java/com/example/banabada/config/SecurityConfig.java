package com.example.banabada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encoder() {
        // DB 패스워드 암호화
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//      super.configure(http); // 이 코드 삭제하면 기존 시큐리티가 가진 모든 기능 비활성화
        http.csrf().disable(); // csrf 토큰 비활성화 코드

        http.authorizeRequests()

                .antMatchers("/banabada/auth/**", "/banabada/mypage/**", "/banabada/orders/**").authenticated() // 이 주소로 시작되면 인증이 필요
                //.antMatchers(HttpMethod.POST,".spittles").authenticated()
                .anyRequest().permitAll(); // 그게 아닌 모든 주소는 인증 필요 없음

        // 로그인
        http.formLogin() // form 로그인 인증 기능이 작동함
                .loginPage("/auth/login") // 사용자 정의 로그인 페이지, default: /login
                .defaultSuccessUrl("/") // 로그인 성공 후 이동 페이지
                .failureUrl("/auth/login") // 로그인 실패 후 이동 페이지
                .usernameParameter("memberEmail") // 아이디 파라미터명 설정, default: username
                .passwordParameter("memberPasswd") // 패스워드 파라미터명 설정, default: password
                .loginProcessingUrl("/auth/login") // 로그인 Form Action Url, default: /login
                .successHandler( // 로그인 성공 후 핸들러
                        new AuthenticationSuccessHandler() { // 익명 객체 사용
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, IOException {
                                System.out.println("authentication: " + authentication.getName());
                                response.sendRedirect("/");
                            }
                        })
                .failureHandler( // 로그인 실패 후 핸들러
                        new AuthenticationFailureHandler() { // 익명 객체 사용
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                                System.out.println("exception: " + exception.getMessage());
                                response.sendRedirect("/auth/login");
                            }
                        });


                /*
                .and()
                .formLogin()
                .loginPage("/login") // 인증필요한 주소로 접속하면 이 주소로 이동시킴    # 로그인 html 페이지로 이름 바꿀 것
                .loginProcessingUrl("/login") // 스프링 시큐리티가 로그인 자동 진행 POST방식으로 로그인 진행
                .defaultSuccessUrl("/"); // 로그인이 정상적이면 "/" 로 이동

                 */

        // 로그아웃
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                .logoutSuccessUrl("/auth/login")
                .invalidateHttpSession(true);
    }
}