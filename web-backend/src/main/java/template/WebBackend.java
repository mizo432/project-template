package template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;

/**
 * バックエンドアプリケーション起動クラス
 */
@SpringBootApplication
@ComponentScans
        ({@ComponentScan("com.undecided")})
@ImportResource({"classpath:META-INF/spring/applicationContext.xml"})
public class WebBackend {

    /**
     * 起動用ブートストラップ
     *
     * @param args 引数
     */
    public static void main(String[] args) {
        SpringApplication.run(WebBackend.class, args);

    }


}
