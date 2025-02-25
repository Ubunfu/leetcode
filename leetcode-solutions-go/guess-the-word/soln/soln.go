package soln

import (
	"errors"
	"guess-the-word/oracle"
)

var ErrorEmptyWordList error = errors.New("empty_word_list")

func findSecretWord(wordlist []string, o *oracle.Oracle) (string, error) {

	remainingOptions := wordlist
	for {
		// return an error if the word list is empty
		if len(remainingOptions) == 0 {
			return "", ErrorEmptyWordList
		}

		// guess the first word of the remaining options
		guess := remainingOptions[0]
		runeMatches, err := o.Guess(guess)
		if err != nil {
			return "", err
		}
		// if every rune matches, we win
		if runeMatches == len(guess) {
			return guess, nil
		}

		// if multiple options remain, attempt to re-filter them
		remainingOptions = filterOptions(remainingOptions, guess, runeMatches)
	}
}

// filter out all the words that don't match the guess well enough
func filterOptions(options []string, guess string, guessMatches int) []string {
	filteredOptions := make([]string, 0, len(options))
	// build a list of filtered word options
	for _, possibleMatch := range options {
		if calculateRuneMatches(guess, possibleMatch) == guessMatches {
			filteredOptions = append(filteredOptions, possibleMatch)
		}
	}
	return filteredOptions
}

// Calculate how many runes in `guess` match the value and position
// of the runes in `possibleMatch`
func calculateRuneMatches(guess string, possibleMatch string) int {
	guessRunes := []rune(guess)
	possibleMatchRunes := []rune(possibleMatch)
	runeMatches := 0
	for i, v := range guessRunes {
		if possibleMatchRunes[i] == v {
			runeMatches++
		}
	}
	return runeMatches
}
