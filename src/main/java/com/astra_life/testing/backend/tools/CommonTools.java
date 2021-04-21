package com.astra_life.testing.backend.tools;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonTools {

    public LocalDateTime getDateNow(){
        LocalDateTime myDateObj = LocalDateTime.now();

        return myDateObj;
    }

//    public static void main(String[] args) {
//        System.out.println(this.getDateNow()getDateNow());
//    }
}
