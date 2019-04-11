package com.example.eureka_client1_demo;

import com.example.eureka_client1_demo.common.LunarCalender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class EurekaClient1DemoApplicationTests {

    @Test
    public void contextLoads() {
        Calendar now = Calendar.getInstance();
        LunarCalender lunar = new LunarCalender();
        System.out.println("年: " + now.get(Calendar.YEAR));
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分: " + now.get(Calendar.MINUTE));
        System.out.println("秒: " + now.get(Calendar.SECOND));
        System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
        System.out.println(now.getTime());

        String dayTime = lunar.getLunarDate(now.get(Calendar.YEAR),(now.get(Calendar.MONTH) + 1),now.get(Calendar.DAY_OF_MONTH),false);

//        System.out.print("当前农历日期 "+lunar.animalsYear(now.get(Calendar.YEAR))+"年");
        System.out.print("当前农历日期 "+lunar.cyclical(now.get(Calendar.YEAR))+" 年");
        System.out.print(" "+lunar.getLunarMonth());
        System.out.println(" "+dayTime);
    }

}
