package com.etltool.dataprocessor;

import com.etltool.reader.DataReader;
import com.etltool.transformer.Transformer;
import com.etltool.writer.DataWriter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DataProcessorDetails<RawDataRow, ProcessedDataRow> {

	private DataReader<RawDataRow> dataReader;
	private DataWriter<ProcessedDataRow> dataWriter;
	private Transformer<RawDataRow, ProcessedDataRow> transformer;

}
