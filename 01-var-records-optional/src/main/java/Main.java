import java.time.LocalDate;

void main() {
    // Create a record just like any other instance
    // of a 'regular' class
    Animal animal = new Animal(
        "Rex",
        3,
        AnimalType.DOG,
        LocalDate.now()
    );

    // Note that there are only getters, no setters
    var shelterCode = animal.type().getShelterCode();

    var repository = new AnimalShelterRepository();
    var newestArrival = repository.findNewestArrival();

    // ifPresent executes the lambda expression
    // iff (if and only if) there is an Animal-instance
    // present in the optional that is returned
    // (the optional in newestArrival)
    newestArrival.ifPresent(a -> System.out.println(a));

    // This is what a lambda expression actually
    // is - an anonymous class of type 'Consumer'
    // taking an instance of type 'Animal'
    // ifPresent calls the accept method.
    // So "a -> System.out.println(a)" gets converted
    // into this code
//    newestArrival.ifPresent(new Consumer<Animal>() {
//        @Override
//        public void accept(Animal animal) {
//            System.out.println(animal);
//        }
//    });

    // This is a shorthand version for the stuff above
    // basically this gets converted to:
    // a -> System.out.println(a)
    // Explanation: It calls the println method
    // on the System.out instance (that's the point
    // of the :: -> this says: 'call println on the
    // object System.out).
//    newestArrival.ifPresent(System.out::println);

    var availableRabbit = repository.findAvailableRabbit();
    availableRabbit.ifPresent(a -> System.out.println(a));

    var enclosure = switch(animal.type()) {
        case AnimalType.RABBIT, AnimalType.PARROT -> "small enclosure";
        case AnimalType.CAT -> "medium enclosure";
        case AnimalType.DOG -> "large enclosure";
        default -> "This shouldn't happen.";
    };
    System.out.println("Which enclosure does the animal need? " + enclosure);
}
