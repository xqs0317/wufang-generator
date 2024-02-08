package com.xqs.cli;

import com.xqs.cli.command.ConfigCommand;
import com.xqs.cli.command.GenerateCommand;
import com.xqs.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "wufang", version = "wufang-generator 1.0", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    final CommandLine commandLine;

    //1.绑定子命令
    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     *
     * @param args
     * @return 返回执行状态
     */
    public Integer doExecute(String[] args) {
        int exitCode = commandLine.execute(args);
        return exitCode;
    }
}