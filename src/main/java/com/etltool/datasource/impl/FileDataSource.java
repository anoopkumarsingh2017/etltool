package com.etltool.datasource.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.etltool.datasource.DataSource;

@Component
@PropertySource("application.properties")
public class FileDataSource implements DataSource {

	@Value("${data.reader.file.path}")
	private String filePath;

	@Value("${data.reader.file.name}")
	private String fileName;

	private String fileNameProcessed;

	public String getFileNameProcessed() {
		return fileName+"_Processsed_"+System.currentTimeMillis();
	}

	public String getFilePath() {
		return filePath;
	}

	public String getFileName() {
		return fileName;
	}

}
