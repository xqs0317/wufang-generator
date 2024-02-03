package com.xqs.generator;

import com.xqs.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class DynamicGenerator {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String templatesPath = projectPath + File.separator + "wufang-generator-basic" + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates";
        String inputPath = templatesPath + File.separator + "MainTemplate.java.ftl";
        String outputPath = templatesPath + File.separator + "MainTemplate.java";
        MainTemplateConfig config = new MainTemplateConfig();
        config.setLoop(true);
        config.setOutPutText("输出结果为：");
        doGenerator(inputPath,outputPath,config);
    }

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
        //6.创建Writer对象
        Writer out = new FileWriter(outputPath);
        //7.输出
        template.process(model, out);
        //8.关闭Writer对象
        out.close();
    }
}
