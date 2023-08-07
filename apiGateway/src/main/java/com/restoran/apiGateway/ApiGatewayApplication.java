package com.restoran.apiGateway;



import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@CrossOrigin(origins = "http://localhost:9191",methods= {RequestMethod.GET,RequestMethod.POST})

@SpringBootApplication
@EnableDiscoveryClient

public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	
	
	  @Bean public HttpClient httpClient() { return
	  HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE); }
	  
	  @Bean
	    CorsConfigurationSource corsConfigurationSource()
	    {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        //or any domain that you want to restrict to 
	        configuration.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept","Authorization"));
	   configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	        //Add the method support as you like 
	        UrlBasedCorsConfigurationSource source = new     UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	 
}
