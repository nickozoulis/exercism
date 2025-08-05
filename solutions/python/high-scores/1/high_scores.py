class HighScores:
    def __init__(self, scores):
        self.scores = scores

    def latest(self):
        if len(self.scores) != 0:
            [elem] = self.scores[-1:]
            return elem
        return None

    def personal_best(self):
        if len(self.scores) != 0:
            return sorted(self.scores, reverse=True)[0]

        return None

    def personal_top_three(self):
        if len(self.scores) != 0:
            return sorted(self.scores, reverse=True)[:3]

        return None

