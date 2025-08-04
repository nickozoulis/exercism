class Darts {
    int score(double xOfDart, double yOfDart) {

        var dist = Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2);
        var score = 0;

        if (dist > 100) {
            score = 0;
        } else if (dist > 25) {
            score = 1;
        } else if (dist > 1) {
            score = 5;
        } else {
            score = 10;
        }

        return score;
    }
}
