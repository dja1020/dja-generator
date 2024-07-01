import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


public class FreeMakerTest {
    @Test
    public void test() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
//        指定模版文件所在的路径
        try {
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configuration.setDefaultEncoding("UTF-8");
//        创建模版对象 加载模版
        Template template = configuration.getTemplate("xxx");

//        创建数据模型
        Map<String,Object> dataMap = new HashMap<String,Object>();

        dataMap.put("currentYear",2023);

        Writer out  = new FileWriter("myweb.html");

        template.process(dataMap,out);
//        关闭生成文件
        out.close();

    }
}
