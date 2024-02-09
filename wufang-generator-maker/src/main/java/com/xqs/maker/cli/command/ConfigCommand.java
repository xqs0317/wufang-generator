package com.xqs.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.xqs.maker.model.DataModel;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;
// some exports omitted for the sake of brevity

@Command(name = "config", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        //1.Java本地反射
//        Class<?> cls = null;
//        try {
//            cls = Class.forName("com.xqs.model.MainTemplateConfig");
//            Field[] fields = cls.getFields();
//            for (Field field : fields) {
//                System.out.println("字段类型：" + field.getType());
//                System.out.println("字段名称：" + field.getName());
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        //2.使用Hutool工具类
        Field[] fields = ReflectUtil.getFields(DataModel.class);
        for (Field field : fields) {
            System.out.println("字段类型：" + field.getType());
            System.out.println("字段名称：" + field.getName());
        }
    }
}