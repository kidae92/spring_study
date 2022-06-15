package Gidae.study.app.V3;



import Gidae.study.trace.LogTrace.LogTrace;
import Gidae.study.trace.TraceId;
import Gidae.study.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV1;
    private final LogTrace trace;

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
