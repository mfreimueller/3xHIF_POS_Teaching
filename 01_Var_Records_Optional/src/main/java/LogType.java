public enum LogType {
    WARNING('w', "This is a warning"),
    ERROR('e', "This is an error."),
    INFO('i'),
    CRITICAL('c', "This is bad.");

    private char dbValue;
    private String description;

    LogType(char dbValue, String description) {
        this.dbValue = dbValue;
        this.description = description;
    }

    LogType(char dbValue) {
        this.dbValue = dbValue;
        this.description = "Value = " + dbValue;
    }

    public char getDbValue() {
        return dbValue;
    }

    public String getDescription() {
        return description;
    }
}
