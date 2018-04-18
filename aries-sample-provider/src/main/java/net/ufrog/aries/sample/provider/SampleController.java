package net.ufrog.aries.sample.provider;

import net.ufrog.aries.sample.client.SampleClient;
import net.ufrog.aries.sample.client.contract.ResultCode;
import net.ufrog.aries.sample.client.contract.SampleResp;
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
@SuppressWarnings("MVCPathVariableInspection")
public class SampleController implements SampleClient {

    @Override
    public SampleResp findById(@PathVariable("id") String id) {
        SampleResp sampleResp = new SampleResp();
        sampleResp.setCode(id);
        sampleResp.setName("成功");
        sampleResp.setResultCode(ResultCode.SUCCESS);
        return sampleResp;
    }
}
