package com.example.nulldisaster;

public class Users {
    @com.google.gson.annotations.SerializedName("id")
    public String mId;

    String username;
    String password;
    String email_id;
    int age;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public Users(String username, String password, String email_id, int age) {
        this.username = username;
        this.password = password;
        this.email_id = email_id;
        this.age = age;
        this.mId=username;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
