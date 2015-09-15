package reegnz.di.demo.dagger;

import dagger.Component;
import reegnz.di.demo.api.MeetupApp;
import reegnz.di.demo.dagger.internal.MeetupModule;

@Component(modules=MeetupModule.class)
public interface AppComponent {
	
	MeetupApp meetupApp();
}
