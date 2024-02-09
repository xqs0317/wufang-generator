package com.xqs.maker.generator.file;

import com.xqs.maker.model.DataModel;

import java.io.File;

public class FileGenerator {
    public static void main(String[] args) throws Exception {
        //1.静态文件生成
        String projectPath = System.getProperty("user.dir");
        String srcPath = projectPath + File.separator + "demos" + File.separator + "acm-template";
        String descPath = projectPath;
        StaticFileGenerator.copyFilesByHutool(srcPath, descPath);
        //2.动态模板替换
        String templatesPath = projectPath + File.separator + "wufang-generator-maker" + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates";
        String inputPath = templatesPath + File.separator + "MainTemplate.java.ftl";
        String outputPath = descPath + File.separator + "acm-template" + File.separator +
                "src" + File.separator + "com" + File.separator + "yupi" + File.separator + "acm"
                + File.separator + "MainTemplate.java";
        DataModel config = new DataModel();
        config.setAuthor("xqs");
        config.setLoop(false);
        config.setOutputText("输出结果为：");
        DynamicFileGenerator.doGenerator(inputPath, outputPath, config);
    }

    public static void doGenerator(DataModel config) throws Exception {
        //1.静态文件生成
        String basicPath = System.getProperty("user.dir");
        File parentFile = new File(basicPath).getParentFile();
        System.out.println(parentFile.getAbsolutePath());
        String srcPath = parentFile.getAbsolutePath() + File.separator + "demos" + File.separator + "acm-template";
        String descPath = basicPath;
        StaticFileGenerator.copyFilesByHutool(srcPath, descPath);
        //2.动态模板替换
        String templatesPath = basicPath + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates";
        String inputPath = templatesPath + File.separator + "MainTemplate.java.ftl";
        String outputPath = descPath + File.separator + "acm-template" + File.separator +
                "src" + File.separator + "com" + File.separator + "yupi" + File.separator + "acm"
                + File.separator + "MainTemplate.java";
        DynamicFileGenerator.doGenerator(inputPath, outputPath, config);
    }
}
