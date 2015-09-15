package reegnz.di.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MemberPhoto {
	
	public abstract String photoLink();
	
	@JsonCreator
	public static MemberPhoto create(String photoLink) {
		return new AutoValue_MemberPhoto(photoLink);
	}
}
