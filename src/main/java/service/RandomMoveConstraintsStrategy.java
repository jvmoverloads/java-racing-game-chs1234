package service;

public class RandomMoveConstraintsStrategy implements Movable {

    private static final int CONSTRAINTS = 4;

    @Override
    public boolean canMove() {
        return (int) (Math.random() * 10) >= CONSTRAINTS;
    }
}
