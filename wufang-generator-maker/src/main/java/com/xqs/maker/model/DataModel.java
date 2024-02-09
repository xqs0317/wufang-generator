package com.xqs.maker.model;

import lombok.Data;

@Data
public class DataModel {
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
    private String outputText = "sum=";
}
