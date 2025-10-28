package collatzconjecture

import "errors"

func CollatzConjecture(n int) (int, error) {
	if n <= 0 {
		return 0, errors.New("invalid input")
	}

	return collatzConjecture(n, 0), nil
}

func collatzConjecture(n int, steps int) int {
	if n == 1 {
		return steps
	} else if n%2 == 0 {
		steps++
		return collatzConjecture(n/2, steps)
	} else {
		steps++
		return collatzConjecture(n*3+1, steps)
	}

}
