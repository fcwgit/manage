package cn.com.yusys.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
