package com.fastcampus.resttemplatesandbox.batch;

import com.fastcampus.resttemplatesandbox.service.UpbitMinuteCandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class SimpleJobConfiguration {

    private final UpbitMinuteCandleService upbitMinuteService;

    @Bean
    public Job simpleJob1(JobRepository jobRepository, Step simpleStep1) {
        return new JobBuilder("simpleJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(simpleStep1)
                .build();
    }

    @Bean
    public Step simpleStep1(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("simpleStep1", jobRepository)
                .tasklet(testTasklet, platformTransactionManager)
                .build();
    }

    @Bean
    public Tasklet testTasklet() {
        return (((contribution, chunkContext) -> {
            Map<String, Object> params = chunkContext.getStepContext().getJobParameters();
            Integer unit = Integer.valueOf(params.get("unit").toString());
            String market = params.get("market").toString();

            upbitMinuteService.callUpbit(unit, market);
            System.out.println(">>> This is step 1");
            return RepeatStatus.FINISHED;
        }));
    }
}
