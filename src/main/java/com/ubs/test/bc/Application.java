package com.ubs.test.bc;

import java.util.Map;

public class Application {

	public static void main(String[] args) {
		TimeProvider timeProvider = TimeProvider.getInstance();
		while(true){		
			printTime(timeProvider.getClockLamps());
		
		}
	}

	public static void printTime(Map<String, Boolean[]> clockLamps) {

		System.out.println(clockLamps.get(Constants.TOP_LAMP)[0]);
		System.out.println("----------------------");

		for (int i = 0; i < clockLamps.get(Constants.FIVE_HOURS_LAMPS).length; i++) {
			System.out.println(clockLamps.get(Constants.FIVE_HOURS_LAMPS)[i]);
		}
		System.out.println("----------------------");

		for (int i = 0; i < clockLamps.get(Constants.SINGLE_HOUR_LAMPS).length; i++) {
			System.out.println(clockLamps.get(Constants.SINGLE_HOUR_LAMPS)[i]);
		}

		System.out.println("----------------------");

		for (int i = 0; i < clockLamps.get(Constants.FIVE_MINUTES_LAMPS).length; i++) {
			System.out.println(clockLamps.get(Constants.FIVE_MINUTES_LAMPS)[i]);
		}

		System.out.println("----------------------");

		for (int i = 0; i < clockLamps.get(Constants.SINGLE_MINUTE_LAMPS).length; i++) {
			System.out
					.println(clockLamps.get(Constants.SINGLE_MINUTE_LAMPS)[i]);
		}
	}

}