package transient_test;

import java.io.Serializable;

/**
 * 测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/9/30 17:40
 */
public class User implements Serializable {
    
    private String username;
    private transient String password;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
}
