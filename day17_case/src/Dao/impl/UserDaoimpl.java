package Dao.impl;

import Dao.UserDao;
import Utils.JDBCUtils;
import domain.User;
import domain.User2;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoimpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User2> findAll() {
        String sql = "select * from list";
        List<User2> users = template.query(sql,new BeanPropertyRowMapper<>(User2.class));
        return users;
    }
    public User login(User loginUser){
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public void addUser2(User2 user) {
        String sql = "insert into list values(null,?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getGender(),user.getAge(),user.getProvince(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from list where id = ?";
        template.update(sql,id);
    }

    @Override
    public User2 findUser2ById(String id) {
        String sql = "select * from list where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User2.class),id);
    }

    @Override
    public void updateUser2(User2 user2) {
        String sql = "update list set username = ?,gender = ?,age = ?, province = ?,qq = ?,email = ? where id = ?";
        template.update(sql,user2.getUsername(),user2.getGender(),user2.getAge(),
                user2.getProvince(),user2.getQq(),user2.getEmail(),user2.getId());
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from list";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User2> findPageList(int start,int rows) {
        String sql = "select * from list limit ?,? ";
        List<User2> query = template.query(sql, new BeanPropertyRowMapper<>(User2.class), start, rows);

        return query;
    }

}
