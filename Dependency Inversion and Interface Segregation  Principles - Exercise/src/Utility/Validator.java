package Utility;

import exceptions.ArgumentException;

public class Validator {
    public static void ValidatePropertyValue(int value, String propertyName) throws ArgumentException {
        if (value <= 0) {
            throw new ArgumentException(String.format(Constants.IncorrectPropertyValueMessage, propertyName));
        }
    }

    public static void ValidateModelLength(String value, int minModelLength) throws ArgumentException {
        if (value.length() < minModelLength) {
            throw new ArgumentException (String.format(Constants.IncorrectModelLenghtMessage, minModelLength));
        }
    }
}
