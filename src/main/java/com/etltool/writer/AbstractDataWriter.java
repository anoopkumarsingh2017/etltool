package com.etltool.writer;

import com.etltool.datasource.DataSource;

public abstract class AbstractDataWriter<T> implements DataWriter<T> {
	
	private DataSource dataSource;

	public AbstractDataWriter(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}