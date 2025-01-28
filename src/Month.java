public enum Month {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int numeral;
    private final int days;

    Month(int numeral, int days) {
        this.numeral = numeral;
        this.days = days;
    }

    public int getNumeral() {
        return numeral;
    }

    public int getDays(boolean isLeapYear) {
        if (this == FEBRUARY && isLeapYear) {
            return 29;
        }
        return days;
    }
}
