/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 6/17/14
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Poker {
    private final Kind kind;
    private final int number    ;

    public Poker(Kind kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Kind getKind() {
        return kind;
    }

    public enum Kind {DIAMOND, CLUB, SPADE, HEART}
}
