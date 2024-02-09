package com.xqs.maker.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class JarGenerator {
    public static void jarPackage(String projectDir) throws InterruptedException, IOException {
        //windows下的命令
        String winMavenCmd = "mvn.cmd clean package -DskipTests=true";
        //其他系统的命令
        String otherMavenCmd = "mvn clean package -DskipTests=true";
        String cmd = winMavenCmd;
        //ProcessBuilder处理的命令需要按照空格拆分
        ProcessBuilder processBuilder = new ProcessBuilder(cmd.split(" "));
        processBuilder.directory(new File(projectDir));
        Process process = processBuilder.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //转换为utf-8编码
            line = new String(line.getBytes("utf-8"), "utf-8");
            System.out.println(line);
        }
        bufferedReader.close();
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("打包失败");
        }
        System.out.println("打包成功，退出码：" + exitCode);
    }

    public static void main(String[] args) throws Exception {
        jarPackage("D:\\SSM\\知识星球\\wufang-generator\\wufang-generator-maker\\generated");
    }
}
