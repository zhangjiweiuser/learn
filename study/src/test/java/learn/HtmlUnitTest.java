package learn;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/22 10:05
 */
public class HtmlUnitTest {
    public void homPage() throws Exception {
        try (final WebClient webClient = new WebClient(BrowserVersion.getDefault())) {
            webClient.setJavaScriptTimeout(500000);

            webClient.getOptions().setUseInsecureSSL(true);//接受任何主机连接 无论是否有有效证书
            webClient.getOptions().setJavaScriptEnabled(true);//设置支持javascript脚本
            webClient.getOptions().setCssEnabled(false);//禁用css支持
            webClient.getOptions().setThrowExceptionOnScriptError(false);//js运行错误时不抛出异常
            webClient.getOptions().setTimeout(100000);//设置连接超时时间
            webClient.getOptions().setDoNotTrackEnabled(false);// 不跟踪抓取

            //设置Ajax异步处理控制器即启用Ajax支持
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
//            webClient.getOptions().setDoNotTrackEnabled(false);// 不跟踪抓取

//            WebRequest request=new WebRequest(new URL(""));
//            request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:62.0) Gecko/20100101 Firefox/62.0");
//            request.setAdditionalHeader("Cookie","PLAY_LANG=cn; _plh=b9289d0a863a8fc9c79fb938f15372f7731d13fb; PLATFORM_SESSION=39034d07000717c664134556ad39869771aabc04-_ldi=520275&_lsh=8cf91cdbcbbb255adff5cba6061f561b642f5157&csrfToken=209f20c8473bc0518413c226f898ff79cd69c3ff-1539926671235-b853a6a63c77dd8fcc364a58&_lpt=%2Fcn%2Fvehicle_sales%2Fsearch&_lsi=1646321; _ga=GA1.2.2146952143.1539926675; _gid=GA1.2.1032787565.1539926675; _plh_notime=8cf91cdbcbbb255adff5cba6061f561b642f5157");
//            System.out.println(page.getTitleText());
            HtmlPage page = null;
            try {
                page = webClient.getPage("https://uland.taobao.com/taolijin/edetail?vegasCode=X7F4DKVI&type=qtz&union_lens=lensId%3A21076e08_09a0_1772e8fd43b_49bf%3Btraffic_flag%3Dlm");
                page.onAllChildrenAddedToPage(true);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                webClient.close();
            }

//            webClient.waitForBackgroundJavaScript(5 * 1000);// 等待js时间
//            System.out.println("抓取到的页面内容为：" + page.asXml());
            webClient.waitForBackgroundJavaScript(30000);// 等待js时间

            HtmlElement element = page.getBody();
            ScriptResult result = page.executeJavaScript("window.variableMap");
            String str = result.getJavaScriptResult().toString();
            List<HtmlElement> childElement = element.getElementsByAttribute("a", "class", "product-info-detail");
            if (childElement.size() > 0) {
                HtmlElement a = childElement.get(0);
                HtmlPage page2 = a.click();
                System.out.println(page2.asXml());
            }

//            HtmlInput button2=(HtmlInput) page.getElementById("J_wrap");
//
//            //模拟点击“百度一下”按钮
//            HtmlPage page2=button2.click();
//            System.out.println(page2.asXml());

        }
    }

    public static void main(String[] args) {
        try {
            new HtmlUnitTest().homPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
