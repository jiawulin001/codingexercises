package nowcoder.hj33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main1(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = in.readLine()) != null) {
            System.out.println(ip2Number(str));
            System.out.println(number2IP(in.readLine()));
        }
    }

    //    1010 00000011 00000011 11000001
    private static String number2IP(String number) {
        String binString = Long.toBinaryString(Long.valueOf(number));
        int length = binString.length();
        Long number4 = Long.valueOf(binString.substring(length - 8, length), 2);
        Long number3 = Long.valueOf(binString.substring(length - 16, length - 8), 2);
        Long number2 = Long.valueOf(binString.substring(length - 24, length - 16), 2);
        Long number1 = 0L;
        if (length > 24) {
            number1 = Long.valueOf(binString.substring(0, length - 24), 2);
        }
        return String.format("%s.%s.%s.%s", number1, number2, number3, number4);
    }

    private static String number2IP1(String number) {
        String binString = ten2Bin(number);
        int length = binString.length();
        String number4 = bin2Ten(binString.substring(length - 8, length));
        String number3 = bin2Ten(binString.substring(length - 16, length - 8));
        String number2 = bin2Ten(binString.substring(length - 24, length - 16));
        String number1 = "0";
        if (length > 24) {
            number1 = bin2Ten(binString.substring(0, length - 24));
        }
        return String.format("%s.%s.%s.%s", number1, number2, number3, number4);
    }

    private static Long ip2Number(String str) {
        int[] nums = Arrays.stream(str.split("\\.")).mapToInt(Integer::valueOf).toArray();
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%08d", Integer.valueOf(Integer.toBinaryString(nums[0]))));
        sb.append(String.format("%08d", Integer.valueOf(Integer.toBinaryString(nums[1]))));
        sb.append(String.format("%08d", Integer.valueOf(Integer.toBinaryString(nums[2]))));
        sb.append(String.format("%08d", Integer.valueOf(Integer.toBinaryString(nums[3]))));
        return Long.valueOf(sb.toString(), 2);
    }

    private static String ip2Number1(String str) {
        String[] nums = str.split("\\.");
        StringBuffer sb = new StringBuffer();
        sb.append(fillZero(ten2Bin(nums[0])));
        sb.append(fillZero(ten2Bin(nums[1])));
        sb.append(fillZero(ten2Bin(nums[2])));
        sb.append(fillZero(ten2Bin(nums[3])));
        return bin2Ten(sb.toString());
    }

    private static String fillZero(String str) {
        int length = 8 - str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
    }


    private static String ten2Bin(String tenString) {
        //短除法
        if (tenString.length() >= 10) {
            BigInteger number = new BigInteger(tenString);
            StringBuffer sb = new StringBuffer();

            BigInteger[] temp;
            while (number.compareTo(BigInteger.ONE) != 1) {
                temp = number.divideAndRemainder(BigInteger.valueOf(2l));
                sb.append(temp[1].intValue());
                number = temp[0];
            }

            if (number.compareTo(BigInteger.ONE) == 0) {
                sb.append(number.intValue());
            }

            return sb.reverse().toString();
        }

        return Integer.toBinaryString(Integer.valueOf(tenString));
    }

    private static String ten2Bin1(String tenString) {
        Long num = Long.parseLong(tenString);
        StringBuffer sb = new StringBuffer();
        while (num >= 1) {
            sb.append(num % 2);
            num = num / 2;
        }
        if (num == 1) {
            sb.append(num);
        }
        return sb.reverse().toString();
    }

    private static String bin2Ten(String binString) {
        //按位求模
        int length = binString.length();
        if (length <= 31) {
            return Integer.valueOf(binString, 2).toString();
        }

        BigInteger bigInteger = new BigInteger("0");
        BigInteger temp;
        for (int i = 0; i < length; i++) {
            temp = BigInteger.valueOf(2l).pow(length - i - 1);
            temp = temp.multiply(binString.charAt(i) == '0' ? BigInteger.ZERO : BigInteger.ONE);
            bigInteger = bigInteger.add(temp);
        }

        return bigInteger.toString();
    }

    private static String bin2Ten1(String binString) {
        //按位求模
        int length = binString.length();
        Long num = 0L;
        for (int i = 0; i < length; i++) {
            num += Integer.parseInt(binString.charAt(i) + "") * (long) Math.pow(2, length - i - 1);
            //System.out.printf("2^%s=%s\n", length - i - 1, Math.pow(2, length - i - 1));
        }
        return num.toString();
    }

    public static void main(String[] args) {
        long num = 167969729; //1010000000110000001111000001

        System.out.println(Long.toBinaryString(num));
        System.out.printf("%s.%s.%s.%s\n", (num >> 24) & 255, (num >> 16) & 255, (num >> 8) & 255, num & 255);

        int[] ips = {10, 3, 3, 193};
        System.out.println((ips[0] << 24L) | (ips[1] << 16L) | (ips[2] << 8L) | (ips[3]));
    }

}
