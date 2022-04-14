package young.jdbc;

import java.sql.SQLException;
import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/12 18:19
 */
public interface UserService {

    int insertUser(User user) throws SQLException;

    int deleteUser(User user) throws SQLException;

    User getUserById(int id) throws SQLException;

    List<User> listAllUser() throws SQLException;

    int updateUser(int id, User user) throws SQLException;
}
