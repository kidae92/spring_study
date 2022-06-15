package Gidae.study;

import Gidae.study.trace.LogTrace.FieldLogTrace;
import Gidae.study.trace.LogTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();

    }
}
