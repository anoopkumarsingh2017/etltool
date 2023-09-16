package com.etltool.datarow.impl;

import java.util.Map;

import com.etltool.datarow.DataRow;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RawDataRow implements DataRow {

	private Map<String, String> rawDataRow;

	@Override
	public Map<String, String> getDataRow() {
		return rawDataRow;
	}

}
