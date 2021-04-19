package by.gsu.epamlab;

public final class Byn implements Comparable<Byn> {
    private final int kopecks;

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn(int rubs, int kopecks) {
        this(rubs * 100 + kopecks);
    }

    public Byn addition(Byn byn) {
        return new Byn(this.kopecks + byn.kopecks);
    }

    public Byn subtraction(Byn byn) {
        return new Byn(this.kopecks - byn.kopecks);
    }

    public Byn multiply(double k) {
        return new Byn((int) (this.kopecks * k));
    }

    public Byn multiply(double k, RoundMethod roundMethod, int roundDigit) {
        return new Byn(roundMethod.rounding(this.kopecks * k, roundDigit));
    }

    public Byn round(RoundMethod roundMethod, int roundDigit) {
        return new Byn(roundMethod.rounding(this.kopecks, roundDigit));
    }

    @Override
    public String toString() {
        return kopecks / 100 + "." + kopecks % 100 / 10 + kopecks % 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Byn)) return false;
        Byn byn = (Byn) obj;
        return kopecks == byn.kopecks;
    }

    @Override
    public int compareTo(Byn byn) {
        return kopecks - byn.kopecks;
    }

}

