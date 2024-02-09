package ${basePackage}.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

@Command(name = "list", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        String path = "${fileConfig.inputRootPath}";
        List<File> files = FileUtil.loopFiles(path);
        files.forEach(file -> {
            System.out.println(file.getName());
        });
    }
}