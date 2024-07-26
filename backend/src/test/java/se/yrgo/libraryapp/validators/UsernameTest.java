package se.yrgo.libraryapp.validators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


public class UsernameTest {
    @Test
    void correctUsername() {
        assertTrue(Username.validate("bosse"));
        assertThat(Username.validate("bosse")).isTrue();
        assertThat(Username.validate("Bosse123")).isTrue();
        assertThat(Username.validate("bo_sse")).isTrue();
    }

    @Test
    void incorrectUsername() {
        assertFalse(Username.validate("name with space"));
        assertThat(Username.validate("name with space")).isFalse();
        assertThat(Username.validate("")).isFalse(); // Tom sträng
        assertThat(Username.validate("   ")).isFalse(); // Bara blanksteg
        assertThat(Username.validate("bo")).isFalse(); // För kort
        assertThat(Username.validate("b!osse")).isFalse(); // Innehåller ogiltigt specialtecken
        assertThat(Username.validate(null)).isFalse(); // Null värde


    }
}
