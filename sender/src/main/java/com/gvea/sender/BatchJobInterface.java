package com.gvea.sender;

import javax.ejb.Local;

@Local
public interface BatchJobInterface
{
    public void executeJob(javax.ejb.Timer timer);
}
