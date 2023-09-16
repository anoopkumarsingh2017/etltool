package com.etltool.writer.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.etltool.datarow.impl.ProcessedDataRow;
import com.etltool.datasource.impl.FileDataSource;
import com.etltool.writer.AbstractDataWriter;

@Component
public class FileDataWriterImpl extends AbstractDataWriter<ProcessedDataRow> {

	private BufferedWriter bufferedWriter;

	public FileDataWriterImpl(FileDataSource fileDataSource) {
		super(fileDataSource);
	}

	@Override
	public void openConnection() {

		try {
			FileDataSource fileDataSource = (FileDataSource) getDataSource();
			// Create a FileWriter to write to the file
			FileWriter fileWriter = new FileWriter(
					fileDataSource.getFilePath() + "\\" + fileDataSource.getFileNameProcessed());

			// Wrap the FileWriter in a BufferedWriter for efficient writing
			bufferedWriter = new BufferedWriter(fileWriter);

		} catch (IOException e) {
			// Handle any potential exceptions, such as file not found or IO errors
			e.printStackTrace();
		}
	}

	@Override
	public void write(List<ProcessedDataRow> processedDataRows) {
		try {

			// write header
			String header = String.join(",", processedDataRows.get(0).getDataRow().keySet());
			bufferedWriter.write(header + "\n");

			processedDataRows.forEach(p -> {
				// Write the data to the file
				try {
					bufferedWriter.write(String.join(",", p.getDataRow().values()) + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			// Close the BufferedWriter to flush and save the changes
			bufferedWriter.close();

			System.out.println("Data has been written to the file.");
		} catch (IOException e) {
			// Handle any potential exceptions, such as file not found or IO errors
			e.printStackTrace();
		}
	}

}
