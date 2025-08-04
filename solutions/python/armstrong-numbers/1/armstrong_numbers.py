def is_armstrong_number(number):
    strNum = str(number)
    return sum(int(i) ** len(strNum) for i in list(strNum)) == number
