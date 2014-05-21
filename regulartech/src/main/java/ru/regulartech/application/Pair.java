package regularTech;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 13:49
 */
public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
