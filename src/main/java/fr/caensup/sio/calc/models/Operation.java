package fr.caensup.sio.calc.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operation {
	protected Double lMember;
	protected Double rMember;

	public void addToLMember(String number) {
		lMember = Double.valueOf(lMember.intValue() + number);
	}

	public void addToRMember(String number) {
		rMember = Double.valueOf(rMember.intValue() + number);
	}

	@Override
	public String toString() {
		return lMember + "...";
	}

}
