package services;
import interfaces.NotiInterface;

public class Notification implements NotiInterface {
    private String msg;

    public void processMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}