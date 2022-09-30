package com.tang;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import transient_test.User;

import java.io.*;

/**
 * transient关键字测试
 * transient翻译为
 * 使用transient关键字不序列化某个变量
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/9/30 17:41
 */
public class TransientTest {

    private final Logger log = LoggerFactory.getLogger(TransientTest.class);

    @Test
    public void testWriteAndReadFile() {

        User user = new User();
        user.setUsername("Alexia"); // Alexia 人名 | 失读症
        user.setPassword("123456");
        log.info("read before serialize: ");
        log.info("username: {}", user.getUsername());
        log.info("password: {}", user.getPassword());
        log.info("To String {}", user);
        log.info("To jsonString: {}", JSON.toJSONString(user));
        System.out.println(user);
        String filePath = "D:\\program\\bankend_java" +
                "\\bugstack-algorithms\\data-struct\\src\\test\\java\\com\\tang\\user.txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(user); // 将对象写进文件流
            os.flush(); // 存
            os.close(); // 关
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (User) objectInputStream.readObject();
            log.info("read after serialize:");
            log.info("username: {}", user.getUsername());
            log.info("password: {}", user.getPassword());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
