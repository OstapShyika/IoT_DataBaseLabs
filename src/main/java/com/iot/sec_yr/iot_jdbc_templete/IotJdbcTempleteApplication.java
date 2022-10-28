package com.iot.sec_yr.iot_jdbc_templete;

import com.iot.sec_yr.iot_jdbc_templete.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotJdbcTempleteApplication implements CommandLineRunner {
    private final View view;

    public IotJdbcTempleteApplication(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        SpringApplication.run(IotJdbcTempleteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        view.show();
    }
}
