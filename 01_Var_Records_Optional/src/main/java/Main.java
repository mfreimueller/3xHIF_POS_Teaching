void main() {
    // Create a record just like any other instance
    // of a 'regular' class
    Log log = new Log(
        LocalDateTime.now(),
        "A critical error occurred.",
        LogType.CRITICAL
    );

    // Note that there are only getters, no setters
    var dbValue = log.logType().getDbValue();

    var latestLogMessage = getLatestLogMessage();

    // ifPresent executes the lambda expression
    // iff (if and only if) there is a Log-instance
    // present in the optional that is returned
    // (the optional in latestLogMessage)
    latestLogMessage.ifPresent(l -> System.out.println(l));

    // This is what a lambda expression actually
    // is - an anonymous class of type 'Consumer'
    // taking an instance of type 'Log'
    // ifPresent calls the accept method.
    // So "l -> System.out.println(l)" gets converted
    // into this code
//    latestLogMessage.ifPresent(new Consumer<Log>() {
//        @Override
//        public void accept(Log log) {
//            System.out.println(log);
//        }
//    });

    // This is a shorthand version for the stuff above
    // basically this gets converted to:
    // l -> System.out.println(l)
    // Explanation: It calls the println method
    // on the System.out instance (that's the point
    // of the :: -> this says: 'call println on the
    // object System.out).
//    latestLogMessage.ifPresent(System.out::println);

    var latestWarningLogMessage = getLatestWarningLogMessage();
    latestWarningLogMessage.ifPresent(l -> System.out.println(l));

    var message = switch(log.logType()) {
        case LogType.INFO, LogType.WARNING -> "no";
        case LogType.ERROR -> "maybe";
        case LogType.CRITICAL -> "yes";
        default -> "This shouldn't happen.";
    };
    System.out.println("Do we need to care about the log? " + message);
}

Optional<Log> getLatestLogMessage() {
    return Optional.of(new Log(
            LocalDateTime.now(),
            "A critical error occurred.",
            LogType.CRITICAL
    ));
}

Optional<Log> getLatestWarningLogMessage() {
    return Optional.empty();
}

