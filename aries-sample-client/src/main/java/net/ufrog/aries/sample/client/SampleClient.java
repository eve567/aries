package net.ufrog.aries.sample.client;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.ufrog.aries.sample.client.contract.SampleResp;
import net.ufrog.aries.sample.client.fallbacks.SampleClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 样例客户端
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
@FeignClient(name = "aries-sample-provider", fallbackFactory = SampleClientFallbackFactory.class)
@RequestMapping("/sample")
public interface SampleClient {

    /**
     * 通过编号查询样例
     *
     * @param id 编号
     * @return 样例对象
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询样例", notes = "我就是个测试")
    @ApiImplicitParam(value = "样例编号", name = "id", required = true, paramType = "path", dataTypeClass = String.class)
    SampleResp findById(@PathVariable("id") String id);
}
