package net.ufrog.aries.sample.domain;

import net.ufrog.aries.sample.domain.models.Sample;

/**
 * 模型工具
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
public class Models {

    /** 构造函数 */
    private Models() {}

    /**
     * @param name 名称
     * @param code 代码
     * @return 样例实例
     */
    public Sample newSample(String name, String code) {
        Sample sample = new Sample();
        sample.setName(name);
        sample.setCode(code);
        return sample;
    }
}
