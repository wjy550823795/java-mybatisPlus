package com.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {
    public static void main(String[] args) {
//        FastAutoGenerator.create("jdbc:postgresql://192.168.3.82:5432/postgres", "postgres", "password")
        FastAutoGenerator.create("jdbc:postgresql://116.204.118.96:5432/haha_idp_dev", "postgres", "password")
            .globalConfig(builder -> {
                builder.author("wjy") // 设置作者
                    .enableSwagger() // 开启 swagger 模式
                    .fileOverride() // 覆盖已生成文件
                    .dateType(DateType.ONLY_DATE)
                    .commentDate("yyyy-MM-dd HH:mm:ss")
                    .outputDir("D:\\localRepository"); // 指定输出目录
            })
            .packageConfig(builder -> {
                builder.parent("com.haha.idp.bussiness.develop") // 设置父包名
                    .moduleName("server") // 设置父包模块名
//                            .other("dto")
                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/home/sugang/Documents/out")); // 设置mapperXml生成路径
            })
            .templateConfig(
                builder -> {
                    builder.entity("/templates/entity.java")
                        .service("/templates/service.java")
                        .serviceImpl("/templates/serviceImpl.java")
                        .mapper("/templates/mapper.java")
                        .mapperXml("/templates/mapper.xml")
                        .controller("/templates/controller.java");
                }
                           )
            .injectionConfig(builder -> {
                Map<String , Object> map = new HashMap<>();
                Map<String , String> map2 = new HashMap<>();
                map2.put("VO.java", "/templates/vo.java.vm");
                map2.put("DTO.java", "/templates/dto.java.vm");
                builder.beforeOutputFile((tableInfo, objectMap) -> {
                    map.put("entityName", tableInfo.getEntityName());
                })
                    .customMap(map)
                    .customFile(map2);
            })
            .strategyConfig(builder -> {
                builder .addInclude("dev_feature_schedule", "dev_feature_schedule_target")
//                            .addInclude("api_tenant_rule","api_basic_info","api_basic_request",
//                                    "api_basic_response","api_basic_type","api_error_info","api_config",
//                                    "api_tenant_config","api_application","api_log","api_bill") // 设置需要生成的表名,注释这一行就是生成当前数据库下所有表
//                            .addTablePrefix("sys_", "biz_", "api_","gov_","dev_")// 设置过滤表前缀
                    .entityBuilder()
                    .enableLombok()
                    .enableTableFieldAnnotation()
//                            .logicDeleteColumnName("is_del")//逻辑删除字段名(数据库)
//                            .logicDeletePropertyName("deleteFlag")//逻辑删除属性名(实体)
//                            .idType(IdType.AUTO)//主键类型
//                            .superClass(BaseEntity.class)
//                            .addSuperEntityColumns("id", "create_id", "create_time", "update_id", "update_time")
//                            .addTableFills(new Column("create_time", FieldFill.INSERT))
//                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                    .controllerBuilder()
                    .enableRestStyle()
                    .superClass("com.haha.idp.framework.common.web.BaseController")
                    .mapperBuilder()
                    .enableMapperAnnotation();

            })
            .templateEngine(new MyTemplate()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }

    static class MyTemplate extends VelocityTemplateEngine {
        protected void outputCustomFile( Map<String, String> customFile, TableInfo tableInfo, Map<String, Object> objectMap) {
            String entityName = tableInfo.getEntityName();
            String otherPath = this.getPathInfo(OutputFile.other);
            customFile.forEach((key, value) -> {
                String fileName = String.format(otherPath + File.separator  + "%s", entityName+key);
                this.outputFile(new File(fileName), objectMap, value);
            });
        }
    }
}
