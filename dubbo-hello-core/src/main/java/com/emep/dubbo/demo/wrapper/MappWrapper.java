package com.emep.dubbo.demo.wrapper;

import java.util.HashMap;

public class MappWrapper {

	private HashMap<String, Object> pollutantValues;

	public MappWrapper() {
		super();
	}

	public MappWrapper(HashMap<String, Object> pollutantValues) {
		super();
		this.pollutantValues = pollutantValues;
	}

	public HashMap<String, Object> getPollutantValues() {
		return pollutantValues;
	}

	public void setPollutantValues(HashMap<String, Object> pollutantValues) {
		this.pollutantValues = pollutantValues;
	}

}
