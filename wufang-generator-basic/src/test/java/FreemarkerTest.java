import com.xqs.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FreemarkerTest {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String templatesPath = projectPath + File.separator + "wufang-generator-basic" + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates";
        //1.创建配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        //指定数字格式，不使用逗号分隔符
        configuration.setNumberFormat("0.######");
        //2.设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File(templatesPath));
        //3.设置字符集
        configuration.setDefaultEncoding("utf-8");
        //4.加载模板
        Template template = configuration.getTemplate("MainTemplate.java.ftl");
        //5.利用实体类创建数据模型
        MainTemplateConfig config = new MainTemplateConfig();
        config.setAuthor("松鼠");
        config.setLoop(true);
        config.setOutPutText("输出结果为：");
        //6.创建Writer对象
        Writer out = new FileWriter("MainTemplate.java");
        //7.输出
        template.process(config, out);
        //8.关闭Writer对象
        out.close();
    }
}
