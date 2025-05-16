import java.time.LocalTime;

abstract class ClockHand {
    public abstract void setTime(LocalTime Ltime);
    public abstract String toSvg();
}
