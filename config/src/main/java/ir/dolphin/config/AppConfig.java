package ir.dolphin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "ir.dolphin.*" })
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean(name = "resourceBundle")
	public ResourceBundle resourceBoundle() {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
			return resourceBundle;
		} catch (MissingResourceException ex) {
			ex.getMessage();
			return null;
		}
	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
//	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		// <!-- the maximum file size in bytes = 10MB -->
		commonsMultipartResolver.setMaxUploadSize(10485760);
		return commonsMultipartResolver;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> jsonTypes = new ArrayList<MediaType>(jsonConverter.getSupportedMediaTypes());
		
		//APPLICATION_JSON_UTF8
		jsonTypes.add(MediaType.APPLICATION_JSON);
		jsonTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		jsonTypes.add(MediaType.MULTIPART_FORM_DATA);
		jsonTypes.add(MediaType.ALL);
		jsonConverter.setSupportedMediaTypes(jsonTypes);
		converters.add(jsonConverter);

		FormHttpMessageConverter converter = new FormHttpMessageConverter();
		MediaType mediaType = new MediaType("application", "x-www-form-urlencoded", Charset.forName("UTF-8"));
		converter.setSupportedMediaTypes(Arrays.asList(mediaType));
		converters.add(converter);

		super.configureMessageConverters(converters);
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".html");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
