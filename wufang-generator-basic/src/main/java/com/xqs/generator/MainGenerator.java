package com.xqs.generator;

import com.xqs.model.MainTemplateConfig;

import java.io.File;

public class MainGenerator {
    public static void main(String[] args) throws Exception {
        //1.静态文件生成
        String projectPath = System.getProperty("user.dir");
        String srcPath = projectPath + File.separator + "demos" + File.separator + "acm-template";
        String descPath = projectPath;
        StaticGenerator.copyFilesByRecursion(new File(srcPath), new File(descPath));
        //2.动态模板替换
        String templatesPath = projectPath + File.separator + "wufang-generator-basic" + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates";
        String inputPath = templatesPath + File.separator + "MainTemplate.java.ftl";
        String outputPath = descPath + File.separator + "acm-template" + File.separator +
                "src" + File.separator + "com" + File.separator + "yupi" + File.separator + "acm"
                + File.separator + "MainTemplate.java";
        MainTemplateConfig config = new MainTemplateConfig();
        config.setAuthor("xqs");
        config.setLoop(false);
        config.setOutPutText("输出结果为：");
        DynamicGenerator.doGenerator(inputPath, outputPath, config);
    }
}
