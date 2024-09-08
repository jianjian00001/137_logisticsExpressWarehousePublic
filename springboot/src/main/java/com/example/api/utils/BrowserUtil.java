package com.example.api.utils;

import javax.servlet.http.HttpServletRequest;

public class BrowserUtil {
    /**
     * 获取浏览器版本
     *
     * @param request
     * @return
     */
    public static String getBrower(HttpServletRequest request) {
        String browserVersion = null;
        String header = request.getHeader("User-Agent");
        if (header.equals("") || header == null)// 为空就默认为谷歌
        {
            browserVersion = "谷歌浏览器";
            return browserVersion;
        }

        if (header.indexOf("Chrome") > 0)// 谷歌
        {
            browserVersion = "Chrome";
        }
        else if (header.indexOf("Safari") > 0)// safari
        {
            browserVersion = "safari浏览器";
        }
        if (header.indexOf("MSIE") > 0)// ie浏览器
        {
            browserVersion = "IE浏览器";
        }
        if (header.indexOf("Firefox") > 0)// 火狐浏览器
        {
            browserVersion = "火狐浏览器";
        }
        if (header.indexOf("Camino") > 0)//
        {
            browserVersion = "camino浏览器";
        }
        if (header.indexOf("Konqueror") > 0)//
        {
            browserVersion = "konqueror浏览器";
        }
        if (header.indexOf("Quark") > 0)// 夸克浏览器
        {
            browserVersion = "quark浏览器";
        }
        if (header.indexOf("baidu") > 0)// 百度浏览器
        {
            browserVersion = "百度浏览器";
        }
        if (header.indexOf("Edge") > 0)// edge浏览器
        {
            browserVersion = "edge";
        }
        if (header.indexOf("TheWorld") > 0)// theworld浏览器
        {
            browserVersion = "theworld浏览器";
        }
        if (header.indexOf("QQBrowser") > 0 || header.indexOf("TencentTraveler") > 0 || header.indexOf("QQTheme") > 0)// qq浏览器
        {
            browserVersion = "qq浏览器";
        }
        if (header.indexOf("Avast") > 0)// Avast Secure Browser浏览器
        {
            browserVersion = "avast浏览器";
        }
        if (header.indexOf("OPR") > 0)// opera浏览器
        {
            browserVersion = "opera浏览器";
        }
        if (header.indexOf("360") > 0)// 360浏览器
        {
            browserVersion = "360浏览器";
        }
        if (header.indexOf("LBBROWSER") > 0)// 猎豹浏览器
        {
            browserVersion = "猎豹浏览器";
        }
        if (header.indexOf("Maxthon") > 0)// 遨游浏览器
        {
            browserVersion = "遨游浏览器";
        }
        if (header.indexOf("MetaSr") > 0 || header.indexOf("Sogou") > 0)// 搜狗浏览器
        {
            browserVersion = "搜狗浏览器";
        }
        if (header.indexOf("UCWEB") > 0 || header.indexOf("UCBrowser") > 0)// uc浏览器
        {
            browserVersion = "uc浏览器";
        }
        if (browserVersion == null)// 没找到的都默认谷歌浏览器
        {
            browserVersion = "谷歌浏览器";
        }
        System.out.println(browserVersion);
        return browserVersion;

    }

}
