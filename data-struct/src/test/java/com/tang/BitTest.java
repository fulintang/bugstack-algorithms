package com.tang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 测试bit
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/10 17:25
 */
public class BitTest {
  
    Logger log = LoggerFactory.getLogger(BitTest.class);
    
    @Test
    public void test() {
        log.info("1的二进制：{} 长度：{}", Integer.toBinaryString(1), Integer.toBinaryString(1).length());
        log.info("0的二进制：{} 长度：{}", Integer.toBinaryString(0), Integer.toBinaryString(0).length());
        log.info("-1的二进制：{} 长度：{}", Integer.toBinaryString(-1), Integer.toBinaryString(-1).length());
        log.info("-2的二进制：{} 长度：{}", Integer.toBinaryString(-2), Integer.toBinaryString(-2).length());
        log.info("-3的二进制：{} 长度：{}", Integer.toBinaryString(-3), Integer.toBinaryString(-3).length());
        log.info("-4的二进制：{} 长度：{}", Integer.toBinaryString(-4), Integer.toBinaryString(-4).length());
        log.info("正数最大值{}的二进制{} 长度：{}", Integer.MAX_VALUE, Integer.toBinaryString(Integer.MAX_VALUE), Integer.toBinaryString(Integer.MAX_VALUE).length());
        log.info("负数最小值{}的二进制：{} 长度：{}", Integer.MIN_VALUE, Integer.toBinaryString(Integer.MIN_VALUE), Integer.toBinaryString(Integer.MIN_VALUE).length());
    }
    
}
