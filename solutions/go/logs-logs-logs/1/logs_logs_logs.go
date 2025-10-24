package logs

import "unicode/utf8"

var logs = map[rune]string{
	'❗': "recommendation",
	'🔍': "search",
	'☀': "weather",
}

// Application identifies the application emitting the given log.
func Application(log string) string {
	for _, v := range log {
		if _, ok := logs[v]; ok {
			return logs[v]
		}
	}
	return "default"
}

// Replace replaces all occurrences of old with new, returning the modified log
// to the caller.
func Replace(log string, oldRune, newRune rune) string {
	r := []rune(log)
	for i, v := range r {
		if v == oldRune {
			r[i] = newRune
		}
	}
	return string(r)
}

// WithinLimit determines whether or not the number of characters in log is
// within the limit.
func WithinLimit(log string, limit int) bool {
	return utf8.RuneCountInString(log) <= limit
}
