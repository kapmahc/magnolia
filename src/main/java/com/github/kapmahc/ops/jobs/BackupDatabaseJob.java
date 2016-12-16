package com.github.kapmahc.ops.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
@Component("ops.backupDatabaseJob")
public class BackupDatabaseJob {
    //every day 3am
    @Scheduled(cron = "0 0 3 * * ?")
    public void run() {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData meta = conn.getMetaData();
            logger.info("Backup database: {}", meta.getURL());
            URI uri = URI.create(meta.getURL().substring(5));
            String cmd;
            switch (meta.getDatabaseProductName()) {
                case "PostgreSQL":
                    cmd = String.format(
                            "pg_dump --dbname=postgresql://%s:%s@%s:%d/%s",
                            meta.getUserName(),
                            password,
                            uri.getHost(),
                            uri.getPort(),
                            conn.getCatalog()
                    );
                    break;
                case "MySQL":
                    cmd = String.format(
                            "mysqldump --opt -h %s -P %d -u %s -p%s %s",
                            uri.getHost(),
                            uri.getPort(),
                            meta.getUserName(),
                            password,
                            conn.getCatalog()
                    );
                    break;
                default:
                    logger.info("Unknown database: {} {}", meta.getDatabaseProductName(), meta.getDatabaseProductVersion());
                    return;
            }
            DateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmss");
            cmd = String.format(
                    "%s | gzip > %s/%s.sql.gz",
                    cmd,
                    BACKUP,
                    fmt.format(new Date())
            );
            logger.debug(cmd);
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
        } catch (SQLException | IOException | InterruptedException e) {
            logger.error("Ops!", e);
        }
    }

    @PostConstruct
    void init() {
        new File(BACKUP).mkdirs();
    }

    @Resource
    DataSource dataSource;
    @Value("${spring.datasource.password}")
    String password;
    private final String BACKUP = "tmp/backups";
    private static final Logger logger = LoggerFactory.getLogger(BackupDatabaseJob.class);
}
