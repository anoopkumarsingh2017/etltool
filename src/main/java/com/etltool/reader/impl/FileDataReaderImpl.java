package com.etltool.reader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.etltool.datarow.impl.RawDataRow;
import com.etltool.datasource.impl.FileDataSource;
import com.etltool.reader.AbstractDataReader;

@Component
public class FileDataReaderImpl extends AbstractDataReader<RawDataRow> {

	private BufferedReader bufferedReader;

	public FileDataReaderImpl(FileDataSource fileDataSource) {
		super(fileDataSource);
	}

	@Override
	public void openConnection() {

		try {
			// Create a FileReader to read the file
			FileDataSource fileDataSource = (FileDataSource) getDataSource();
			FileReader fileReader = new FileReader(fileDataSource.getFilePath() + "\\" + fileDataSource.getFileName());

			// Wrap the FileReader in a BufferedReader for efficient reading
			bufferedReader = new BufferedReader(fileReader);
		} catch (IOException e) {
			// Handle any potential exceptions, such as file not found or IO errors
			e.printStackTrace();
		}

	}

	@Override
	public List<RawDataRow> read() {
		List<RawDataRow> rawDataRows = new ArrayList<>();
		try {
			// Read and process lines from the file
			String line;
			boolean header = true;
			String[] dataHeader = null;
			String[] dataValue;
			Map<String, String> data = null;
			RawDataRow rawDataRow = null;
			while ((line = bufferedReader.readLine()) != null) {
				// Process the 'line' variable here (e.g., print it)
				if (header) {
					dataHeader = line.split(",");
					header = false;
					continue;
				}
				dataValue = line.split(",");
				data = new HashMap<>(dataHeader.length);
				for (int i = 0; i < dataHeader.length; i++) {
					data.put(dataHeader[i].trim(), dataValue[i]);
				}
				rawDataRow = new RawDataRow(data);
				rawDataRows.add(rawDataRow);
			}

			// Close the BufferedReader when done
			bufferedReader.close();
		} catch (IOException e) {
			// Handle any potential exceptions, such as file not found or IO errors
			e.printStackTrace();
		}

		return rawDataRows;
	}

}
