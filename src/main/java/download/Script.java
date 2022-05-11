package download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Script {
    static final String[] consonant = {"b", "p", "m", "f", "d", "t", "n", "l", "g", "k", "h", "j", "q", "x", "zh", "ch", "sh", "r", "z", "c", "s", "y", "w"};
    static final String[] phoneme = {"a", "o", "e", "i", "u", "v", "ai", "ei", "ui", "ao", "ou", "iu", "ie", "ve", "er", "an", "en", "in", "un", "vn", "ang", "eng", "ing", "ong"};
    static final String[] integral = {"zhi", "chi", "shi", "ri", "zi", "ci", "si", "yi", "wu", "yu", "ye", "yue", "yuan", "yin", "yun", "ying"};
    static final String[] a1 = {"a1", "a2", "a3", "a4", "o1", "o2", "o3", "o4", "e1", "e2", "e3", "e4", "i1", "i2", "i3", "i4", "u1", "u2", "u3", "u4", "v1", "v2", "v3", "v4"};
    static final String[] a2 = {"ai1", "ai2", "ai3", "ai4", "ei1", "ei2", "ei3", "ei4", "ui1", "ui2", "ui3", "ui4", "ao1", "ao2", "ao3", "ao4", "ou1", "ou2", "ou3", "ou4", "iu1", "iu2", "iu3", "iu4", "ie1", "ie2", "ie3", "ie4", "ve1", "ve2", "ve3", "ve4", "er1", "er2", "er3", "er4"};
    static final String[] a3 = {"an1", "an2", "an3", "an4", "en1", "en2", "en3", "en4", "in1", "in2", "in3", "in4", "un1", "un2", "un3", "un4", "vn1", "vn2", "vn3", "vn4", "ang1", "ang2", "ang3", "ang4", "eng1", "eng2", "eng3", "eng4", "ing1", "ing2", "ing3", "ing4", "ong1", "ong2", "ong3", "ong4"};
    static final String[] a4 = {"zhi1", "zhi2", "zhi3", "zhi4", "chi1", "chi2", "chi3", "chi4", "shi1", "shi2", "shi3", "shi4", "ri1", "ri2", "ri3", "ri4", "zi1", "zi2", "zi3", "zi4", "ci1", "ci2", "ci3", "ci4", "si1", "si2", "si3", "si4", "yi1", "yi2", "yi3", "yi4", "wu1", "wu2", "wu3", "wu4", "yu1", "yu2", "yu3", "yu4", "ye1", "ye2", "ye3", "ye4", "yue1", "yue2", "yue3", "yue4", "yuan1", "yuan2", "yuan3", "yuan4", "yin1", "yin2", "yin3", "yin4", "yun1", "yun2", "yun3", "yun4", "ying1", "ying2", "ying3", "ying4"};
    static final String[] a5 = {"ua", "ua1", "ua2", "ua3", "ua4", "uo", "uo1", "uo2", "uo3", "uo4", "ia", "ia1", "ia2", "ia3", "ia4", "van", "van1", "van2", "van3", "van4", "uai", "uai1", "uai2", "uai3", "uai4", "uan", "uan1", "uan2", "uan3", "uan4", "ian", "ian1", "ian2", "ian3", "ian4", "iao", "iao1", "iao2", "iao3", "iao4", "uang", "uang1", "uang2", "uang3", "uang4", "iang", "iang1", "iang2", "iang3", "iang4", "iong", "iong1", "iong2", "iong3", "iong4"};

    public static void main(String[] args) {
        try {
            String url;
            URI map3Url;
            for (String s : a5) {
                url = String.format("https://pinyin-10039060.file.myqcloud.com/%s.mp3", s);
                map3Url = new URI(url);
                downloadMap3(map3Url);
                Thread.sleep(500L);
            }
            System.out.println("完成");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void downloadMap3(URI mapUrl) {
        InputStream in = null;
        FileOutputStream fs = null;
        try {
            URL url = new URL(mapUrl.toString());
            URLConnection connection = url.openConnection();
            in = connection.getInputStream();
            File file = new File("./mp3" + mapUrl.getPath());
            //file.deleteOnExit();

            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            fs = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                fs.write(buffer, 0, length);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
