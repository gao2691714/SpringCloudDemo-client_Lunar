package com.example.eureka_client1_demo.controller;

import com.example.eureka_client1_demo.common.LunarCalender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * 获取当前农历日期
     * @return
     */
    @GetMapping("/getLunarDate")
    public String getDemoDate(){
        Calendar now = Calendar.getInstance();
        LunarCalender lunar = new LunarCalender();
        String days = lunar.getLunarDate(now.get(Calendar.YEAR),(now.get(Calendar.MONTH) + 1),now.get(Calendar.DAY_OF_MONTH),false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("当前农历日期为：");
        stringBuilder.append(lunar.cyclical(now.get(Calendar.YEAR))+"年 ");
        stringBuilder.append(lunar.getLunarMonth());
        stringBuilder.append(days);

        return stringBuilder.toString();
    }
}
