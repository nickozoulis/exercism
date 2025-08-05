import string

def abbreviate(words):
    words_list = list(words.replace('-',' '))
    cleaned = ''.join([l for l in words_list if l not in string.punctuation])
    return ''.join([l.upper()[0] for l in cleaned.split(' ') if l not in [' ', '']])

