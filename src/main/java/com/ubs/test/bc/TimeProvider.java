package com.ubs.test.bc;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public final class TimeProvider {

	private static final TimeProvider TIME_PROVIDER = new TimeProvider();
	private final Map<String, Boolean[]> clockLamps = new HashMap<String, Boolean[]>();

	private TimeProvider() {
	}

	public static TimeProvider getInstance() {
		return TIME_PROVIDER;
	}

	public Map<String, Boolean[]> getClockLamps() {

		clockLamps.put(Constants.TOP_LAMP, getTopLamp());
		clockLamps.put(Constants.FIVE_HOURS_LAMPS, getFiveHoursLamps());
		clockLamps.put(Constants.SINGLE_HOUR_LAMPS, getSingleHoursLamps());
		clockLamps.put(Constants.FIVE_MINUTES_LAMPS, getFiveMinutesLamps());
		clockLamps.put(Constants.SINGLE_MINUTE_LAMPS, getSingleMinutesLamps());

		return clockLamps;
	}

	private Boolean[] getTopLamp() {
		Boolean[] topLamp = new Boolean[1];
		topLamp[0] = Boolean.FALSE;
		if (getSeconds() % 2 == 0)
			topLamp[0] = Boolean.TRUE;

		return topLamp;
	}

	private Boolean[] getFiveHoursLamps() {
		int hours = getHours();
		Boolean[] fiveHoursLamps = new Boolean[4];
		for (int i = 0; i < fiveHoursLamps.length; i++) {
			if (i < hours / 5) {
				fiveHoursLamps[i] = Boolean.TRUE;
			} else {
				fiveHoursLamps[i] = Boolean.FALSE;
			}
		}
		return fiveHoursLamps;
	}

	private Boolean[] getSingleHoursLamps() {
		int hours = getHours();
		Boolean[] singleHoursLamps = new Boolean[4];
		for (int i = 0; i < singleHoursLamps.length; i++) {
			if (i < hours % 5) {
				singleHoursLamps[i] = Boolean.TRUE;
			} else {
				singleHoursLamps[i] = Boolean.FALSE;
			}
		}
		return singleHoursLamps;
	}

	private Boolean[] getFiveMinutesLamps() {
		int minutes = getMinutes();
		Boolean[] fiveMinutesLamps = new Boolean[11];
		for (int i = 0; i < fiveMinutesLamps.length; i++) {
			if (i < minutes / 5) {
				fiveMinutesLamps[i] = Boolean.TRUE;
			} else {
				fiveMinutesLamps[i] = Boolean.FALSE;
			}
		}
		return fiveMinutesLamps;
	}

	private Boolean[] getSingleMinutesLamps() {
		int minutes = getMinutes();
		Boolean[] singleMinutesLamps = new Boolean[4];

		for (int i = 0; i < singleMinutesLamps.length; i++) {
			if (i < minutes % 5) {
				singleMinutesLamps[i] = Boolean.TRUE;
			} else {
				singleMinutesLamps[i] = Boolean.FALSE;
			}
		}

		return singleMinutesLamps;
	}

	private int getSeconds() {
		return LocalTime.now().getSecond();
	}

	private int getMinutes() {
		return LocalTime.now().getMinute();
	}

	private int getHours() {
		return LocalTime.now().getHour();
	}
}
