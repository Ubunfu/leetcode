package wordbank

import (
	"testing"
)

func TestGenerateZeroReturnsEmptySlice(t *testing.T) {
	wordbank := Generate(0)

	if len(wordbank) != 0 {
		t.Errorf("Expected returned slice of length %d to be empty", len(wordbank))
	}
}

func TestGenerate100Returns100SixLetterRuneSlices(t *testing.T) {
	wordbank := Generate(100)

	if len(wordbank) != 100 {
		t.Errorf("Expected returned slice of length %d to be of length 100", len(wordbank))
	}

	for _, word := range wordbank {
		if len(word) != 6 {
			t.Errorf("Returned word %v that is not 6 runes long", word)
		}
	}
}
