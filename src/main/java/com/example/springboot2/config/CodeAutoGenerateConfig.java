package com.example.springboot2.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeAutoGenerateConfig {
    public static void main(String[] args) {
        AutoGenerator ag = new AutoGenerator();

        configGlobal(ag);
        configDataSource(ag);

        configStrategy(ag);
        configPackage(ag);
        configTemplate(ag);


        ag.execute();

    }

    public static AutoGenerator configTemplate(AutoGenerator generator){
         String entity = "/autocodetemplate/entity.java.vm";
         String service = "/autocodetemplate/service.java.vm";
         String serviceImpl = "/autocodetemplate/serviceImpl.java.vm";
         String mapper = "/autocodetemplate/mapper.java.vm";
         String xml = "/autocodetemplate/mapper.xml.vm";
         String controller = "/autocodetemplate/controller.java.vm";

        TemplateConfig template =new TemplateConfig();
        template.setController(controller);
        template.setEntity(entity);
        template.setMapper(mapper);
        template.setService(service);
        template.setServiceImpl(serviceImpl);
        template.setXml(xml);

        generator.setTemplate(template);
        return generator;
    }
    public static AutoGenerator configPackage(AutoGenerator generator){
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.springboot2");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setXml("xml");
        pc.setEntity("model");
        generator.setPackageInfo(pc);
        return generator;

    }

    public static AutoGenerator configStrategy(AutoGenerator generator){
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] {});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { "user" }); // 需要生成的表

        strategy.setSuperControllerClass("com.example.springboot2.controller.BaseController");

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        generator.setStrategy(strategy);
        return generator;
    }

    public static AutoGenerator configGlobal(AutoGenerator generator){
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("C:\\Users\\eversec\\Desktop\\code");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setAuthor("lishan");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        generator.setGlobalConfig(gc);

        return generator;
    }


    public static AutoGenerator configDataSource(AutoGenerator generator){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mytest");
        generator.setDataSource(dsc);
        return generator;
    }
}
