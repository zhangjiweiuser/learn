package com.zhang.xxljob.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class ParentJob {

    @XxlJob("parentJob")
    public ReturnT<String> parentJob(String param) {

//        XxlJobHelper.log("输出日志");
        System.out.println("---------------");
        System.out.println("parentJob:" + param);
        // 参数
//        System.out.println(XxlJobHelper.getJobParam());
//        // 多少台机器
//        System.out.println(XxlJobHelper.getShardTotal());
//        // 现在是第几台机器
//        System.out.println(XxlJobHelper.getShardIndex());
        System.out.println("---------------");
        return ReturnT.SUCCESS;
    }
}
