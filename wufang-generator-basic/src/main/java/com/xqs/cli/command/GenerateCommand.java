package com.xqs.cli.command;

import com.xqs.generator.MainGenerator;
import com.xqs.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Arrays;
import java.util.concurrent.Callable;
// some exports omitted for the sake of brevity

@Command(name = "generate", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    /**
     * 作者
     */
    @Option(names = {"-a", "--author"}, description = "作者名称", interactive = true,
            arity = "0..1", prompt = "请输入作者名称：", echo = true)
    private String author = "无妨";

    /**
     * 是否循环
     */
    @Option(names = {"-l", "--loop"}, description = "循环输入", interactive = true,
            arity = "0..1", prompt = "请选择是否开启循环输入：", echo = true)
    private boolean loop;

    /**
     * 输出内容
     */
    @Option(names = {"-o", "--outputText"}, description = "输出内容", interactive = true,
            arity = "0..1", prompt = "请输入输出内容：", echo = true)
    private String outPutText = "sum=";

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor(author);
        mainTemplateConfig.setLoop(loop);
        mainTemplateConfig.setOutPutText(outPutText);
        MainGenerator.doGenerator(mainTemplateConfig);
        return 0;
    }
}