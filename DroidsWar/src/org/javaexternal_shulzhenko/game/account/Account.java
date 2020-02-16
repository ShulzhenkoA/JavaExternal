package org.javaexternal_shulzhenko.game.account;

public class Account {
    private String nickname;
    private String password;
    private boolean isAdmin;

    public Account(String nickname, String password, boolean isAdmin) {
        this.nickname = nickname;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
