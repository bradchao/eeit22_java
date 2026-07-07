package com.example.spring10.apis;

public interface ReportGenerator {
	String fetchData();
	
	void export(String content);
	
	default void createAndExport() {
		System.out.println("開始....");
		String data = fetchData();
		String formatedData = formatData(data);
		export(formatedData);
		System.out.println("結束了");
	}
	
	private String formatData(String rawData) {
		return "格式化" + rawData.toUpperCase();
	}
	
}
