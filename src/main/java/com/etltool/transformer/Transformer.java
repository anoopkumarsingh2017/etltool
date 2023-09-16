package com.etltool.transformer;

import java.util.List;

public interface Transformer<R,T> {

	List<T> transform(List<R> rawDataRows);
}
