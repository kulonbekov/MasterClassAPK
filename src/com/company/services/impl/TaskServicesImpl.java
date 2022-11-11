package com.company.services.impl;

import com.company.db.DBHelper;
import com.company.db.enums.Condition;
import com.company.db.impl.DBHelperImpl;
import com.company.models.Task;
import com.company.models.User;
import com.company.services.TaskServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskServicesImpl implements TaskServices {

    DBHelper dbHelper = new DBHelperImpl();
    Scanner sc = new Scanner(System.in);
    @Override
    public List<Task> getTaskList() {

        try {
            PreparedStatement ps=dbHelper.getConnection("select t.id, t.name, t.state, u.id as user_id, u.login as user_login \n" +
                    "from tb_task  t \n" +
                    "INNER JOIN tb_user u \n" +
                    "on u.id = t.user_id");
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
    public void updateTask(long id) {
        try {
            PreparedStatement ps = dbHelper.getConnection("UPDATE tb_task set state = ? where id =?");

            ps.setString(1, answerState());
            ps.setLong(2,id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при изменения состоянии задачи");
        }
    }

    @Override
    public void createTask() {
        System.out.println("Введите названия задачи");
        Task task = new Task();
        task.setName(sc.nextLine());
        task.setState(String.valueOf(Condition.ToDo));
        try {
            PreparedStatement ps=dbHelper.getConnection("insert into tb_task (name,state) VALUES (?,?)");
            ps.setString(1,task.getName());
            ps.setString(2,task.getState());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при создании задачи");
        }
    }

    @Override
    public void deleteTask(long id) {
        try {
            PreparedStatement ps=dbHelper.getConnection("delete from tb_task where id=?");
            ps.setLong(1,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при удаления задачи");
        }

    }

    @Override
    public void outputList(List<Task> task) {
        for (int i = 0; i <task.size(); i++) {
            System.out.println("id = " + task.get(i).getId() + ", названия = " + task.get(i).getName() +
                    ", статус = " + task.get(i).getState() + ", пользователь = " + task.get(i).getUserId().getLogin());
        }
        System.out.println();
    }

    @Override
    public String answerState() {
        System.out.println("Выберите статус: 1 - в процессе, 2 - выполнена, 3 - Закрыта (или отменена)");
        String answer = null;
        switch (sc.nextInt()){
            case 1:
                answer = String.valueOf(Condition.IN_PROGRESS);
                break;
            case 2:
                answer = String.valueOf(Condition.DONE);
                break;
            case 3:
                answer = String.valueOf(Condition.CLOSED);
                break;
        }
        return answer;
    }
}
