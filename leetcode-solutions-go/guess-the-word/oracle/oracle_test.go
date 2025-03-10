package oracle

import (
	"errors"
	"testing"
)

const UnexpectedError = "Unexpected error '%v'"
const LogIncorrectError = "Expected error '%s', but observed '%v'"
const LogIncorrectResult = "Expected return value '%d', but observed '%d'"

func TestGivenInvalidWordExpectReturnsZeroAndErrorInvalidWord(t *testing.T) {
	oracle := Oracle{
		GuessesLeft: 1,
	}

	result, err := oracle.Guess("catt")

	if !errors.Is(err, ErrorInvalidWord) {
		t.Errorf(LogIncorrectError, ErrorInvalidWord, err)
	}
	if result != 0 {
		t.Errorf(LogIncorrectResult, 0, result)
	}
}

func TestGivenExhaustedGuessesExpectReturnsZeroAndErrorExhaustedGuesses(t *testing.T) {
	oracle := Oracle{}

	_, err := oracle.Guess("cats")

	if !errors.Is(err, ErrorExhaustedGuesses) {
		t.Errorf(LogIncorrectError, ErrorExhaustedGuesses, err)
	}
}

func TestGivenValidWordAndGuessesLeftExpectReturnsCharMatches(t *testing.T) {
	oracle := Oracle{
		Words:       []string{"taco", "tank", "bank", "pink", "polo"},
		Secret:      "tank",
		GuessesLeft: 3,
	}

	result, err := oracle.Guess("taco")

	if err != nil {
		t.Errorf(UnexpectedError, err)
	}
	if result != 2 {
		t.Errorf(LogIncorrectResult, 2, result)
	}
	if oracle.GuessesLeft >= 3 {
		t.Errorf("Expected guesses left to be less than 3, but observed %d", oracle.GuessesLeft)
	}
}
