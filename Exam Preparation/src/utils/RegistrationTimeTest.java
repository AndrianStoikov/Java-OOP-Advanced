package utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Andrian on 17.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class RegistrationTimeTest {
    private static final String VALID_REGISTRATION_TIME = "12:24 26/02/2016";
    private static final String VALID_LEAP_YEAR_TIME = "12:24 29/02/2000";

    private static final String INVALID_FEBRUARY_WITH_29_DAYS = "12:24 29/02/2001";
    private static final String INVALID_DATE_FORMAT_REGISTRATION_TIME = "12:24 26.02.2016";
    private static final String INVALID_TIME_FORMAT_REGISTRATION_TIME = "12 24 26/02/2016";
    private static final String INVALID_FORMAT_REGISTRATION_TIME = "12:24   26/02/2016";

    private static final String REGISTRATION_TIME_WITH_NEGATIVE_MINUTES = "-12:24 26/02/2016";
    private static final String REGISTRATION_TIME_WITH_NEGATIVE_HOURS = "12:-24 26/02/2016";
    private static final String REGISTRATION_TIME_WITH_NEGATIVE_DAYS = "12:24 -26/02/2016";

    private static final String REGISTRATION_TIME_WITH_MORE_THAN_31_DAYS = "12:24 32/02/2016";
    private static final String REGISTRATION_TIME_WITH_NEGATIVE_MONTHS = "12:24 26/-02/2016";
    private static final String REGISTRATION_TIME_WITH_MORE_THAN_12_MONTHS = "12:24 26/13/2016";
    private static final String REGISTRATION_TIME_WITH_NEGATIVE_YEAR = "12:24 26/02/-1";

    private static final Integer VALID_HOURS_RETURN = 12;
    private static final Integer VALID_MINUTES_RETURN = 24;
    private static final Integer VALID_DAY_RETURN = 26;
    private static final Integer VALID_MONTHS_RETURN = 2;
    private static final Integer VALID_YEAR_RETURN = 2016;
    private static final String VALID_TO_STRING_RESULT = "12:24 26/02/2016";
    private RegistrationTime time;



    @Before
    public void InitializeValidTime() {
        this.time = new RegistrationTime(VALID_REGISTRATION_TIME);
    }

    @Test
    public void InitializeValidLeapYear() {
        this.time = new RegistrationTime(VALID_LEAP_YEAR_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeFebruaryWith29DaysInInvalidYear() {
        this.time = new RegistrationTime(INVALID_FEBRUARY_WITH_29_DAYS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeInvalidDateFormatTime() {
        this.time = new RegistrationTime(INVALID_DATE_FORMAT_REGISTRATION_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeInvalidTimeFormatTime() {
        this.time = new RegistrationTime(INVALID_TIME_FORMAT_REGISTRATION_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeInvalidFormatTime() {
        this.time = new RegistrationTime(INVALID_FORMAT_REGISTRATION_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeNegativeMinutesFormatTime() {
        this.time = new RegistrationTime(REGISTRATION_TIME_WITH_NEGATIVE_MINUTES);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeNegativeHoursFormatTime() {
        this.time = new RegistrationTime(REGISTRATION_TIME_WITH_NEGATIVE_HOURS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeNegativeDaysFormatTime() {
        this.time = new RegistrationTime(REGISTRATION_TIME_WITH_NEGATIVE_DAYS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeMoreThan31DaysFormatTime() {
        this.time = new RegistrationTime(REGISTRATION_TIME_WITH_MORE_THAN_31_DAYS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeNegativeMonthsFormatTime() {
        this.time = new RegistrationTime(REGISTRATION_TIME_WITH_NEGATIVE_MONTHS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeWithMoreThan12MonthsFormatTime() {
        this.time = new RegistrationTime(REGISTRATION_TIME_WITH_MORE_THAN_12_MONTHS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InitializeNegativeYearFormatTime() {
        this.time = new RegistrationTime(REGISTRATION_TIME_WITH_NEGATIVE_YEAR);
    }

    @Test
    public void testReturnsValidHours() {
        Assert.assertEquals(VALID_HOURS_RETURN, this.time.getHour());
    }

    @Test
    public void testReturnsValidMinutes() {
        Assert.assertEquals(VALID_MINUTES_RETURN, this.time.getMinutes());
    }

    @Test
    public void testReturnsValidDay() {
        Assert.assertEquals(VALID_DAY_RETURN, this.time.getDay());
    }

    @Test
    public void testReturnsValidMonth() {
        Assert.assertEquals(VALID_MONTHS_RETURN, this.time.getMonth());
    }

    @Test
    public void testReturnsValidYear() {
        Assert.assertEquals(VALID_YEAR_RETURN, this.time.getYear());
    }

    @Test
    public void testReturnsValidToStringFormat() {
        Assert.assertEquals(VALID_TO_STRING_RESULT, this.time.toString());
    }
}