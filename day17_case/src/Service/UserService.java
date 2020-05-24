package Service;

import domain.PageBean;
import domain.User;
import domain.User2;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有数据
     * @return
     */
    public List<User2> findAll();

    /**
     *管理员（User）登录
     * @param loginUser
     * @return
     */
    public User login(User loginUser);

    /**
     *添加用户（user2）
     * @param user
     */
    public void addUser2(User2 user);

    /**
     * 删除list中的一条
     * @param id
     */
    public void delete(String id);

    /**
     * 根据id查找User2对象
     * @return
     */
    public User2 findUser2ById(String id);

    /**
     * 修改信息
     * @param user2
     */
    public void updateUser2(User2 user2);

    /**
     * 删除选中
     * @param uids
     */
    public void delSelected(String[] uids);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<User2> findUser2ByPage(String currentPage, String rows);
}
