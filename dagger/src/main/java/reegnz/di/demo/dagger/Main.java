package reegnz.di.demo.dagger;

import com.google.common.base.Stopwatch;

import reegnz.di.demo.api.MeetupApp;

public class Main {
	public static void main(String[] args) {
		Stopwatch sw = Stopwatch.createStarted();
		AppComponent appComponent = DaggerAppComponent.create();
		MeetupApp app = appComponent.meetupApp();
		System.out.println("Setup time: "+ sw);
		app.printMeetupParticipants(Integer.parseInt(args[0]));
		System.out.println("Total time: "+ sw);
	}
}
