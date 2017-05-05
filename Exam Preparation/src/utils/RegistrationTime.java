package utils;

import java.util.Calendar;

public class RegistrationTime {
    private Integer hour;
    private Integer minutes;
    private Integer day;
    private Integer month;
    private Integer year;

    public RegistrationTime(String registrationTime) {
        this.initializeData(this.parseData(registrationTime));
    }

    public Integer getHour() {
        return hour;
    }

    private void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }

    private void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getMonth() {
        return month;
    }

    private void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    private void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return this.year;
    }

    private void setYear(Integer year) {
        this.year = year;
    }

    private Integer[] parseData(String registrationTime) {
        try {
            String[] splittedRegistrationTime = registrationTime.split("\\s");
            String hourAndMinutes = splittedRegistrationTime[0];
            String date = splittedRegistrationTime[1];

            String[] splittedHoursAndMinutes = hourAndMinutes.split(":");
            String[] splittedDate = date.split("/");

            Integer hour = Integer.parseInt(splittedHoursAndMinutes[0]);
            Integer minutes = Integer.parseInt(splittedHoursAndMinutes[1]);

            Integer day = Integer.parseInt(splittedDate[0]);
            Integer month = Integer.parseInt(splittedDate[1]);
            Integer year = Integer.parseInt(splittedDate[2]);

            Integer[] parsedData = new Integer[5];

            parsedData[0] = hour;
            parsedData[1] = minutes;
            parsedData[2] = day;
            parsedData[3] = month;
            parsedData[4] = year;

            return parsedData;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid Date Format passed");
        }

    }

    private void initializeData(Integer[] data) {
        this.dataIsValid(data);

        Integer hour = data[0];
        Integer minutes = data[1];
        Integer day = data[2];
        Integer month = data[3];
        Integer year = data[4];

        this.setHour(hour);
        this.setMinutes(minutes);
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    private void dataIsValid(Integer[] data) {
        Integer hour = data[0];
        if (hour < 0)
            throw new IllegalArgumentException("Hours cannot be less than zero");
        Integer minutes = data[1];
        if (minutes < 0)
            throw new IllegalArgumentException("Minutes cannot be less than zero");
        Integer month = data[3];
        if (month < 0 || month > 12)
            throw new IllegalArgumentException("Month cannot be less than zero or more than 12");
        Integer year = data[4];
        if (year < 0)
            throw new IllegalArgumentException("Year cannot be less than zero");
        Integer day = data[2];

        if (month == 2) {
            if (this.isLeapYear(year)) {
                if (day < 0 || day > 29)
                    throw new IllegalArgumentException("Day cannot be less than zero or more than 29");
            } else {
                if (day < 0 || day > 28)
                    throw new IllegalArgumentException("Day cannot be less than zero or more than 28");
            }
        } else
        if (day < 0 || day > 31)
            throw new IllegalArgumentException("Day cannot be less than zero or more than 31");


    }

    private boolean isLeapYear(Integer year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    @Override
    public String toString() {
        String hour = this.hour < 10 ? "0" + this.hour : this.hour + "";
        String minutes = this.minutes < 10 ? "0" + this.minutes : this.minutes + "";
        String day = this.day < 10 ? "0" + this.day : this.day + "";
        String month = this.month < 10 ? "0" + this.month : this.month + "";

        String result = hour + ":" + minutes + " " + day + "/" + month + "/" + this.year;
        return result;
    }
}
