import java.time.LocalDateTime;

/**
 *
 * @param ts The timestamp of the log event (when it happened).
 * @param message What actually happened.
 * @param logType What type of event happened.
 */
public record Log(LocalDateTime ts,
                  String message,
                  LogType logType) {

}
