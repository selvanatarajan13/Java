public class NumberImpl implements Number {
    @Override
    public Boolean hasTeen(int i1, int i2, int i3) {
        return isTeen(i1) || isTeen(i2) || isTeen(i3);
    }


    private Boolean isTeen(int value) {
        return value > 12 && value < 20;
    }

    @Override
    public Boolean equalSumChecker(int i1, int i2, int i3) {
        if (i1+i2 == i3) {
            return true;
        } else {
            return false;
        }
    }

}
