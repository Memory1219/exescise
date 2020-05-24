package Dao;

import domain.User;
import domain.User2;

import java.util.List;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    public List<User2> findAll();
    public User login(User loginUser);

    public void addUser2(User2 user);

    public void delete(int parseInt);

    public User2 findUser2ById(String id);

    public void updateUser2(User2 user2);

    /**
     * 查询数据总数
     * @return
     */
    int findTotalCount();

    /**
     * 查找每页数据
     * @param start
     * @param rows
     * @return
     */
    List<User2> findPageList(int start, int rows);
}
