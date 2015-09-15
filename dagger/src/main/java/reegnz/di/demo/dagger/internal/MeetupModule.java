package reegnz.di.demo.dagger.internal;

import javax.inject.Named;

import com.fasterxml.jackson.databind.ObjectMapper;

import dagger.Module;
import dagger.Provides;
import reegnz.di.demo.api.MeetupApp;
import reegnz.di.demo.api.MeetupService;
import reegnz.di.demo.misc.ApiKeyInterceptor;
import reegnz.di.demo.misc.MeetupAppImpl;
import reegnz.di.demo.misc.ObjectMapperConfigurer;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.JacksonConverter;

@Module
public class MeetupModule {

	@Provides
	public MeetupApp meetupApp(MeetupAppImpl meetupApp) {
		return meetupApp;
	}

	@Provides
	public MeetupService service(RestAdapter adapter) {
		return adapter.create(MeetupService.class);
	}

	@Provides
	public RestAdapter prepareRestAdapter(@Named("endpoint") String endpoint, RequestInterceptor interceptor,
			Converter converter) {
		return new RestAdapter.Builder().setEndpoint(endpoint).setRequestInterceptor(interceptor)
				.setConverter(converter).build();
	}

	@Provides
	@Named("endpoint")
	public String endpoint() {
		return "https://api.meetup.com";
	}

	@Provides
	public RequestInterceptor interceptor(ApiKeyInterceptor interceptor) {
		return interceptor;
	}

	@Provides
	public ObjectMapper objectMapper(ObjectMapperConfigurer configurer) {
		return configurer.configure();
	}

	@Provides
	public Converter converter(ObjectMapper mapper) {
		return new JacksonConverter(mapper);
	}
}
