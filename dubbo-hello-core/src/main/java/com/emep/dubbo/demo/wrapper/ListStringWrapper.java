package com.emep.dubbo.demo.wrapper;

import java.util.ArrayList;

public class ListStringWrapper {

	private ArrayList<String> pollutantIds;

	public ListStringWrapper(ArrayList<String> pollutantIds) {
		super();
		this.pollutantIds = pollutantIds;
	}

	public ListStringWrapper() {
		super();
	}

	public ArrayList<String> getPollutantIds() {
		return pollutantIds;
	}

	public void setPollutantIds(ArrayList<String> pollutantIds) {
		this.pollutantIds = pollutantIds;
	}

}
