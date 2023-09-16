package com.etltool.writer;

import java.util.List;

public interface DataWriter<T> {

	void openConnection();

	void write(List<T> processedDataRows);

}
