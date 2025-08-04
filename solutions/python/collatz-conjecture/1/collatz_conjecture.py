def steps(number, cnt = 0):
    if number <= 0: raise ValueError("Only positive integers are allowed")

    if number == 1: return cnt

    if number % 2 == 0: return steps(number / 2, cnt + 1)
    else: return steps(number * 3 + 1, cnt + 1)

