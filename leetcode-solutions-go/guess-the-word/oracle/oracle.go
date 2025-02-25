package oracle

import "errors"

var ErrorInvalidWord error = errors.New("invalid_word")
var ErrorExhaustedGuesses error = errors.New("exhausted_guesses")

/*
Owns the set of valid words, the correct secret word, and the guess allowance.
*/
type Oracle struct {
	Words       []string
	Secret      string
	GuessesLeft int
}

/*
Submits a guess at the correct word to the Oracle.
Returns an error if the guess is invalid or the guess allowance is empty.
If the guess is valid and guesses remain, returns the number of runes in the
guess that match the secret word in both value and position.
*/
func (o *Oracle) Guess(word string) (int, error) {
	if o.GuessesLeft == 0 {
		return 0, ErrorExhaustedGuesses
	}
	o.GuessesLeft--
	if !isWordInList(word, o.Words) {
		return 0, ErrorInvalidWord
	}
	return calculateRuneMatches(word, o.Secret), nil
}

func isWordInList(word string, wordList []string) bool {
	for _, v := range wordList {
		if v == word {
			return true
		}
	}
	return false
}

func calculateRuneMatches(word string, secret string) int {
	wordRunes := []rune(word)
	secretRunes := []rune(secret)

	runeMatches := 0
	for i, v := range wordRunes {
		if secretRunes[i] == v {
			runeMatches++
		}
	}
	return runeMatches
}
