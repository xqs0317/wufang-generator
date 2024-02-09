package ${basePackage}.model;

import lombok.Data;

/**
 * 数据模型
 */
@Data
public class DataModel {
<#list modelConfig.models as field>

    <#if field.description??>
    /**
    * ${field.description}
    */
    </#if>
    private ${field.type} ${field.fieldName} <#if field.defaultValue??>= <#if field.type="String">"</#if>${field.defaultValue?string}<#if field.type="String">"</#if></#if>;
</#list>
}
