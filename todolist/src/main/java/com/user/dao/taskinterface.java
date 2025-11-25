package com.user.dao;
import com.user.dto.Tasks;
import java.util.List;

public interface taskinterface {
public boolean addtask(int userid,String task);
public boolean deletetask(int tid,int id);
public List<Tasks> gettasks(int userid);
public List<Tasks> searchTasks(String query, int userid);
public boolean updateTaskStatus(int tid, int userid, boolean status);

}
