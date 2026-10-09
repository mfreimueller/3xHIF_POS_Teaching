import java.time.LocalDate;
import java.util.Optional;

/**
 * Pretends to be a data source (e.g. a database) that
 * looks up animals currently living at the shelter.
 */
public class AnimalShelterRepository {

    public Optional<Animal> findNewestArrival() {
        return Optional.of(new Animal(
                "Luna",
                1,
                AnimalType.CAT,
                LocalDate.now()
        ));
    }

    public Optional<Animal> findAvailableRabbit() {
        return Optional.empty();
    }
}
