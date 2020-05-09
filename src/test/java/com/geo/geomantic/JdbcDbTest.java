package com.geo.geomantic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

/**
 * @author zyz
 * @date 2019/1/30
 * 十万条数据以上插入数据库性能测试
 * 使用mybatis的批量插入效率更低，组装原生jdbc插入大量数据效率更高
 * 十万以下的数据使用mybatis
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcDbTest {

    final String url = "jdbc:mysql://47.104.186.150:3306/geomantic";
    final String username = "root";
    final String password = "uAiqwVwjJ8-i";
    final String name = "com.mysql.cj.jdbc.Driver";

    /**
     * 一、普通方式
     * 491.914s
     */
    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(name);//指定连接类型
        conn = DriverManager.getConnection(url, username, password);//获取连接
        PreparedStatement stmt = null;
        long t1 = System.currentTimeMillis();
        try {
            stmt = conn.prepareStatement("INSERT INTO t_jdbc_test(\n" +
                    "\t`name`,\n" +
                    "\t`start_time`,\n" +
                    "\t`end_time`\n" +
                    ") VALUES(?,?,?)");
            for (int i = 0; i < 100000; i++) {
                stmt.setString(1, "数据普通方式" + i);
                stmt.setDate(2, new Date(System.currentTimeMillis()));
                stmt.setDate(3, new Date(System.currentTimeMillis()));
                stmt.execute();
            }
            System.out.println("TEST1");
            System.out.println("test2");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            JDBCUtil.release(null, stmt, conn);
            // 关闭连接
            stmt.close();
            conn.close();
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1));
    }

    /**
     * 事务提交
     * 32.104s
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(name);//指定连接类型
        conn = DriverManager.getConnection(url, username, password);//获取连接
        PreparedStatement stmt = null;
        long t1 = System.currentTimeMillis();
        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO t_jdbc_test(\n" +
                    "\t`name`,\n" +
                    "\t`start_time`,\n" +
                    "\t`end_time`\n" +
                    ") VALUES(?,?,?)");
            for (int i = 0; i < 100000; i++) {
                stmt.setString(1, "数据事物提交" + i);
                stmt.setDate(2, new Date(System.currentTimeMillis()));
                stmt.setDate(3, new Date(System.currentTimeMillis()));
                stmt.execute();
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            stmt.close();
            conn.close();
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1));

    }


    /**
     * 三、批处理：
     * 特别注意:需要url参数加:rewriteBatchedStatements=true
     * url范例: jdbc:mysql://127.0.0.1/XXX?characterEncoding=UTF-8&rewriteBatchedStatements=true
     * 22.25s   30.322s
     */
    @Test
    public void test3() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(name);//指定连接类型
        conn = DriverManager.getConnection(url + "?characterEncoding=UTF-8&rewriteBatchedStatements=true", username, password);//获取连接
        PreparedStatement stmt = null;
        long t1 = System.currentTimeMillis();
        try {
            stmt = conn.prepareStatement("INSERT INTO t_jdbc_test(\n" +
                    "\t`name`,\n" +
                    "\t`start_time`,\n" +
                    "\t`end_time`\n" +
                    ") VALUES(?,?,?)");
            for (int i = 0; i < 100000; i++) {
                stmt.setString(1, "数据批处理" + i);
                stmt.setDate(2, new Date(System.currentTimeMillis()));
                stmt.setDate(3, new Date(System.currentTimeMillis()));
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            stmt.close();
            conn.close();
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1));
    }


    /**
     * 四、事务+批处理并且分批执行
     * 结论:加事务时间无影响，但是分批次能提供效率的增加
     * 100万条：14.805s    加了索引：27.857s
     */
    @Test
    public void test4() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(name);//指定连接类型
        conn = DriverManager.getConnection(url + "?characterEncoding=UTF-8&rewriteBatchedStatements=true", username, password);//获取连接
        PreparedStatement stmt = null;
        long t1 = System.currentTimeMillis();
        try {
            //conn.setAutoCommit(false);  /**取消事务对时间无太大影响！！*/
            stmt = conn.prepareStatement("INSERT INTO t_jdbc_test(\n" +
                    "\t`name`,\n" +
                    "\t`start_time`,\n" +
                    "\t`end_time`\n" +
                    ") VALUES(?,?,?)");

//            for (int i = 1; i <=100; i++) { //1万条一次
//                for (int j = 1; j <=10000; j++) {
//                      stmt.setString(1, "数据事务+批处理" + ((i-1)*10000)+j);
//                      stmt.setDate(2, new Date(System.currentTimeMillis()));
//                      stmt.setDate(3, new Date(System.currentTimeMillis()));
//                    stmt.addBatch();
//                }
//                stmt.executeBatch();
//                stmt.clearBatch(); /**清除缓存*/
//                System.out.println("执行到第"+i+"外循环");
//            }
//          conn.commit();

            //-------> 上面固定了100万条，假如不确定多少数据量的情况，就不好指定2层循环.可采用下面的样子
            int size = 1000000;     //size = 999999;    size = 71236;
            for (int i = 0; i < size; i++) {
                stmt.setString(1, "数据第二个百万2" + i);
                stmt.setDate(2, new Date(System.currentTimeMillis()));
                stmt.setDate(3, new Date(System.currentTimeMillis()));
                stmt.addBatch();
                if (i % 10000 == 0 || i == size - 1) { //1万次一条，或者最后一次进行提交。
                    stmt.executeBatch();
                    stmt.clearBatch(); /**清除缓存*/
                    System.out.println("执行到第" + i / 10000 + "外循环");
                }
            }

        } catch (SQLException e) {
//            try {
//                conn.rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
        } finally {
            // 关闭连接
            stmt.close();
            conn.close();
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1));
    }

    @Test
    public void testTiem() {
        System.out.println(System.currentTimeMillis());
    }


}
