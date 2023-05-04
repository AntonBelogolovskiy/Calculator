package ru.hector.calculator;

public enum Roman {
    NULL(0),
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    private final int index;

    Roman(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}
