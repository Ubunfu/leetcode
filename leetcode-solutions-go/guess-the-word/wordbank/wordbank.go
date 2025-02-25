package wordbank

import (
	"math/rand"
)

/*
Generates a slice of rune slices, where each slice is a 6-letter "word"
*/
func Generate(quant int) []string {
	// pre-make the slice optimally to minimize expansion frequency
	wordbank := make([]string, 0, quant)
	for i := 0; i < quant; i++ {
		// add another 6-letter word into the word bank
		wordbank = append(wordbank, generateWord(6))
	}
	return wordbank
}

/*
Generates a slice of lower-case runes with the given length
*/
func generateWord(length int) string {
	charList := []rune("abcdefghijklmnopqrstuvwxyz")

	// pre-make the slice optimally to minimize expansion frequency
	word := make([]rune, 0, length)
	for i := 0; i < length; i++ {
		// append a random letter from the char list on to the word
		word = append(word, charList[rand.Intn(26)])
	}
	return string(word)
}
