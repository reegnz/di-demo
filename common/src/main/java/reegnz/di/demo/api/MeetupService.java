package reegnz.di.demo.api;

import reegnz.di.demo.model.MeetupParticipants;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MeetupService {

	@GET("/2/rsvps?rsvp=yes")
	MeetupParticipants getParticipants(@Query("event_id") int eventId);
}
