package com.gmdb.team5.pf7project.domain;

public enum Rating {
    one(1),two(2),three(3),four(4),five(5);

    private final int star;

    Rating(int star) {
        this.star = star;
    }

    public int getStar() {
        return this.star;
    }
}
