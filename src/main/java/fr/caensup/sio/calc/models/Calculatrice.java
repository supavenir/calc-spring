package fr.caensup.sio.calc.models;

import java.util.List;

import lombok.Getter;

@Getter
public class Calculatrice {
	private final String numbers = "789456123±0,";
	private final String operators = "÷×-+=";
	private List<Operation> operations;
	private Operation activeOperation;

	private OpStatus status = OpStatus.empty;

	public Calculatrice() {
		activeOperation = new Operation();
	}

	public Operation send(String value, boolean isNumber) {

		switch (status) {
			case empty -> {
				activeOperation = new Operation();
				activeOperation.setLMember(Double.parseDouble(value));
				status = OpStatus.member1;
			}
			case member1 -> {
				if (isNumber) {
					activeOperation.addToLMember(value);
				} else {
					activeOperation = getOperation(value);
					status = OpStatus.operator;
				}
			}
			case operator -> {
				if (isNumber) {
					activeOperation.setRMember(Double.valueOf(value));
					status = OpStatus.member2;
				} else {
					activeOperation = getOperation(value);
				}
			}
			default -> {
				;
			}
		}
		return activeOperation;
	}

	public char[] getNumberChars() {
		return numbers.toCharArray();
	}

	public char[] getOperatorChars() {
		return operators.toCharArray();
	}

	public Operation addOperation(String op, String lMember, String rMember) {
		return null;
	}

	public Operation getOperation(String op) {
		Operation operation = null;
		switch (op) {
		case "+":
			operation = new Addition();
			break;

		default:
			operation = new Operation();
		}
		operation.setLMember(activeOperation.getLMember());
		return operation;
	}

}
