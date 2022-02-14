package com.jzjr.helloxxljob.task.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class FirstJob extends IJobHandler {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    @XxlJob(value = "firstJob")
    public void execute() {
        log.info("xxl-job定时第{}次执行",atomicInteger.incrementAndGet());
        // 打印到日志文件的方式，打印之后的文件，在调度中心的调度日志管理中，操作选项下的执行日志可查看到
        XxlJobHelper.log("=====firstJob===== test XXL-JOB!");
        // 执行结束后返回的方式，同样在执行日志可查看
        XxlJobHelper.handleSuccess("执行成功");
    }
}
