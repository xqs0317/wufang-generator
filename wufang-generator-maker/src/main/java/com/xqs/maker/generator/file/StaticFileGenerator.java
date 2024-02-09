package com.xqs.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * 静态文件生成
 */
public class StaticFileGenerator {

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

}
