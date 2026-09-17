public enum AnimalType {
    DOG('d', "Loyal and energetic companion."),
    CAT('c', "Independent and curious feline."),
    RABBIT('r'),
    PARROT('p', "Talkative and colorful bird.");

    private final char shelterCode;
    private final String description;

    AnimalType(char shelterCode, String description) {
        this.shelterCode = shelterCode;
        this.description = description;
    }

    AnimalType(char shelterCode) {
        this.shelterCode = shelterCode;
        this.description = "No description available.";
    }

    public char getShelterCode() {
        return shelterCode;
    }

    public String getDescription() {
        return description;
    }
}
