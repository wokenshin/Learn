package Java14;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * @author kenshin
 * @date 2018/5/29 下午5:01
 */
public class ConnMySql {

    public static void main(String[] args) throws SQLException {

        //1.加载驱动 使用反射
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (//2.使用DriverManager获取数据库连接
             //其中返回的Connection就代表类Java程序和数据库的连接
             //不同数据库的URL写法需要查看驱动文档，用户名，密码由DBA分配
             Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root", "12345678");

             //3.使用Connection来创建一个Statement对象
             Statement stmt = conn.createStatement();

             //4.执行sql语句
             ResultSet rs = stmt.executeQuery("select s.*, teacher_name" + "from student_table s teacher_table t" + "where t.teacher_id = s.java_teacher"))
        {
            while (rs.next()){
                System.out.println(rs.getInt(1)+ "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }
        }
    }
}
