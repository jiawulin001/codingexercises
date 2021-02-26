package nowcoder.hj87;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
        //int size = System.in.available();
        int chr;
        int grades;

        int pwdSize = 0;
        int upLetterTotal = 0;
        int lowLetterTotal = 0;
        int numberTotal = 0;
        int symbolTotal = 0;

        while (true) {
            chr = System.in.read();
            if (-1 == chr) {
                break;
            }

            if ('\r' == chr || '\n' == chr) {
                if (pwdSize == 0) {
                    continue;
                }

                grades = 0;

                if (pwdSize <= 4) {
                    grades += 5;
                } else if (pwdSize >= 5 && pwdSize <= 7) {
                    grades += 10;
                } else {
                    grades += 25;
                }

                if (upLetterTotal > 0 && lowLetterTotal > 0) {
                    grades += 20;
                } else if (upLetterTotal > 0 || lowLetterTotal > 0) {
                    grades += 10;
                }

                if (numberTotal == 1) {
                    grades += 10;
                } else if (numberTotal > 1) {
                    grades += 20;
                }

                if (symbolTotal == 1) {
                    grades += 10;
                } else if (symbolTotal > 1) {
                    grades += 25;
                }

                if (lowLetterTotal > 0 && upLetterTotal > 0 && numberTotal > 0 && symbolTotal > 0) {
                    grades += 5;
                } else if ((lowLetterTotal + upLetterTotal) > 0 && numberTotal > 0 && symbolTotal > 0) {
                    grades += 3;
                } else if ((lowLetterTotal + upLetterTotal) > 0 && numberTotal > 0) {
                    grades += 2;
                }

                pwdSize = 0;
                upLetterTotal = 0;
                lowLetterTotal = 0;
                numberTotal = 0;
                symbolTotal = 0;

                if (grades >= 90) {
                    System.out.println("VERY_SECURE");
                } else if (grades >= 80) {
                    System.out.println("SECURE");
                } else if (grades >= 70) {
                    System.out.println("VERY_STRONG");
                } else if (grades >= 60) {
                    System.out.println("STRONG");
                } else if (grades >= 50) {
                    System.out.println("AVERAGE");
                } else if (grades >= 25) {
                    System.out.println("WEAK");
                } else {
                    System.out.println("VERY_WEAK");
                }
                continue;
            }

            if (('!' <= chr && '/' >= chr)
                    || (':' <= chr && '@' >= chr)
                    || ('[' <= chr && '`' >= chr)
                    || ('{' <= chr && '~' >= chr)) {
                symbolTotal++;
            } else if ('a' <= chr && 'z' >= chr) {
                lowLetterTotal++;
            } else if ('A' <= chr && 'Z' >= chr) {
                upLetterTotal++;
            } else if ('0' <= chr && '9' >= chr) {
                numberTotal++;
            }

            pwdSize++;
        }
    }

}
