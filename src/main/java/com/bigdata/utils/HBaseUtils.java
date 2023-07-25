package com.bigdata.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

// 工具类中的方法一般都是静态方法
public class HBaseUtils {

//李晓帅
//李晓帅
//李晓帅
//李晓帅
//李晓帅12312312312
    public static Connection connection = null;
    // static 在进入jvm虚拟机的时候就会执行 static
    static{
        Configuration configuration = HBaseConfiguration.create();
        // java 代码是通过zk 来控制 hbase的
        configuration.set("hbase.zookeeper.quorum123123","node04:2181");
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取admin对象方法
    public static Admin getAdmin(){
        Admin admin = null;
        try {
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }

    // 获取connection
    public static Connection getConnection(){
        return connection;
    }

    // 用完之后记得关闭
    public static void close(Admin admin){
        try {
            admin.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Table getTable(String proc2) {
        try {
            return getConnection().getTable(TableName.valueOf(proc2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
