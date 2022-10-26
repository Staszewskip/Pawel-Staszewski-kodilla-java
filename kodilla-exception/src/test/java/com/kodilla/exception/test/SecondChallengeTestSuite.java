package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {
    @DisplayName("test that should not throw exception")
    @Test
    void probablyIWillNotThrowException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 1.3));
    }
    @DisplayName("test that should throw exception")
    @Test
    void probablyIWillThrowException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.3)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.3)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.5))
        );
    }

}
