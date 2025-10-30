package wordy

import (
	"errors"
	"slices"
	"strconv"
	"strings"
)

func Answer(question string) (int, bool) {
	ops := []string{"plus", "minus", "multiplied", "divided"}
	invalidOps := []string{"cubed"}
	replaced1 := strings.Replace(question, "?", "", -1)
	replaced2 := strings.Replace(replaced1, "What is", "", -1)
	words := strings.Fields(replaced2)

	var sanitised []string

	for i, v := range words {

		hasOp := contains(v, ops)
		hasNumerical := isNumerical(v)

		if i < len(words)-1 {
			nextIsOp := contains(words[i+1], ops)
			nextIsNumerical := isNumerical(words[i+1])
			nextIsInvalidOp := contains(words[i+1], invalidOps)

			if (hasOp && nextIsOp) || (hasNumerical && nextIsNumerical) || (hasNumerical && nextIsInvalidOp) {
				return 0, false
			}
		}

		if hasOp || hasNumerical {
			sanitised = append(sanitised, v)
		}
	}

	if len(sanitised)%2 == 0 {
		return 0, false
	}

	if len(sanitised) == 1 {
		v, _ := strconv.Atoi(sanitised[0])
		return v, true
	}

	if res, err := extractSliceAndDoOp(sanitised); err != nil {
		return 0, false
	} else {
		return res, true
	}
}

func contains(s string, ops []string) bool {
	return slices.Contains(ops, s)
}

func isNumerical(s string) bool {
	if _, err := strconv.Atoi(s); err == nil {
		return true
	}
	return false
}

func doOp(a int, op string, b int) (int, error) {
	switch op {
	case "plus":
		return plus(a, b), nil
	case "minus":
		return minus(a, b), nil
	case "multiplied":
		return multiply(a, b), nil
	case "divided":
		return divide(a, b)
	default:
		return 0, errors.New("invalid op")
	}
}

func plus(a int, b int) int {
	return a + b
}

func minus(a int, b int) int {
	return a - b
}

func multiply(a int, b int) int {
	return a * b
}

func divide(a int, b int) (int, error) {
	if b == 0 {
		return 0, errors.New("division by zero")
	}
	return a / b, nil
}

func extractSliceAndDoOp(words []string) (int, error) {
	if len(words) == 1 {
		return strconv.Atoi(words[0])
	}

	if isNumerical(words[0]) && !isNumerical(words[1]) && isNumerical(words[2]) {
		a, _ := strconv.Atoi(words[0])
		b, _ := strconv.Atoi(words[2])

		if v, err := doOp(a, words[1], b); err == nil {
			newSlice := append([]string{strconv.Itoa(v)}, words[3:]...)
			return extractSliceAndDoOp(newSlice)
		}
	}

	return 0, errors.New("unknown error")
}
