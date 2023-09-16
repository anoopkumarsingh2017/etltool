package com.etltool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etltool.dataprocessor.DataProcessor;
import com.etltool.dataprocessor.DataProcessorDetails;
import com.etltool.datarow.impl.ProcessedDataRow;
import com.etltool.datarow.impl.RawDataRow;

@RestController
@RequestMapping("/process/start")
public class MainController {

	@Autowired
	DataProcessorDetails<RawDataRow, ProcessedDataRow> fileDataProcessorDetails;

	@GetMapping("/file")
	void processFile() {

		DataProcessor dataProcessor = new DataProcessor();
		dataProcessor.processData(fileDataProcessorDetails);

	}
}
