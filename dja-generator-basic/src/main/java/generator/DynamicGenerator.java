package generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.MainTemplateConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
//        指定模版文件所在的路径
        try {
            String projectPath = System.getProperty("user.dir")+File.separator+"dja-generator-basic";
            File parentFile = new File(projectPath);
            File file = new File(parentFile, "src/main/resources/templates");
//           指定模版文件所在位置
            configuration.setDirectoryForTemplateLoading(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configuration.setDefaultEncoding("UTF-8");
//        创建模版对象 加载模版
        Template template = configuration.getTemplate("MainTemplate.java.ftl");

//        创建数据模型
        MainTemplateConfig mainTemplateConfig= new MainTemplateConfig();
        mainTemplateConfig.setAuthor("abc");
        mainTemplateConfig.setOutputText("def");
        mainTemplateConfig.setLoop(false);
        Writer out  = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig,out);
//        关闭生成文件
        out.close();
    }
    public static void doGenerate(String inputPath, String outputPath, MainTemplateConfig mainTemplateConfig) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
//        指定模版文件所在的路径
        try {
            String projectPath = System.getProperty("user.dir")+File.separator+"dja-generator-basic";
            File parentFile = new File(projectPath);
            File file = new File(parentFile, "src/main/resources/templates");
//           指定模版文件所在位置
            configuration.setDirectoryForTemplateLoading(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configuration.setDefaultEncoding("UTF-8");
//        创建模版对象 加载模版
        Template template = configuration.getTemplate("MainTemplate.java");
        Writer out  = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig,out);
//        关闭生成文件
        out.close();
    }
}
