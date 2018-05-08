package net.ufrog.aries.sample.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ufrog.aries.sample.client.contracts.SampleResponse;
import net.ufrog.aries.sample.client.fallbackfactories.SampleClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
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
@Api("样例服务")
public interface SampleClient {

    /**
     * 通过编号查询样例
     *
     * @param id 编号
     * @return 样例对象
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询样例", notes = "我就是个测试")
    SampleResponse findById(@PathVariable("id") String id);
}
