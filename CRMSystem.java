package com;

import com.sun.security.ntlm.Client;

import java.awt.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName CRMSystem
 * @date 2019/8/15
 * @description
 **/
public abstract class CRMSystem {
    public abstract Client add(Client newGuy);       // 添加用户方法
    public abstract Event add(Event e, Client guy);  // 重载添加事件，用户方法
    public abstract Event[] todayEvents();           // 今日事件方法
}
