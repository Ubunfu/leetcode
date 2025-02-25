package soln

import (
	"fmt"
	"testing"

	"guess-the-word/oracle"
	"guess-the-word/wordbank"
)

func TestFiveWordsThreeGuesses(t *testing.T) {
	wordList := []string{"abcdef", "fahilz", "peachy", "squidy", "coffee"}
	secretWord := "squidy"
	o := oracle.Oracle{
		Words:       wordList,
		Secret:      "squidy",
		GuessesLeft: 3,
	}
	foundWord, err := findSecretWord(wordList, &o)
	if err != nil {
		t.Errorf("Error finding word: %v", err)
	}
	if foundWord != secretWord {
		t.Errorf("Found the wrong secret word! Expected: %s, Found: %s", secretWord, foundWord)
	}
	fmt.Printf("Found secret word: %s with %d guesses remaining\n", foundWord, o.GuessesLeft)
}

func TestEmptyListReturnsError(t *testing.T) {
	wordBank := []string{}
	o := oracle.Oracle{}
	_, err := findSecretWord(wordBank, &o)
	if err != ErrorEmptyWordList {
		t.Errorf("Expected error: %v, got: %v", ErrorEmptyWordList, err)
	}
}

func Test100Words10Guesses(t *testing.T) {
	wordList := wordbank.Generate(100)
	secretWord := wordList[50]
	o := oracle.Oracle{
		Words:       wordList,
		Secret:      secretWord,
		GuessesLeft: 10,
	}
	foundWord, err := findSecretWord(wordList, &o)
	if err != nil {
		t.Errorf("Error finding word: %v", err)
	}
	if foundWord != secretWord {
		t.Errorf("Found the wrong secret word! Expected: %s, Found: %s", secretWord, foundWord)
	}
	fmt.Printf("Found secret word: %s with %d guesses remaining\n", foundWord, o.GuessesLeft)
}
