package com.gvea.sender;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "JobList")
@RequestScoped
public class JobList implements java.io.Serializable
{
    @EJB
    private JobSessionBean jobSessionBean;
    private List<JobInfo> jobList = null;

    /** Creates a new instance of JobList */
    public JobList()
    {
    }

    @PostConstruct
    public void initialize()
    {
        jobList = jobSessionBean.getJobList();
    }

    /*
     * Returns a list of active Jobs/Timers
     */
    public List<JobInfo> getJobs()
    {
        return jobList;
    }
}