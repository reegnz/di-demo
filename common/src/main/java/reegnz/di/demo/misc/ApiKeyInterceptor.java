package reegnz.di.demo.misc;

import javax.inject.Inject;

import retrofit.RequestInterceptor;

public class ApiKeyInterceptor implements RequestInterceptor {
	
	@Inject
	public ApiKeyInterceptor() {
	}
	
	@Override
	public void intercept(RequestFacade request) {
		String apikey = System.getProperty("apikey");
		request.addQueryParam("key", apikey);
	}
}