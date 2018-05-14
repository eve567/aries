package net.ufrog.aries.sample.provider;

import net.ufrog.aries.sample.client.SampleClient;
import net.ufrog.aries.sample.client.contracts.ResultCode;
import net.ufrog.aries.sample.client.contracts.SampleResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 样例控制器
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-22
 * @since 0.1
 */
@RestController
public class SampleController implements SampleClient {

    @Override
    public SampleResponse test() {
        SampleResponse sampleResp = new SampleResponse();
        sampleResp.setCode("test");
        sampleResp.setName("success id: test");
        sampleResp.setResultCode(ResultCode.SUCCESS);
        return sampleResp;
    }

    @SuppressWarnings("MVCPathVariableInspection")
    @Override
    public SampleResponse findById(@PathVariable("id") String id) {
        SampleResponse sampleResp = new SampleResponse();
        sampleResp.setCode(id);
        sampleResp.setName("success id: " + id);
        sampleResp.setResultCode(ResultCode.SUCCESS);
        return sampleResp;
    }
}
