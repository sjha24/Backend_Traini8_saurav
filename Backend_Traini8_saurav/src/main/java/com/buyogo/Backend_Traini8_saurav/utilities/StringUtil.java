package com.buyogo.Backend_Traini8_saurav.utilities;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;


import java.util.Objects;


@UtilityClass
public class StringUtil {

    public static boolean isNullOrEmpty(String str){
        return (Objects.isNull(str) || StringUtils.isEmpty(str));
    }

    public static boolean isNotBlank(String str){
        return org.apache.commons.lang3.StringUtils.isNotBlank(str);
    }

}