package hash_table._test_;

import hash_table.HashMap01;
import hash_table.HashMap02BySeparateChaining;
import hash_table.HashMap03ByOpenAddressing;
import hash_table.Map;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashTableTest {

    private final Logger log = LoggerFactory.getLogger(HashTableTest.class);

    @Test
    public void testHashMap01() {

        Map<String, String> map = new HashMap01<>();
        map.put("01", "花花");
        map.put("02", "豆豆");
        log.info("碰撞前 key：{} value：{}", "01", map.get("01"));
        
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        log.info("碰撞后 key：{} value：{}", "01", map.get("01"));
        
        
    }

    @Test
    public void testHashMap02() {

        Map<String, String> map = new HashMap02BySeparateChaining<>();
        map.put("01", "花花");
        map.put("02", "豆豆");
        log.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        log.info("碰撞后 key：{} value：{}", "01", map.get("01"));


    }
    
    @Test
    public void testHashMap03() {

        Map<String, String> map = new HashMap03ByOpenAddressing<>();
        map.put("01", "花花");
        map.put("02", "豆豆");
        log.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        log.info("碰撞后 key：{} value：{}", "01", map.get("01"));
        log.info("碰撞后 key：{} value：{}", "02", map.get("02"));
        log.info("碰撞后 key：{} value：{}", "09", map.get("09"));
        log.info("碰撞后 key：{} value：{}", "12", map.get("12"));

        log.info("数据结构：{}", map);
    }
    

}
