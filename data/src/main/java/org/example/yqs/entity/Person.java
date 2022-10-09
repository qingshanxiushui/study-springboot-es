package org.example.yqs.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "contact")
public class Person {
    /**
     * 主键 id
     */
    @Id
    public Long id;

    /**
     * 姓名 name  ik_max_word表示该字段是一个文本，并作最大程度拆分，默认建立索引
     */
    @Field(type = FieldType.Keyword,name = "name")
    public String name;

    /**
     * 年龄 age
     */
    @Field(type = FieldType.Integer)
    public int age;

    /**
     * 地址 address Keyword表示该字段内容是一个文本并作为一个整体不可分，默认建立索引
     */
    @Field(type = FieldType.Keyword)
    public String address;
}

