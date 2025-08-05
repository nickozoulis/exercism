class Allergies:

    allergies = {
        1: "eggs", 2: "peanuts", 4: "shellfish",
        8: "strawberries", 16: "tomatoes", 32: "chocolate",
        64: "pollen", 128: "cats"
    }

    def __init__(self, score):
        self.score = score - 256 if score >= 256 else score
        self.lst_allergies = self._compute_allergies(self.score)

    def allergic_to(self, item):
        return item in self.lst_allergies

    @property
    def lst(self):
        return self.lst_allergies

    def _compute_allergies(self, score):
        lst = []

        for k in sorted(Allergies.allergies.keys(), reverse= True):
            if 0 < k <= score:
                score -= k
                lst.append(Allergies.allergies.get(k))

        return lst
