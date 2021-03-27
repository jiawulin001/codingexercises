package od;

public class Main21 {

    public static void main(String[] args) {
        Long max = 562949953421312L;
        int zmCount = 2;
        System.out.println(count(max, zmCount));
    }


    private static int count(Long max, int zmCount) {
        Long zmLength = (long) (Math.pow(26, zmCount));
        int count = 1;

        if (zmLength >= max) {
            return 1;
        }

        while (Math.pow(10, count) * zmLength < max) {
            count++;
        }

        return count;
    }
}

