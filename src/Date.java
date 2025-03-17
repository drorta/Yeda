public record Date(int day, Month month, int year) {

    public boolean isBiggerThan(Date other) {
        if (this.year > other.year) {
            return true;
        } else if (this.year < other.year) {
            return false;
        }

        if (this.month.getNumeral() > other.month.getNumeral()) {
            return true;
        } else if (this.month.getNumeral() < other.month.getNumeral()) {
            return false;
        }

        return this.day > other.day;
    }

    public int differenceFrom(Date other) {
        int days1 = toDays(this);
        int days2 = toDays(other);

        return Math.abs(days1 - days2);
    }

    private int toDays(Date date) {
        int totalDays = 0;

        for (int y = 0; y < date.year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 0; m < date.month.ordinal(); m++) {
            Month currentMonth = Month.values()[m];
            totalDays += currentMonth.getDays(isLeapYear(date.year));
        }

        totalDays += date.day;

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}