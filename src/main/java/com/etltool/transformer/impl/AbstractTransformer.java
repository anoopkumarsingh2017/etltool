package com.etltool.transformer.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etltool.datarow.impl.ProcessedDataRow;
import com.etltool.datarow.impl.RawDataRow;
import com.etltool.transformer.Transformer;

public abstract class AbstractTransformer implements Transformer<RawDataRow, ProcessedDataRow> {

	@Override
	public List<ProcessedDataRow> transform(List<RawDataRow> rawDataRows) {
		List<ProcessedDataRow> processedDataRows = new ArrayList<>();

		ProcessedDataRow processedDataRow = null;
		Map<String, String> transformedDataMap = null;
		for (RawDataRow rawDataRow : rawDataRows) {
			transformedDataMap = new HashMap<>(rawDataRow.getDataRow().size());
			customTransformation(rawDataRow.getDataRow(), transformedDataMap);
			processedDataRow = new ProcessedDataRow(rawDataRow.getDataRow(), transformedDataMap);
			processedDataRows.add(processedDataRow);
		}
		return processedDataRows;
	}

	protected abstract void customTransformation(Map<String, String> rawDataMap,
			Map<String, String> transformedDataMap);

}
