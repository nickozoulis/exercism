def translate(text):
    return ' '.join([__process(word) for word in text.split(' ')])

def __process(text):
    if text.startswith('xr') or text.startswith('yt') or text.startswith('ay') or __is_vowel(text[0]):
        return text + "ay"

    if not __is_vowel(text[0]):
        prefix = ''
        suffix = ''
        for index,letter in enumerate(text):
            if not __is_vowel(letter) and letter != 'y' :
                prefix = prefix + letter
            elif letter == 'y' and index == 0:
                prefix = 'y'
                suffix = text[index:]
            elif letter == 'u' and text[index - 1] == 'q':
                prefix = prefix + letter
                suffix = text[index + 1:]
                break
            else:
                suffix = text[index:]
                break

        if 'qu' in text:
            return suffix + prefix + 'ay'
        else:
            return suffix + prefix + 'ay'


def __is_vowel(letter):
    return letter in 'aeiou'
