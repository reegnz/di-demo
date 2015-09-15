package reegnz.di.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Member {
	
	public abstract String getName();
	
	@JsonCreator
	public static Member create(String name) {
		return new AutoValue_Member(name);
	}
	
}
