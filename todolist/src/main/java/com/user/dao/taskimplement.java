package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connector.connector;
import com.user.dto.Tasks;

public class taskimplement implements taskinterface {
    Connection con = null;

    public taskimplement() {
        this.con = connector.reqcon();
        if (con == null) {
            System.out.println("Database failed to connect");
        } else {
            System.out.println("Database Connected successfully!!");
        }
    }

    @Override
    public boolean addtask(int userid, String task) {
        String query = "INSERT INTO TASKS(tasks, status, id) VALUES(?, false, ?)";
        try {
            if (con == null || con.isClosed()) {
                System.out.println("❌ Connection is null or closed!");
                return false;
            }

            System.out.println("🟢 Trying to insert task: " + task + " for user id: " + userid);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, task);
            ps.setInt(2, userid);
            int row = ps.executeUpdate();
            System.out.println("✅ Inserted rows: " + row);
            return row > 0;

        } catch (SQLException e) {
            System.out.println("❌ SQL Error while adding task: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deletetask(int tid, int userid) {
        String query = "DELETE FROM TASKS WHERE Tid = ? AND id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, tid);
            ps.setInt(2, userid);
            int row = ps.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Tasks> gettasks(int userid) {
        List<Tasks> list = new ArrayList<>();
        String query = "SELECT * FROM TASKS WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tasks t = new Tasks();
                t.setTid(rs.getInt("Tid"));              // ✅ Correct column
                t.setTasks(rs.getString("tasks"));       // ✅ Correct column
                t.setStatus(rs.getBoolean("status"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Tasks> searchTasks(String query, int userid) {
        List<Tasks> list = new ArrayList<>();
        String sql = "SELECT * FROM TASKS WHERE id = ? AND tasks LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setString(2, "%" + query + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tasks t = new Tasks();
                t.setTid(rs.getInt("Tid"));              // ✅ Correct column
                t.setTasks(rs.getString("tasks"));       // ✅ Correct column
                t.setStatus(rs.getBoolean("status"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean updateTaskStatus(int tid, int userid, boolean status) {
        String query = "UPDATE TASKS SET status=? WHERE Tid=? AND id=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBoolean(1, status);
            ps.setInt(2, tid);
            ps.setInt(3, userid);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
