package ${basePackage}.generator.file;

import ${basePackage}.model.DataModel;

import java.io.File;

public class FileGenerator {

    public static void doGenerator(DataModel model) throws Exception {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";
        String srcPath = null;
        String descPath = null;
<#list fileConfig.files as file>
        srcPath = inputRootPath + File.separator + "${file.inputPath}";
        descPath = outputRootPath + File.separator + "${file.outputPath}";
    <#if file.generateType="static">
        StaticGenerator.copyFilesByHutool(srcPath, descPath);
    <#else>
        DynamicGenerator.doGenerator(srcPath, descPath, model);
    </#if>
</#list>
    }
}
