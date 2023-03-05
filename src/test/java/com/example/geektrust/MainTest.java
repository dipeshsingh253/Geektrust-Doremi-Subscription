package com.example.geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {


    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testInputCommand() throws FileNotFoundException {
        final String expectedOutput = "RENEWAL_REMINDER MUSIC 10-03-2022\n" +
                "RENEWAL_REMINDER VIDEO 10-05-2022\n" +
                "RENEWAL_REMINDER PODCAST 10-03-2022\n" +
                "RENEWAL_AMOUNT 750\n";

        Main.main(new String[]{"sample_input/input1.txt"});
        assertEquals(expectedOutput,outputStream.toString());

    }



    @Test
    void testFileNotFoundExceptionWhenFileNameNotPassed() {
    assertThrows(
               FileNotFoundException.class,
               () -> {
                   Main.main(new String[]{});
               }
       );
    }


}