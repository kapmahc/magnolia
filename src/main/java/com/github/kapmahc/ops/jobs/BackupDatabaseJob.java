package com.github.kapmahc.ops.jobs;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by flamen on 16-12-13.
 */
public class BackupDatabaseJob {
    //every day 3am
    @Scheduled(cron = "0 0 3 * * ?")
    public void run() {

    }
}
