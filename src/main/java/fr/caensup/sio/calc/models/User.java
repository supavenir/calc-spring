package fr.caensup.sio.calc.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "firstname", "lastname" })
public class User {

	private String firstname;
	private String lastname;
	private int age;
}
