package com.xqs.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.Arrays;
import java.util.List;
// some exports omitted for the sake of brevity

@Command(name = "list", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        String basicPath = System.getProperty("user.dir");
        File parentFile = new File(basicPath).getParentFile();
        String path = parentFile.getAbsolutePath() + File.separator + "demos" + File.separator + "acm-template";
        List<File> files = FileUtil.loopFiles(path);
        files.forEach(file -> {
            System.out.println(file.getName());
        });
    }
}