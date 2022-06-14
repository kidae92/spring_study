package Gidae.study.app.V1;

import Gidae.study.trace.HelloTrace.HelloTraceV1;
import Gidae.study.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){
            TraceStatus status = null;
            try {
                status = trace.begin("OrderController.orderItem()");
                orderRepositoryV1.save(itemId);
                trace.end(status);

            } catch (Exception e){
                trace.exception(status, e);
                throw e; //예외를 다시 던줘야함.

            }
    }
}
