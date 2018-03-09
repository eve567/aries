package net.ufrog.aries.sample.consumer;

import net.ufrog.aries.sample.client.SampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-22
 * @since 0.1
 */
@Controller
public class IndexController {

    /** 样例客户端 */
    private SampleClient sampleClient;

    /**
     * 构造函数
     *
     * @param sampleClient 样例客户端
     */
    @Autowired
    public IndexController(SampleClient sampleClient) {
        this.sampleClient = sampleClient;
    }

    /**
     * 索引
     *
     * @return 测试结果
     */
    @GetMapping({"", "/", "/index"})
    @ResponseBody
    public Object index() {
        return sampleClient.findById("1");
    }
}
