package com.shaojie.domain;

import java.io.Serializable;
import java.util.List;

public class VO implements Serializable {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
