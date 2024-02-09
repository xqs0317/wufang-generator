package com.xqs.maker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class ScriptGenerator {
    public static void doGenerator(String outputPath, String jarPath) {
        //1.Linux下的脚本
        StringBuilder sb = new StringBuilder();
        sb.append("#!/bin/bash\n");
        sb.append(String.format("java -jar %s \"$@\"", jarPath));
        sb.append("\n");
        try {
            //添加可执行权限
            Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
            Files.setPosixFilePermissions(Paths.get(outputPath), permissions);
        } catch (Exception e) {
            System.out.println("添加可执行权限失败");
        }
        //写入文件
        FileUtil.writeString(sb.toString(), outputPath, "utf-8");
        //2.Windows下的脚本
        sb = new StringBuilder();
        sb.append("@echo off\n");
        //%的转义%%
        sb.append(String.format("java -jar %s %%*", jarPath)).append("\n");
        FileUtil.writeString(sb.toString(), outputPath + ".bat", "utf-8");
    }
}
