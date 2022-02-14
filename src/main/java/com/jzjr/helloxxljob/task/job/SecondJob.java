package com.jzjr.helloxxljob.task.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class SecondJob extends IJobHandler {

    @Override
    @XxlJob(value = "secondJob")
    public void execute() throws Exception {
        // 2.3.0版本获取参数的方式
        // 注意xxl-job统一只接受一个String类型的参数，如果有多个参数，请自定义规则，获取到参数后自行切割
        String param = XxlJobHelper.getJobParam();
        // 打印到日志文件的方式，打印之后的文件，在调度中心的调度日志管理中，操作选项下的执行日志可查看到
        XxlJobHelper.log("=====DemoJobHandler===== test XXL-JOB!");
        // 执行结束后返回的方式，同样在执行日志可查看
        XxlJobHelper.handleSuccess("执行成功");
    }
}
