package com.undefined;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * アプリケーションのブートストラップ.
 */
@SpringBootApplication
public class WebFrontReactiveApplication {

    /**
     * 起動用スートストラップ.
     *
     * @param args 引数
     */
    public static void main(String[] args) {
        SpringApplication.run(WebFrontReactiveApplication.class, args);
    }

}
