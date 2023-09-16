package com.etltool.reader;

import com.etltool.datasource.DataSource;

public abstract class AbstractDataReader<T> implements DataReader<T> {

	private DataSource dataSource;

	public AbstractDataReader(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}
