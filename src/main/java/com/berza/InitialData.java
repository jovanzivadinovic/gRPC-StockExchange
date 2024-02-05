package com.berza;



import java.time.Instant;

import com.berza.grpc.Company;
import com.google.protobuf.Timestamp;

public class InitialData {
	static Object[][] companyData = 
		{{"AAPL", "Apple", 181.18, -0.73, Timestamp.newBuilder()
				.setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"MSFT", "Microsoft", 367.75, -0.19, Timestamp.newBuilder()
				.setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"AMZN", "Amazon", 145.24, 0.67, Timestamp.newBuilder()
				.setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"NVDA", "Nvidia", 518.7899, 5.66, Timestamp.newBuilder()
				.setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"META", "Meta", 357.67, 1.625, Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"TSLA", "Tesla", 240.6401, 1.326, Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"V", "Visa", 261.85, 0.832, Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"MA", "Mastercard", 420.98, 0.372, Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"ADBE", "Adobe", 580.925, 2.891, Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()},
		{"SHEL", "Shell", 64.495, -1.879, Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond())
				.setNanos(Instant.now().getNano())
				.build()}};
	
	
	public static Company[] initCompany() {
		Company[] com = new Company[companyData.length];
		int i =0;
		for (Object[] data:companyData) {
			Company c = Company.newBuilder()
					.setSymbol(data[0].toString())
					.setName(data[1].toString())
					.setPrice((Double) data[2]).setChange((Double) data[3])
					.setDate((Timestamp) data[4]).build();
			com[i++] = c;
		}
		return com;
	}
}
