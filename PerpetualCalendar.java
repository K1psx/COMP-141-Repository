//y=f(x)%7 for first sunday, ex: f(1)%7 = 0, f(2)%7 = 6
public class PerpetualCalendar {
    public static void main(String[] args) {
        int daysInMonth = 31;
        int firstSunday = 1;
        printCalendar(daysInMonth, firstSunday);
    }

    public static void printCalendar(int daysInMonth, int firstSunday) {
        System.out.println("  Sun    Mon    Tue    Wed    Thu    Fri    Sat");
        System.out.println("+------+------+------+------+------+------+------+");
        for (int i = 1; i < firstSunday; i++) {
            System.out.print("|" + padded(0, 6));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.print("|" + padded(day, 6));

            if ((day + firstSunday - 1) % 7 == 0) {
                System.out.println();
            }
        }

        int daysOnLastLine = (daysInMonth + firstSunday - 1) % 7;
        for (int i = daysOnLastLine; i < 7 && i != 0; i++) {
            System.out.print("|" + padded(0, 6));
        }
        System.out.println("|");

        System.out.println("+------+------+------+------+------+------+------+");
    }

    public static String padded(int n, int width) {
        String s = "" + n;
        for (int i = s.length(); i < width; i++) {
            s = " " + s;
        }
        return s;
    }
}
