package soln

import (
	"testing"
)

const ErrorWrongAnswer = "Expected %d components, but calculated %d\n"

func TestOneComponent(t *testing.T) {
	result := CountCompleteComponents(2, [][]int{{0, 1}})
	answer := 1

	if result != answer {
		t.Errorf(ErrorWrongAnswer, answer, result)
	}
}

func TestSomeComponentsWithLoops(t *testing.T) {
	result := CountCompleteComponents(6, [][]int{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}})
	answer := 2

	if result != answer {
		t.Errorf(ErrorWrongAnswer, answer, result)
	}
}

func TestZeroNodes(t *testing.T) {
	result := CountCompleteComponents(0, [][]int{})
	answer := 0

	if result != answer {
		t.Errorf(ErrorWrongAnswer, answer, result)
	}
}

func TestSomeNodesZeroEdges(t *testing.T) {
	result := CountCompleteComponents(3, [][]int{})
	answer := 3

	if result != answer {
		t.Errorf(ErrorWrongAnswer, answer, result)
	}
}

func TestSomeNodesSomeEdges(t *testing.T) {
	result := CountCompleteComponents(4, [][]int{{3, 4}})
	answer := 3

	if result != answer {
		t.Errorf(ErrorWrongAnswer, answer, result)
	}
}
