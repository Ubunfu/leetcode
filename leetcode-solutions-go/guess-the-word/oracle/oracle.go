package oracle

import "errors"

var ErrorInvalidWord error = errors.New("invalid_word")
var ErrorExhaustedGuesses error = errors.New("exhausted_guesses")

type Oracle struct {
	words       []string
	secret      string
	guessesLeft int
}

func (o *Oracle) Guess(word string) (int, error) {
	if o.guessesLeft == 0 {
		return 0, ErrorExhaustedGuesses
	}
	if !isWordInList(word, o.words) {
		return 0, ErrorInvalidWord
	}
	return calculateRuneMatches(word, o.secret), nil
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
