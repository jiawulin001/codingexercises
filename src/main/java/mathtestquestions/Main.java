package mathtestquestions;

public class Main {

    public static void main(String[] args) {
        int num1, num2, num3, opt1, opt2, sum, zeorCount = 0;

        for (int i = 0; i < 20; ) {
            num1 = getRandom(20);
            num2 = getRandom(20);
            num3 = getRandom(20);
            opt1 = getRandom(2);
            opt2 = getRandom(2);
            sum = opt1 == 0 ? num1 + num2 : num1 - num2;
            if (sum < 0 || sum > 20) {
                continue;
            }
            sum = opt2 == 0 ? sum + num3 : sum - num3;
            if (sum > 0 && sum <= 20) {
                if (num1 == 0 || num2 == 0 || num3 == 0) {
                    zeorCount++;
                    if (zeorCount > 2) {
                        continue;
                    }
                }

                System.out.printf("%d %s %d %s %d = %d \n", num1, opt1 == 0 ? "+" : "-", num2, opt2 == 0 ? "+" : "-", num3, sum);
                i++;
            }
        }
    }

    private static int getRandom(int num) {
        return (int) (Math.random() * num);
    }
}
