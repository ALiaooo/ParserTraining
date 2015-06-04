package com.aliao.parser.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 丽双 on 2015/6/4.
 */
public class LitePalAttr {

    private static LitePalAttr litePalAttr;

    //数据库版本号
    private int version;
    //数据库名
    private String dbName;
    //所有在数据库中想要有映射关系的实体类
    private List<String> classNames;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * 在sqlite里table_schema表示自动生成的，这里一定要手动添加进去
     * table_schema用来查看数据库的元数据，这里的元数据包括表名及表类型
     * @return
     */
    public List<String> getClassNames() {
        if (classNames == null){
            classNames = new ArrayList<>();
            classNames.add("com.aliao.parser.entity.Table_Schema");
        }else if (classNames.isEmpty()){
            classNames.add("com.aliao.parser.entity.Table_Schema");
        }
        return classNames;
    }

    public void addClassName(String className){
        getClassNames().add(className);
    }

    /**
     * 这里用双重检测来实现单例模式
     * 整个程序创建一个唯一的litePalAttr对象，可以通过这个对象拿到数据库的基本信息
     * @return
     */
    public static LitePalAttr getIntance(){
        if (litePalAttr == null){
            synchronized (LitePalAttr.class){
                if (litePalAttr == null){
                    litePalAttr = new LitePalAttr();
                }
            }
        }
        return litePalAttr;
    }

    @Override
    public String toString() {
        return "数据库名称:"+dbName+" ,数据库版本"+version;
    }
}
