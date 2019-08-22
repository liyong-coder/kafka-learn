package com.example.providerone.beans;

import lombok.Data;

import java.util.Date;

/**
 * @author: liyong
 * @date: 2019/8/19 0019 16:23
 */
@Data
public class Message {

    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳
}
