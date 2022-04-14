package young.jdbc;

import java.sql.SQLException;
import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/12 18:49
 */
public class UserController {

    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {

        User user1 = new User(1, "张三", 11);
        User user2 = new User(2, "李四", 22);
        User user3 = new User(3, "王五", 33);
        User user4 = new User(4, "赵六", 44);



        User user = new User(5, "替补", 55);
        int insertUser = userService.insertUser(user1);
        System.out.println(insertUser);
        System.out.println("-------------------------------------------");


        int deleteUser = userService.deleteUser(user1);
        System.out.println(deleteUser);
        System.out.println("-------------------------------------------");


        userService.insertUser(user1);
        userService.insertUser(user2);
        userService.insertUser(user3);
        userService.insertUser(user4);
        List<User> userList = userService.listAllUser();
        System.out.println(userList);
        System.out.println("-------------------------------------------");


        int updateUser = userService.updateUser(4, user);
        System.out.println(updateUser);
        System.out.println("-------------------------------------------");


        User userById = userService.getUserById(5);
        System.out.println(userById);
        System.out.println("-------------------------------------------");
    }
}
