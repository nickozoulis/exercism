package letter

// FreqMap records the frequency of each rune in a given text.
type FreqMap map[rune]int

// Frequency counts the frequency of each rune in a given text and returns this
// data as a FreqMap.
func Frequency(text string) FreqMap {
	frequencies := FreqMap{}
	for _, r := range text {
		frequencies[r]++
	}
	return frequencies
}

// ConcurrentFrequency counts the frequency of each rune in the given strings,
// by making use of concurrency.
func ConcurrentFrequency(texts []string) FreqMap {
	c := make(chan FreqMap, len(texts))

	for _, t := range texts {
		go func() {
			c <- Frequency(t)
		}()
	}

	frequencies := FreqMap{}

	for range len(texts) {
		select {
		case f := <-c:
			for k, v := range f {
				frequencies[k] = v + frequencies[k]
			}
		}
	}

	return frequencies
}

//func ConcurrentFrequencyBlocking(texts []string) FreqMap {
//
//	var wg sync.WaitGroup
//	c := make(chan FreqMap, len(texts))
//
//	for _, t := range texts {
//		wg.Go(func() {
//			c <- Frequency(t)
//		})
//	}
//
//	wg.Wait()
//	close(c)
//
//	frequencies := FreqMap{}
//	for f := range c {
//		for k, v := range f {
//			frequencies[k] = v + frequencies[k]
//		}
//	}
//
//	return frequencies
//}

//func ConcurrentFrequencyDummy(texts []string) FreqMap {
//	frequenciesArray := []FreqMap{}
//	for _, t := range texts {
//		frequenciesArray = append(frequenciesArray, Frequency(t))
//	}
//
//	frequencies := FreqMap{}
//	for _, f := range frequenciesArray {
//		for k, v := range f {
//			frequencies[k] = v + frequencies[k]
//		}
//	}
//
//	return frequencies
//}
