package com.xqs.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true,
            arity = "0..1", prompt = "请输入您的密码：")
    String password;

    @Option(names = {"-cp"}, description = "CheckPassphrase", interactive = true,
            arity = "0..1", prompt = "请再次输入您的密码：")
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("Welcome, " + user + "!");
        System.out.println("Your hashed password is: " + password);
        System.out.println("Your hashed checkPassword is: " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123");
    }
}
