package learn;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.ds.simple.SimpleDataSource;
import org.assertj.core.util.Lists;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/4/16 18:12
 */
public class JdbcTest2 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://etravel.db:3306/rent_car?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true&autoReconnectForPools=true&useSSL=true&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
        String userName = "root";
        String password = "Aut0HOmE@2020!";
        String driver = "com.mysql.cj.jdbc.Driver";
        DataSource dataSource = new SimpleDataSource(url, userName, password, driver);
        Db db = DbUtil.use(dataSource);

        String sql = "insert into users (user_name,user_code) values ('%s','%s')";
        List<String> sqls = Lists.newArrayList();
        for (int i = 0; i <= 4000000; i++) {
            String name = generateCode();
            String code = generateCode();
            sqls.add(String.format(sql, name, code));
            if (i % 2000 == 0 && sqls.size() > 0) {
                db.executeBatch(sqls.toArray(new String[0]));
                sqls.clear();
            }

            if (i % 10000 == 0) {
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "执行" + i + "条了");
            }
        }
        System.out.println(generateCode());
    }

    private static String generateCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
