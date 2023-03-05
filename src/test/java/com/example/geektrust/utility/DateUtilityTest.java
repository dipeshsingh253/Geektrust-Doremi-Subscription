package com.example.geektrust.utility;

import com.example.geektrust.exception.InvalidDateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilityTest {

    @Test
    void testConvertStringToDate() {

        assertNotNull(DateUtility.convertStringToDate("20-02-2022"));
        assertTrue(DateUtility.convertStringToDate("20-02-2022") instanceof LocalDate);

    }

    @Test
    void testIsValidDate() {

        assertThrows(
                InvalidDateException.class,
                () ->{
                    DateUtility.isValidDate(DateUtility.convertStringToDate("32-02-2022"));
                }
        );

        assertThrows(
                InvalidDateException.class,
                () ->{
                    DateUtility.isValidDate(DateUtility.convertStringToDate("03-13-2022"));
                }
        );

        assertThrows(
                InvalidDateException.class,
                () ->{
                    DateUtility.isValidDate(DateUtility.convertStringToDate("02-02-20225"));
                }
        );

    }
}