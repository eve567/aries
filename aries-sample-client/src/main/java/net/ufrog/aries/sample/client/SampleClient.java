package net.ufrog.aries.sample.client;

import net.ufrog.aries.sample.client.contract.Resp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 样例客户端
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
@FeignClient
@RequestMapping("/sample")
public interface SampleClient {

    /**
     * 通过编号查询样例
     *
     * @param id 编号
     * @return 样例对象
     */
    @GetMapping("/{id}")
    Resp findById(@PathVariable("id") String id);
}
