package young.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/12 18:21
 */
public class UserServiceImpl implements UserService {

    @Override
    public int insertUser(User user) throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(
                "insert into mybatis.user (user_id, user_name, age) value(" + user.getUserId() + ", '" + user.getUserName() + "'," + user.getAge() + ")");
        DBUtils.close(statement, connection);
        return result;
    }

    @Override
    public int deleteUser(User user) throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(
                "delete from mybatis.user where user_id = "
                        + user.getUserId() + " or user_name = '" + user.getUserName() + "' or age = " + user.getAge());
        DBUtils.close(statement, connection);
        return result;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from mybatis.user where user_id = " + id);
        User user = null;
        if (resultSet != null) {
            while (resultSet.next()) {
                Integer userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                Integer age = resultSet.getInt("age");
                user = new User(userId, userName, age);
            }
        }
        DBUtils.close(resultSet, statement, connection);
        return user;
    }

    @Override
    public List<User> listAllUser() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        List<User> userList = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from mybatis.user");
        if (resultSet != null) {
            while (resultSet.next()) {
                Integer userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                Integer age = resultSet.getInt("age");
                userList.add(new User(userId, userName, age));
            }
        }
        DBUtils.close(resultSet, statement, connection);
        return userList;
    }

    @Override
    public int updateUser(int id, User user) throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(
                "update mybatis.user set user_id = " + user.getUserId() + ", user_name = '" + user.getUserName()
                        + "', age = " + user.getAge() + " where user_id = " + id);
        DBUtils.close(statement, connection);
        return result;
    }
}
