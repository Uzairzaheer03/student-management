package com.studentmanagement.logging;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Log
@Slf4j
public class LogStudent {

    public static void main(String... args) {
        log.severe("Something's wrong here");
    }
}
