package tools;

public class Random {
    public static int getValueWithoutRightBound(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static int getValueWithRightBound(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }
}



