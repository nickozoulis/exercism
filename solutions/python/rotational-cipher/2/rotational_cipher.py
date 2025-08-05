alphabet = 'abcdefghijklmnopqrstuvwxyz'
alphabet_capital = alphabet.upper()

def rotate(text, key):

    return ''.join([__transpose(letter, key) for letter in list(text)])

def __transpose(letter, key):

    if letter in alphabet:
        return alphabet[(alphabet.find(letter) + key) % 26]
    elif letter in alphabet_capital:
        return alphabet_capital[(alphabet_capital.find(letter) + key) % 26]
    else:
        return letter

