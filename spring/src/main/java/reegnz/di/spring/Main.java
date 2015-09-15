package reegnz.di.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.common.base.Stopwatch;

import reegnz.di.demo.api.MeetupApp;

public class Main {
    public static void main( String[] args ) {
    	Stopwatch sw = Stopwatch.createStarted();
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MeetupConfiguration.class);
    	MeetupApp app = ctx.getBean(MeetupApp.class);
    	System.out.println("Setup time: "+ sw);
    	app.printMeetupParticipants(Integer.parseInt(args[0]));
    	System.out.println("Total time: "+ sw);
    	ctx.close();
    }
}
