package reegnz.di.spring;

import javax.inject.Named;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import reegnz.di.demo.api.MeetupApp;
import reegnz.di.demo.api.MeetupService;
import reegnz.di.demo.misc.ApiKeyInterceptor;
import reegnz.di.demo.misc.MeetupAppImpl;
import reegnz.di.demo.misc.ObjectMapperConfigurer;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.JacksonConverter;

@Configuration
public class MeetupConfiguration {
	
	@Bean
	public MeetupApp app(MeetupService service) {
		return new MeetupAppImpl(service);
	}	
	
	@Bean
	public MeetupService service(RestAdapter adapter) {
		return adapter.create(MeetupService.class);
	}
	
	@Bean
	public RestAdapter prepareRestAdapter(@Named("endpoint") String endpoint, RequestInterceptor interceptor,
			Converter converter) {
		return new RestAdapter.Builder().setEndpoint(endpoint).setRequestInterceptor(interceptor)
				.setConverter(converter).build();
	}

	@Bean
	@Named("endpoint")
	public String endpoint() {
		return "https://api.meetup.com";
	}
	
	@Bean
	public ApiKeyInterceptor apiKeyInterceptor() {
		return new ApiKeyInterceptor();
	}

	@Bean
	public RequestInterceptor interceptor(ApiKeyInterceptor interceptor) {
		return interceptor;
	}
	
	@Bean
	public ObjectMapperConfigurer configurer() {
		return new ObjectMapperConfigurer();
	}

	@Bean
	public ObjectMapper objectMapper(ObjectMapperConfigurer configurer) {
		return configurer.configure();
	}

	@Bean
	public Converter converter(ObjectMapper mapper) {
		return new JacksonConverter(mapper);
	}
}
