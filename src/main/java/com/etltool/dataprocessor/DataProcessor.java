package com.etltool.dataprocessor;

import java.util.List;

import com.etltool.datarow.impl.ProcessedDataRow;
import com.etltool.datarow.impl.RawDataRow;

public class DataProcessor {

	public void processData(DataProcessorDetails<RawDataRow, ProcessedDataRow> dataProcessorDetails) {

		System.out.println("Starting processData..");

		dataProcessorDetails.getDataReader().openConnection();
		List<RawDataRow> rawDataRows = dataProcessorDetails.getDataReader().read();

		List<ProcessedDataRow> processedDataRows = dataProcessorDetails.getTransformer().transform(rawDataRows);

		dataProcessorDetails.getDataWriter().openConnection();
		dataProcessorDetails.getDataWriter().write(processedDataRows);

		System.out.println("Ending processData..");

	}

}
