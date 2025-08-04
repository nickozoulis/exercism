public class GameMaster {

    public String describe(Character character) {
        return String.format("You're a level %d %s with %d hit points.", character.getLevel(), character.getCharacterClass(), character.getHitPoints());
    }

    public String describe(Destination destination) {
        return String.format("You've arrived at %s, which has %d inhabitants.", destination.getName(), destination.getInhabitants());
    }


    public String describe(TravelMethod travelMethod) {
        return switch (travelMethod) {
            case HORSEBACK -> String.format("You're traveling to your destination on %s.", travelMethod.name().toLowerCase());
            case WALKING -> String.format("You're traveling to your destination by %s.", travelMethod.name().toLowerCase());
        };
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }

    // TODO: define a 'describe' method that returns a description of a Character and Destination
    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }
}
