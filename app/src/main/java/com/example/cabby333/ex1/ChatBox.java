package com.example.cabby333.ex1;


public class ChatBox
{
    private String name, msg, timeStamp;

    ChatBox(String name, String input, String timeStamp) {
        this.name = name;
        this.msg = input;
        this.timeStamp = timeStamp;
    }

    public String getName()
    {
        return name;
    }

    public String getMsg()
    {
        return msg;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

}
