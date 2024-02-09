package ${basePackage}.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * 动态文件生成
 */
public class DynamicGenerator {

    public static void doGenerator(String inputPath, String outputPath, Object model) throws Exception {
        //1.创建配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        //指定数字格式，不使用逗号分隔符
        configuration.setNumberFormat("0.######");
        //2.设置模板所在的目录
        File templatesDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templatesDir);
        //3.设置字符集
        configuration.setDefaultEncoding("utf-8");
        //4.加载模板
        Template template = configuration.getTemplate(new File(inputPath).getName());
        //5.判断文件是否存在
        if (!FileUtil.exist(outputPath)) {
            //如果不存在创建空文件
            FileUtil.touch(outputPath);
        }
        //6.创建Writer对象
        Writer out = new FileWriter(outputPath);
        //7.输出
        template.process(model, out);
        //8.关闭Writer对象
        out.close();
    }
}
