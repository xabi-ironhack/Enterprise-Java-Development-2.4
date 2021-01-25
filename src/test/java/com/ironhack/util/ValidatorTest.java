package com.ironhack.util;

import com.ironhack.classes.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void checkName_nameIsValid_returnsTrue() {
        assertTrue(Validator.checkName("Jose Torres"));
        assertTrue(Validator.checkName("José Torres"));
        assertTrue(Validator.checkName("Joze Torrez"));
        assertTrue(Validator.checkName("José Torre"));
    }

    @Test
    void checkName_nameNoSpaces_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("JoseTorres"));
    }

    @Test
    void checkName_nameTwoSpaces_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jose Torres Torres"));
    }

    @Test
    void checkName_nameSpacesBetweenAndEnd_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName(" Jose Torres"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jose Torres "));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName(" Jose Torres "));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jaume  Sanchez"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName(" Jaume  Sanchez"));
    }

    @Test
    void checkName_digitsAndSpecialCharacters_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("12345 6789"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("12345678901"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("jose @gmail"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("123456 Torres"));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkName("Jose 12345"));
    }

    @Test
    void checkAge_validAge_returnsTrue() {
        assertTrue(Validator.checkAge(10));
        assertTrue(Validator.checkAge(0));

    }

    @Test
    void checkAge_negativeAge_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkAge(-1));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkAge(-10));
    }


    @Test
    void writePerson_writesPerson_OK() {
        Person person = new Person("José Torres", 32, "Programmer");
        assertTrue(Validator.writePerson(person));
    }

    @Test
    void writePerson_rewritesSamePerson_OK() {
        Person person = new Person("José Torres", 35, "Programmer");
        assertTrue(Validator.writePerson(person));
    }
}