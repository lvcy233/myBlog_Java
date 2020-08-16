package com.common.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class TableGenerate {

    //private final static String PACKAGE = "user";
    private final static String PACKAGE = "blog";

    public static void main(String[] args) {
        //生成全局配置
        AutoGenerator autoGenerator = new AutoGenerator();
        GlobalConfig globalConfig = new GlobalConfig();
        String path = System.getProperty("user.dir");
        //子项目要改user这个为子module名
        globalConfig.setOutputDir(path + "/" + PACKAGE + "/src/main/java")
        //globalConfig.setOutputDir(path + "/user/src/main/java")
                .setAuthor("lvcy")
                .setOpen(false)
                .setFileOverride(false)
                .setServiceName("%sService")
                .setXmlName("%sMapping")
                .isFileOverride();
        autoGenerator.setGlobalConfig(globalConfig);
        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://121.196.55.80:3306/myblog?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false&seUnicode=true")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456")
                .setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);
        //配置包
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.dev." + PACKAGE)
                .setEntity("entity")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setXml("mapper.mapping");
        autoGenerator.setPackageInfo(packageConfig);
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setInclude("user,user_info".split(","))//("表名，多个英文逗号分割").split(",")
                .setInclude("blog,blog_categories,blog_tags,categories,tags".split(","))//("表名，多个英文逗号分割").split(",")
                .setEntityLombokModel(true)//启动lombok
                .setRestControllerStyle(true)//驼峰命名
                .setLogicDeleteFieldName("deleted")//逻辑删除
                .setControllerMappingHyphenStyle(true);//下划线命名
        autoGenerator.setStrategy(strategyConfig);
        //执行操作
        autoGenerator.execute();
    }
}
