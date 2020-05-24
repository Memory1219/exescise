package Service.impl;

import Dao.impl.UserDaoimpl;
import Service.UserService;
import domain.PageBean;
import domain.User;
import domain.User2;

import java.util.List;

public class UserServiceimpl implements UserService {

    private UserDaoimpl dao = new UserDaoimpl();
    @Override
    public List<User2> findAll() {
        List<User2> users = dao.findAll();
        return users;
    }
    public User login(User loginUser){
        User user = dao.login(loginUser);
        return user;
    }

    @Override
    public void addUser2(User2 user) {
        dao.addUser2(user);
    }

    @Override
    public void delete(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User2 findUser2ById(String id) {
        return dao.findUser2ById(id);
    }

    @Override
    public void updateUser2(User2 user2) {
        dao.updateUser2(user2);
    }

    @Override
    public void delSelected(String[] uids) {
        for (String uid : uids) {
            dao.delete(Integer.parseInt(uid));
        }
    }

    @Override
    public PageBean<User2> findUser2ByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int totalCount = dao.findTotalCount();
        int start = (currentPage-1)*rows;
        List<User2> list = dao.findPageList(start,rows);
        int totalPage = (totalCount%rows)==0 ? (totalCount/rows):(totalCount/rows)+1;
        PageBean<User2> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setList(list);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        return pb;
    }
}
