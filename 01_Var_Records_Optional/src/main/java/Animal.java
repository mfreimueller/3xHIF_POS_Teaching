import java.time.LocalDate;

/**
 *
 * @param name The animal's name.
 * @param age The animal's age in years.
 * @param type What kind of animal it is.
 * @param arrivalDate When the animal arrived at the shelter.
 */
public record Animal(String name,
                      int age,
                      AnimalType type,
                      LocalDate arrivalDate) {

}
