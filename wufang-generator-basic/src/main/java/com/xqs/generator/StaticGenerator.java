package com.xqs.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String srcPath = projectPath + File.separator + "demos" + File.separator + "acm-template";
        String descPath = projectPath;
        copyFilesByRecursion(new File(srcPath), new File(descPath));
//        copyFilesByHutool(srcPath, descPath);
    }

    /**
     * 使用Hutool工具类复制文件
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     */
    public static void copyFilesByHutool(String srcPath, String destPath) {
        //true表示覆盖
        FileUtil.copy(srcPath, destPath, true);
    }


    /**
     * 递归复制文件
     *
     * @param inputFile  源文件
     * @param outPutFile 目标文件
     */
    public static void copyFilesByRecursion(File inputFile, File outPutFile) {
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File descOutPutFile = new File(outPutFile.getPath(), inputFile.getName());
            if (!descOutPutFile.exists()) {
                descOutPutFile.mkdirs();
            }
            File[] files = inputFile.listFiles();
            for (File file : files) {
                copyFilesByRecursion(file, descOutPutFile);
            }
        } else {
            FileUtil.copy(inputFile.getPath(), outPutFile.getPath(), true);
        }
    }
}
