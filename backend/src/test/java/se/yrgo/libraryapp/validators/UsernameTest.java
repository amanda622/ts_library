package se.yrgo.libraryapp.validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/* import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat; */


public class UsernameTest {
/*     @Test
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
    } */
    
    @ParameterizedTest
    @ValueSource(strings = {"bosse", "bo_sse", "user-name", "user.name", "user@name", "tova"})
    void correctUsername(String username) {
        assertTrue(Username.validate(username), "Expected valid username, but got invalid: " + username);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-bosse", "bo", "b!osse", "", "toolongusername@", "1nvalidCharacter*", "liv"})
    @EmptySource
    void incorrectUsername(String username) {
        assertFalse(Username.validate(username), "Expected invalid username, but got valid: " + username);
    }
}
