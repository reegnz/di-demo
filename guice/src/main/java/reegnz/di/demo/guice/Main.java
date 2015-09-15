package reegnz.di.demo.guice;

import com.google.common.base.Stopwatch;
import com.google.inject.Guice;
import com.google.inject.Injector;

import reegnz.di.demo.api.MeetupApp;

public class Main {
	public static void main(String[] args) {
		Stopwatch sw = Stopwatch.createStarted();
		Injector injector = Guice.createInjector(new MeetupModule());
		MeetupApp app = injector.getInstance(MeetupApp.class);
		System.out.println("Setup time: "+ sw);
		app.printMeetupParticipants(Integer.parseInt(args[0]));
		System.out.println("Total time: "+ sw);
	}
}
