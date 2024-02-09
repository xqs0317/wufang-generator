package com.xqs.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.xqs.maker.generator.file.DynamicFileGenerator;
import com.xqs.maker.meta.Meta;
import com.xqs.maker.meta.MetaManager;

import java.io.File;

/**
 * 代码生成器制作主类
 */
public class MainGenerator {
    public static void main(String[] args) throws Exception {
        Meta meta = MetaManager.getMetaObject();
        String projectPath = System.getProperty("user.dir");
        //代码生成器生成位置
        String outputPath = projectPath + File.separator + "generated";
        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }
        //读取Resouce目录
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();
        String inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        //输出路径
        //处理用户自定义包名
        //1.生成DataModel
        String basePackage = meta.getBasePackage().replace(".", "/");
        String outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "model/DataModel.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        //2.生成Picocli相关文件
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "Main.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        //3.生成Generator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/file/StaticGenerator.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "generator/file/" + "StaticGenerator.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/file/DynamicGenerator.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "generator/file/" + "DynamicGenerator.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/file/FileGenerator.java.ftl";
        outputFilePath = outputPath + File.separator + "src/main/java" + File.separator + basePackage + File.separator +
                "generator/file/" + "FileGenerator.java";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        //4.生成pom.xml
        inputFilePath = inputResourcePath + File.separator + "templates/pom.xml.ftl";
        outputFilePath = outputPath + File.separator + "pom.xml";
        DynamicFileGenerator.doGenerator(inputFilePath, outputFilePath, meta);
        //5.生成jar包
        JarGenerator.jarPackage(outputPath);
        //6.生成脚本
        String outputScriptPath = outputPath + File.separator + "generator";
        String jarPath = "target/" + meta.getName() + "-" + meta.getVersion() + "-jar-with-dependencies.jar";
        ScriptGenerator.doGenerator(outputScriptPath, jarPath);
    }
}
