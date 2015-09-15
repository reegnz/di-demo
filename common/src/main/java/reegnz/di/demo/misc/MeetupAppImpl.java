package reegnz.di.demo.misc;

import static java.util.stream.Collectors.summingInt;

import java.util.Comparator;

import javax.inject.Inject;

import reegnz.di.demo.api.MeetupApp;
import reegnz.di.demo.api.MeetupService;
import reegnz.di.demo.model.MeetupParticipants;
import reegnz.di.demo.model.RSVP;

public class MeetupAppImpl implements MeetupApp {

	private final MeetupService service;

	@Inject
	public MeetupAppImpl(MeetupService service) {
		this.service = service;
	}

	@Override
	public void printMeetupParticipants(int eventId) {
		MeetupParticipants participants = service.getParticipants(eventId);
		Comparator<RSVP> cmp = (rsvp1, rsvp2) -> rsvp1.getMember().getName().compareTo(rsvp2.getMember().getName());
		participants.getResults().stream().sorted(cmp).forEach(this::printNameAndRsvp);
		Integer numGuests = participants.getResults().stream().collect(summingInt(rsvp -> 1 + rsvp.getGuests()));
		System.out.println(numGuests);
	}

	private void printNameAndRsvp(RSVP rsvp) {
		System.out.print(rsvp.getMember().getName());
		if (rsvp.getGuests() > 0) {
			System.out.print(" + " + rsvp.getGuests());
		}
		System.out.println();
	}

}
