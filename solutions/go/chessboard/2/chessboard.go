package chessboard

// Declare a type named File which stores if a square is occupied by a piece - this will be a slice of bools
type File []bool

func countFiles(f File) int {
	cnt := 0
	for _, v := range f {
		if v {
			cnt++
		}
	}
	return cnt
}

// Declare a type named Chessboard which contains a map of eight Files, accessed with keys from "A" to "H"
type Chessboard map[string]File

// CountInFile returns how many squares are occupied in the chessboard,
// within the given file.
func CountInFile(cb Chessboard, file string) int {
	if fileValue, fileExists := cb[file]; fileExists {
		return countFiles(fileValue)
	} else {
		return 0
	}
}

// CountInRank returns how many squares are occupied in the chessboard,
// within the given rank.
func CountInRank(cb Chessboard, rank int) int {
	cnt := 0
	if rank >= 1 && rank <= 8 {
		for _, file := range cb {
			if file[rank-1] {
				cnt++
			}
		}
	}
	return cnt
}

// CountAll should count how many squares are present in the chessboard.
func CountAll(cb Chessboard) int {
	cnt := 0
	for _, v := range cb {
		for range v {
			cnt++
		}
	}
	return cnt
}

// CountOccupied returns how many squares are occupied in the chessboard.
func CountOccupied(cb Chessboard) int {
	cnt := 0
	for _, v := range cb {
		cnt += countFiles(v)
	}
	return cnt
}
