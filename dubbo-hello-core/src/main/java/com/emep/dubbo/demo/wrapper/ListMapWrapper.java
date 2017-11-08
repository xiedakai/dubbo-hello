package com.emep.dubbo.demo.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListMapWrapper {

	private ArrayList<Map<String, Object>> dataForChecks;

	/**
	 * @return the listMaps
	 */
	public List<Map<String, Object>> getDataForChecks() {
		return dataForChecks;
	}

	/**
	 * @param listMaps
	 *            the listMaps to set
	 */
	public void setDataForChecks(ArrayList<Map<String, Object>> dataForChecks) {
		this.dataForChecks = dataForChecks;
	}

	public ListMapWrapper() {
		super();
	}

	public ListMapWrapper(ArrayList<Map<String, Object>> listMaps) {
		super();
		this.dataForChecks = listMaps;
	}

}
