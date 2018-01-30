工具类
dao生成, 
dto
静态资源
工具类
    数字
    双精度数字
    uuid
    http
    json
    md5
    常用正则
    spring context
    xss

差的列表

1.时间
2.字符
3.拼音
...

-----------------------------------------------------------------
dao生成使用方法, 注:一定要在maven工程里的test下建立, 否则无效
1.在目标目录test建立自己的类, 继承MybatisGeneratorUtil
2.在test的resource目录里, 建立目录xml, 
    然后复制模板(模板位于com.cifaz.tools.dao.xml下), 
    建立xml文件并修改配置, 注:建议每一个模块生成一个xml文件
3.新建的类中, 建立main方法, 建立如下代码
    MybatisGeneratorUtil mybatisGeneratorUtil = new MybatisGeneratorUtil();
    mybatisGeneratorUtil.generateAll(DaoGenerate.class); // 参数为当前类名 类名.class
4.运行
5.如果需要单独运行某一个mybatisGeneratorUtil.generate(String... xmllist), 参数可传多个xml名称, 



