package com.gvea.sender;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.Timer;

@Stateless
public class BatchJobA implements BatchJobInterface
{
    static Logger logger = Logger.getLogger("BatchJobA");

    @Asynchronous
    public void executeJob(Timer timer)
    {
        logger.info("Start of BatchJobA at " + new Date() + "...");
        JobInfo jobInfo = (JobInfo) timer.getInfo();
        try
        {
            logger.info("Running job: " + jobInfo);
            Thread.sleep(30000); //Sleep for 30 seconds
        }
        catch (InterruptedException ex)
        {
        }
        logger.info("End of BatchJobA at " + new Date());
    }

	
}