package com.etltool.bean.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etltool.dataprocessor.DataProcessorDetails;
import com.etltool.datarow.impl.ProcessedDataRow;
import com.etltool.datarow.impl.RawDataRow;
import com.etltool.reader.impl.FileDataReaderImpl;
import com.etltool.transformer.impl.SalaryTransformer;
import com.etltool.writer.impl.FileDataWriterImpl;

@Configuration
public class BeanInitializer {

	@Bean("fileDataProcessorDetails")
	public DataProcessorDetails<RawDataRow, ProcessedDataRow> getFileDataProcessorDetails(
			@Autowired FileDataReaderImpl fileDataReaderImpl, 
			@Autowired FileDataWriterImpl fileDataWriterImpl,
			@Autowired SalaryTransformer salaryTransformer) {
		return new DataProcessorDetails<>(fileDataReaderImpl, fileDataWriterImpl, salaryTransformer);
	}

}
