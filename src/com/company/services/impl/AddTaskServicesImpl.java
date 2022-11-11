package com.company.services.impl;

import com.company.db.DBHelper;
import com.company.db.enums.Condition;
import com.company.db.impl.DBHelperImpl;
import com.company.models.Task;
import com.company.models.User;
import com.company.services.AddTaskServices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTaskServicesImpl implements AddTaskServices {

    DBHelper dbHelper = new DBHelperImpl();
    Scanner sc = new Scanner(System.in);
    @Override
    public List<Task> getTaskList(List<User> user1) {
        try {
            PreparedStatement ps=dbHelper.getConnection("select t.id, t.name, t.state, u.id as user_id, u.login as user_login \n" +
                    "from tb_task  t \n" +
                    "INNER JOIN tb_user u \n" +
                    "on u.id = t.user_id\n" +
                    "where u.id = ?");
            ps.setLong(1,user1.get(0).getId());
            ResultSet rs = ps.executeQuery();
            List<Task> list = new ArrayList<>();
            while (rs.next()){
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setState(rs.getString("state"));
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setLogin(rs.getString("user_login"));
                task.setUserId(user);
                list.add(task);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при выводе списка задач");
        }

    }

    @Override
    public List<User> getCreateUser() {
        List<User> list = new ArrayList<>();
        User user = new User();
        System.out.println("Введите имя пользователя ");
        user.setLogin(sc.next());
        System.out.println("Введите почту ");
        user.setEmail(sc.next());
        System.out.println("Введите пароль ( 8 знаков) ");
        user.setPassword(sc.next());
        System.out.println("Введите повторно пароль ");
        user.setPassword_2(sc.next());
        list.add(user);

        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_user (login,email,password,password_2) Values (?, ?, ?, ?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPassword_2());
            ps.executeUpdate();
            list.add(user);
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при создании задачи");
        }

    }

    @Override
    public void getCreateTask(List<User> user1) {
        System.out.println("Введите названия задачи");
        Task task = new Task();
        task.setName(sc.nextLine());
        task.setState(String.valueOf(Condition.ToDo));
        User user = new User();
        user.setId(user1.get(0).getId());
        user.setLogin(user1.get(0).getLogin());
        user.setEmail(user1.get(0).getEmail());
        user.setPassword(user1.get(0).getPassword());
        user.setPassword_2(user1.get(0).getPassword_2());
        task.setUserId(user);

        try {
            PreparedStatement ps = dbHelper.getConnection("insert into tb_task (name,state,user_id) VALUES (?,?,?)");
            ps.setString(1,task.getName());
            ps.setString(2,task.getState());
            ps.setLong(3,task.getUserId().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
