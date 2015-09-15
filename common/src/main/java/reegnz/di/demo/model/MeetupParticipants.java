package reegnz.di.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MeetupParticipants {
	
	public abstract List<RSVP> getResults();

	@JsonCreator
	public static MeetupParticipants create(List<RSVP> results) {
		return new AutoValue_MeetupParticipants(results);
	}
}
