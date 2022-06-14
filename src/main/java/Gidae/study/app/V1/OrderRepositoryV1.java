package Gidae.study.app.V1;

import Gidae.study.trace.HelloTrace.HelloTraceV1;
import Gidae.study.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;


    public void save(String itemId){

        TraceStatus status = null;
        //저장 로직
        try {
            status = trace.begin("OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);

            trace.end(status);

        } catch (Exception e){
            trace.exception(status, e);
            throw e; //예외를 다시 던줘야함.

        }
    }
    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
