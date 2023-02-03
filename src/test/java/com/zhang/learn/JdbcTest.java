package com.zhang.learn;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.ds.simple.SimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/4/16 18:12
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://10.27.15.196:3306/rc_saas?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true&autoReconnectForPools=true&useSSL=true&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
        String userName = "root";
        String password = "Aut0HOmE@2020!";
        String driver = "com.mysql.cj.jdbc.Driver";
        DataSource dataSource = new SimpleDataSource(url,userName,password,driver);
        Db db = DbUtil.use(dataSource);

        String sql = "insert into tenant_subject_relation (tenant_id,subject_id,is_del,created_stime,modified_stime) values (?,?,0,now(),now());";
        for(int i=10;i<=59;i++){
            db.execute(sql,1,i);
        }

    }
}
