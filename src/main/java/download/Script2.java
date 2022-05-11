package download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Script2 {

    private static final String[][] mp4UrlSets = {{"一年级小学英语下册第一单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/a9a7b62add2841f4b8cf1c7d4b7b9f28.mp4"},
            {"一年级小学英语下册第一单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/db7201d9b1934d1e946e68a7f8ad6077.mp4"},
            {"一年级小学英语下册第一单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/9473eae65c39440fbce224628179fe06.mp4"},
            {"一年级小学英语下册第一单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/04536a6043f24bcdb2fd8222ba0aa6eb.mp4"},
            {"一年级小学英语下册第一单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/f040ca3be9384953a5fc623774849f44.MP4"},
            {"一年级小学英语下册第七单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/a23468d0637c486db74e69599596c176.mp4"},
            {"一年级小学英语下册第七单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/967a1cce81a6461d9e600f70386db471.mp4"},
            {"一年级小学英语下册第七单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/4eb676b1d0964d5e842c9141effe0ba8.mp4"},
            {"一年级小学英语下册第七单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/f8ade10ddbec440d837a3817b61e9d8c.mp4"},
            {"一年级小学英语下册第七单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/05f91452e58f46c5bb55ebeb00c54f5f.mp4"},
            {"一年级小学英语下册第三单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/8a558e8af85f425b8f389452917beb58.mp4"},
            {"一年级小学英语下册第三单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/54a6d15620574bbbae8d61c23e105abb.mp4"},
            {"一年级小学英语下册第三单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/ec14e506dc834e7d99b196a549069535.mp4"},
            {"一年级小学英语下册第三单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/99702480955543268d5e39ddfdc22b0f.mp4"},
            {"一年级小学英语下册第三单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/365f8933a84f489ab177b4672c06676c.mp4"},
            {"一年级小学英语下册第九单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/f39c6653d56b4b7c9bfe5f8df699fddc.mp4"},
            {"一年级小学英语下册第九单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/4d26e0f08953416293f7668825a68947.mp4"},
            {"一年级小学英语下册第九单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/4fe832329fa64050b4eed39909fc893e.mp4"},
            {"一年级小学英语下册第九单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/4d19196cf396455983a307a355fa308e.mp4"},
            {"一年级小学英语下册第九单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/d9ac581eb4e7467992cd069673af0b0a.mp4"},
            {"一年级小学英语下册第二单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/01a14d63094b4bd2beabc613545ae436.mp4"},
            {"一年级小学英语下册第二单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/329e4be1faf84f128e2f1ddba9596274.mp4"},
            {"一年级小学英语下册第二单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/50a90ec22b3c4ff2bfad8cbf0fc02dca.mp4"},
            {"一年级小学英语下册第二单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/5da0d8672d3f4b29bae6ef41d43871ee.mp4"},
            {"一年级小学英语下册第二单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/57eb38ceda28430f87a0e31b38537d5c.mp4"},
            {"一年级小学英语下册第五单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/702538aad79f4e559eeaec1f2c49ddec.mp4"},
            {"一年级小学英语下册第五单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/316b3421c24a41d4a3d66e134e72dac9.mp4"},
            {"一年级小学英语下册第五单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/94320ea0a16b419babbed2ae72d479c0.mp4"},
            {"一年级小学英语下册第五单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/d8764bb5c3574346922597204a7bbd29.mp4"},
            {"一年级小学英语下册第五单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/06ddbe2a46c74774946fa2cb8afef879.mp4"},
            {"一年级小学英语下册第八单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/113be60d9b3f4e3cb032c5b1d14d1da6.mp4"},
            {"一年级小学英语下册第八单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/72f12869a02f495c89acb2337f7667f2.mp4"},
            {"一年级小学英语下册第八单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/aae3bf5ac0244814acbc05271e74ef1f.mp4"},
            {"一年级小学英语下册第八单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/8984087591534ee28716824fbe8108bb.mp4"},
            {"一年级小学英语下册第八单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/41b103635007458a8eeca9a592bd1a17.mp4"},
            {"一年级小学英语下册第六单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/33993ceae4414141a9807bd5a46a3e34.mp4"},
            {"一年级小学英语下册第六单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/586b3f3ee1e14343a856a7ac75e96431.mp4"},
            {"一年级小学英语下册第六单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/971b1d3e55294d989886e32ff009cbc9.mp4"},
            {"一年级小学英语下册第六单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/487f0804b3cd42e5b906cb3481ce9949.mp4"},
            {"一年级小学英语下册第六单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/5804e3a6e05b4b55a0a709b76112e584.mp4"},
            {"一年级小学英语下册第十一单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/0b4f177bbb2a433f957eac330ac89abd.mp4"},
            {"一年级小学英语下册第十一单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/d16402937233427582d9fa74e15c9cd6.mp4"},
            {"一年级小学英语下册第十一单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/7e040c4ee96a4c149bc002fc3d268eee.mp4"},
            {"一年级小学英语下册第十一单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/ab9cca76e5594d4694af601485ff0261.mp4"},
            {"一年级小学英语下册第十一单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/32e4f0c366194186a10809c7df9c2b34.mp4"},
            {"一年级小学英语下册第十二单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/279b7b18004c425f8a649e8ce5ae3723.mp4"},
            {"一年级小学英语下册第十二单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/195b5abeaa55405b997fd7663989eb2c.mp4"},
            {"一年级小学英语下册第十二单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/aae81cc9e0e3456cbad641d099ee9d9f.mp4"},
            {"一年级小学英语下册第十二单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/3b115142d89744e9b195b35a40877100.mp4"},
            {"一年级小学英语下册第十二单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/24b524f336194d5786d16a3040761af4.mp4"},
            {"一年级小学英语下册第十单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/14e624aadc2e45b8b2e051ae0ed7b2da.mp4"},
            {"一年级小学英语下册第十单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/90737e2c62da4e04b90630b0ef36243e.mp4"},
            {"一年级小学英语下册第十单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/f4bf9b40597c493287a4f69a2648f63b.mp4"},
            {"一年级小学英语下册第十单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/e33202c4ad6c4dbda037813107016681.mp4"},
            {"一年级小学英语下册第十单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/f1959fb1e4c24a7d8245e99d480adc32.mp4"},
            {"一年级小学英语下册第四单元第一课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/2147e2334a894d20bb3f314878042025.mp4"},
            {"一年级小学英语下册第四单元第三课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/1dc563dbd84049a2a35838bbe9611cbc.mp4"},
            {"一年级小学英语下册第四单元第二课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/85cb7ddcfbf6431b927f2b36cd20635f.mp4"},
            {"一年级小学英语下册第四单元第五课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/30bf395fcd3e45969f47cb1d556ad505.mp4"},
            {"一年级小学英语下册第四单元第四课时", "https://vod-origin-0rcj.gdoss.xstore.ctyun.cn/a9a23fe65dd54ef0a23422710fafcc81.mp4"}};


    public static void main(String[] args) {
        try {
            URI map3Url;
            for (String[] vod : mp4UrlSets) {
                map3Url = new URI(vod[1]);
                downloadMap4(vod[0], map3Url);
                Thread.sleep(500L);
            }
            System.out.println("完成");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void downloadMap4(String fileName, URI mapUrl) {
        InputStream in = null;
        FileOutputStream fs = null;
        try {
            URL url = new URL(mapUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Host", "vod-origin-0rcj.gdoss.xstore.ctyun.cn");
            connection.setRequestProperty("Referer", "https://zy.szedu.cn/");
            connection.connect();
            in = connection.getInputStream();
            File file = new File("./mp4/" + fileName + ".mp4");

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
