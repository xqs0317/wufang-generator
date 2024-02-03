package com.xqs.model;

import lombok.Data;

@Data
public class MainTemplateConfig {
    /**
     * 作者
     */
    private String author = "无妨";
    /**
     * 是否循环
     */
    private boolean loop;
    /**
     * 输出内容
     */
    private String outPutText = "sum=";
}
