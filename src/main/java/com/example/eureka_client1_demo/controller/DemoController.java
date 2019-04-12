package com.example.eureka_client1_demo.controller;

import com.example.eureka_client1_demo.common.LunarCalender;
import org.springframework.web.bind.annotation.*;

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
        return backLunar(now,"当前农历日期为：");
    }

    /**
     * 根据输入日期，获取农历日期
     * @param year
     * @param month
     * @param day
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/getLunarDateByParam", method= RequestMethod.GET)
    public String getDemoDateByParam(@RequestParam(value="year",defaultValue="2019") String year,
                                     @RequestParam(value="month",defaultValue="1") String month,
                                     @RequestParam(value="day",defaultValue="1") String day){
//        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
//        if(pattern.matcher(year).matches() && pattern.matcher(month).matches() && pattern.matcher(day).matches()){
//            throw new Exception("日期字段非法："+year+","+month+","+day);
//        }
        Calendar now = Calendar.getInstance();
        now.set(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        return backLunar(now,"输入的农历日期为：");
    }

    private String backLunar(Calendar now,String message){
        LunarCalender lunar = new LunarCalender();
        String days = lunar.getLunarDate(now.get(Calendar.YEAR),(now.get(Calendar.MONTH) + 1),now.get(Calendar.DAY_OF_MONTH),false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message);
        stringBuilder.append(lunar.cyclical(now.get(Calendar.YEAR))+"年 ");
        stringBuilder.append(lunar.getLunarMonth());
        stringBuilder.append(days);
        return stringBuilder.toString();
    }
}
