package thefarm

import (
	"errors"
	"fmt"
)

func DivideFood(fc FodderCalculator, numOfCows int) (float64, error) {
	fa, err1 := fc.FodderAmount(numOfCows)
	ff, err2 := fc.FatteningFactor()

	if err1 != nil {
		return fa, err1
	}

	if err2 != nil {
		return ff, err2
	}

	return fa / float64(numOfCows) * ff, nil
}

func ValidateInputAndDivideFood(fc FodderCalculator, numOfCows int) (float64, error) {
	if numOfCows > 0 {
		return DivideFood(fc, numOfCows)
	} else {
		return 0, errors.New("invalid number of cows")
	}
}

type InvalidCowsError struct {
	numOfCows int
	message   string
}

func (ice *InvalidCowsError) Error() string {
	return fmt.Sprintf("%d cows are invalid: %s", ice.numOfCows, ice.message)
}

func ValidateNumberOfCows(numOfCows int) error {
	switch {
	case numOfCows > 0:
		return nil
	case numOfCows == 0:
		return &InvalidCowsError{numOfCows, "no cows don't need food"}
	default:
		return &InvalidCowsError{numOfCows, "there are no negative cows"}
	}
}
