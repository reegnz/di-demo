package reegnz.di.demo.model;

import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RSVP {

	public abstract Member getMember();
	
	public abstract int getGuests();
	
	@Nullable
	public abstract MemberPhoto getMemberPhoto();

	@JsonCreator
	public static RSVP create(Member member, int guests, MemberPhoto memberPhoto) {
		return new AutoValue_RSVP(member, guests, memberPhoto);
	}

}
