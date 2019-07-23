package com.rainish.api.provider;

import com.rainish.api.IService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author jiajiao
 * @Date 2019/7/22 14:57
 */
@Service
public class IServiceImpl implements IService {
    @Override
    public String getInfo() {
        return "dubbo test info";
    }
}
