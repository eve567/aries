package net.ufrog.aries.sample.client.fallbackfactories;

import net.ufrog.aries.common.contract.ClientFallbackFactory;
import net.ufrog.aries.common.contract.Response;
import net.ufrog.aries.sample.client.SampleClient;
import net.ufrog.aries.sample.client.contracts.ResultCode;
import net.ufrog.aries.sample.client.contracts.SampleResponse;
import org.springframework.stereotype.Component;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-05-08
 * @since 3.0.0
 */
@Component
public class SampleClientFallbackFactory extends ClientFallbackFactory<SampleClient> {

    @Override
    public SampleClient getClientFallback() {
        return new SampleClient() {

            @Override
            public SampleResponse test() {
                return Response.createResp(ResultCode.UNKNOW, SampleResponse.class);
            }

            @Override
            public SampleResponse findById(String id) {
                return Response.createResp(ResultCode.UNKNOW, SampleResponse.class);
            }
        };
    }
}
