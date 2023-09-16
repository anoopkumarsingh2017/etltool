package com.etltool.transformer.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SalaryTransformer extends AbstractTransformer {

	@Override
	public void customTransformation(Map<String, String> rawDataMap, Map<String, String> transformedDataMap) {
		rawDataMap.forEach((k, v) -> {
			if (k.equals("SALARY")) {
				double annualSalary = Double.parseDouble(v) * 12;
				transformedDataMap.put("ANNUAL_SALARY", String.valueOf(annualSalary));
			}
			transformedDataMap.put(k, v);
		});
	}

}
