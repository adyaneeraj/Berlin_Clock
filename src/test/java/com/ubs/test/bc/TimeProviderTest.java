package com.ubs.test.bc;

import java.time.LocalTime;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimeProviderTest {
	private Map<String, Boolean[]> clockLamps = null;

	@Before
	public void setUp() {
		clockLamps = TimeProvider.getInstance().getClockLamps();
	}

	@Test
	public void testTopLampBlink() {
		if (LocalTime.now().getSecond() % 2 == 0) {
			Assert.assertEquals(Boolean.TRUE,
					clockLamps.get(Constants.TOP_LAMP)[0]);
		} else {
			Assert.assertEquals(Boolean.FALSE,
					clockLamps.get(Constants.TOP_LAMP)[0]);
		}
	}

	@Test
	public void testFiveHoursLampsBlink() {
		for (int i = 0; i < clockLamps.get(Constants.FIVE_HOURS_LAMPS).length; i++) {
			if (i < (LocalTime.now().getHour() / 5)) {
				Assert.assertEquals(Boolean.TRUE,
						clockLamps.get(Constants.FIVE_HOURS_LAMPS)[i]);
			} else {
				Assert.assertEquals(Boolean.FALSE,
						clockLamps.get(Constants.FIVE_HOURS_LAMPS)[i]);
			}
		}

	}

	@Test
	public void testSingleHoursLampsBlink() {
		for (int i = 0; i < clockLamps.get(Constants.SINGLE_HOUR_LAMPS).length; i++) {
			if (i < (LocalTime.now().getHour() % 5)) {
				Assert.assertEquals(Boolean.TRUE,
						clockLamps.get(Constants.SINGLE_HOUR_LAMPS)[i]);
			} else {
				Assert.assertEquals(Boolean.FALSE,
						clockLamps.get(Constants.SINGLE_HOUR_LAMPS)[i]);
			}
		}
	}

	@Test
	public void testFiveMinutLampsBlink() {

		for (int i = 0; i < clockLamps.get(Constants.FIVE_MINUTES_LAMPS).length; i++) {
			if (i < (LocalTime.now().getMinute() / 5)) {
				Assert.assertEquals(Boolean.TRUE,
						clockLamps.get(Constants.FIVE_MINUTES_LAMPS)[i]);
			} else {
				Assert.assertEquals(Boolean.FALSE,
						clockLamps.get(Constants.FIVE_MINUTES_LAMPS)[i]);
			}

		}
	}

	@Test
	public void testSingleMinutLampsBlink() {
		for (int i = 0; i < clockLamps.get(Constants.SINGLE_MINUTE_LAMPS).length; i++) {
			if (i < (LocalTime.now().getMinute() % 5)) {
				Assert.assertEquals(Boolean.TRUE,
						clockLamps.get(Constants.SINGLE_MINUTE_LAMPS)[i]);
			} else {
				Assert.assertEquals(Boolean.FALSE,
						clockLamps.get(Constants.SINGLE_MINUTE_LAMPS)[i]);
			}
		}
	}

}
