package fr.caensup.sio.calc.models;

public class Addition extends Operation {
	@Override
	public String toString() {
		String result = lMember + "+";
		if (rMember != null) {
			return result += rMember;
		}
		return result;
	}
}
