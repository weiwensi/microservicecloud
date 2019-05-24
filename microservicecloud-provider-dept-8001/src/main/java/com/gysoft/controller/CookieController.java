package com.gysoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/24 13:55
 */
@RestController
public class CookieController {

    /**
     * 增加cookie
     *
     * @param response
     */
    @RequestMapping("/addCookie")
    public String addCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("foo", "bar");
        response.addCookie(cookie);
        return "添加成功";

    }

    /**
     * 读取cookie
     * @param request
     */
    @RequestMapping("/showCookie")
    public void showCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("name:" + name + ",value:" + value);
            }
        } else {
            System.out.println("cookies is null");
        }
    }
    /**
     * 修改cookie
     */

    @RequestMapping("/editCookie")
    public void editCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String name = "foo";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue("new_bar");
                    System.out.println("修改的name为" + cookie.getName() + "修改后的值为：" + cookie.getValue());
                    response.addCookie(cookie);
                }
            }
        } else {
            System.out.println("cookies is null");
        }
    }
    /**
     * 删除Cookie
     *
     * @param request
     * @param response
     */
    @RequestMapping("/delCookie")
    public void delCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String name = "foo";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    System.out.println("删除成功");
                    break;
                }
            }
        }
    }

}
