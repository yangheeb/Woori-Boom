package woori.fisa.boom.domain;

public class User {
    private int userId;
    private String userName;
    private int cnt;

    public User(int id, String name){
        this.userId = id;
        this.userName = name;
        this.cnt = 0;
    }

    public void setCnt(int value){
        this.cnt = value;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getCnt() {
        return cnt;
    }
}

