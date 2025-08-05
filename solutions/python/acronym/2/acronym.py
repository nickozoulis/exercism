import string

def abbreviate(words):
    cleaned = ''.join([l for l in list(words.replace('-',' ')) if l not in string.punctuation])
    return ''.join([l.upper()[0] for l in cleaned.split(' ') if l not in [' ', '']])

