package com.user.dto;

public class Tasks {
private int Tid;
private String tasks;
private boolean status;

public int getTid() {
	return Tid;
}
public void setTid(int tid) {
	Tid = tid;
}
public String getTasks() {
	return tasks;
}
public void setTasks(String tasks) {
	this.tasks = tasks;
}
public boolean getStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
@Override
public String toString() {
	return "Task id: "+Tid+"\nTask: "+tasks+"\nStatus: "+status;
}

}
