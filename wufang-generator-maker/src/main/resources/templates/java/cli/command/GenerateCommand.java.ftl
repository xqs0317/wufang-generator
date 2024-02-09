package ${basePackage}.cli.command;

import ${basePackage}.generator.file.FileGenerator;
import ${basePackage}.model.DataModel;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "generate", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
<#list modelConfig.models as field>

    <#if field.description??>
    /**
     * ${field.description}
     */
    </#if>
    @Option(names = {<#if field.abbr??>"-${field.abbr}",</#if> "--${field.fieldName}"}, <#if field.description??>description = "${field.description}",</#if>interactive = true,
    arity = "0..1", echo = true)
    private ${field.type} ${field.fieldName} <#if field.defaultValue??>= <#if field.type="String">"</#if>${field.defaultValue?string}<#if field.type="String">"</#if></#if>;
</#list>
    @Override
    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        dataModel.setAuthor(author);
        dataModel.setLoop(loop);
        dataModel.setOutputText(outputText);
        FileGenerator.doGenerator(dataModel);
        return 0;
    }
}