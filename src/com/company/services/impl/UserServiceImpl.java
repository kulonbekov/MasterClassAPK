package com.company.services.impl;

import com.company.db.DBHelper;
import com.company.db.impl.DBHelperImpl;
import com.company.models.Task;
import com.company.models.User;
import com.company.services.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    DBHelper dbHelper = new DBHelperImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public List<User> getUserList() {
        try {
            PreparedStatement ps=dbHelper.getConnection("SELECT * from tb_user");
            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPassword_2(rs.getString("password_2"));

                list.add(user);
            }
            return list;


        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при выводе списка задач");
        }
    }

    @Override
    public void updateUser(long id) {

    }

    @Override
    public void createUser() {

        User user = new User();
        System.out.println("Введите имя пользователя ");
        user.setLogin(sc.next());
        System.out.println("Введите почту ");
        user.setEmail(sc.next());
        System.out.println("Введите пароль ( 8 знаков) ");
        user.setPassword(sc.next());
        System.out.println("Введите повторно пароль ");
        user.setPassword_2(sc.next());

        /*while (true) {
            System.out.println("Введите пароль ( 8 знаков) ");
            user.setPassword(sc.next());
            System.out.println("Введите повторно пароль ");
            user.setPassword_2(sc.next());
            if(user.getPassword().equals(user.getPassword_2())){
                System.exit(0);
            }else{
                System.err.println("Пароли не совпадают");
            }
        }*/

        try {
            PreparedStatement ps=dbHelper.getConnection("insert into tb_user (login,email,password,password_2) Values (?, ?, ?, ?)");
            ps.setString(1,user.getLogin());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getPassword_2());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при создании задачи");
        }


    }

    @Override
    public List<User> userVerification() {

        return null;
    }

    @Override
    public void outputList(List<User> user) {
        for (int i = 0; i <user.size(); i++) {
            System.out.println("id = " + user.get(i).getId() + ", login = " + user.get(i).getLogin() +
                    ", email = " +  user.get(i).getEmail() + ", password = ********" );
        }
        System.out.println();
    }
}
