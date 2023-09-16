package com.etltool.reader;

import java.util.List;

public interface DataReader<T> {

	void openConnection();

	List<T> read();

}
