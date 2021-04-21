package com.astra_life.testing.backend.controllers;

import com.astra_life.testing.backend.tools.CommonTools;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {

    public static void main(String[] args) {
        System.out.println(new CommonTools().getDateNow());
        System.out.println(new Timestamp(System.currentTimeMillis()));

    }
}
