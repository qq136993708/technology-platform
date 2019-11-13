package com.pcitc.base.util;

import java.io.Serializable;
import java.util.Date;


public class DateSegment implements Serializable
{
	private static final long serialVersionUID = 2857189978348709487L;
	
	public static final String HOURLY_TYPE = "hourly";
	public static final String DAILY_TYPE = "daily";
	public static final String WEEKLY_TYPE = "weekly";
	public static final String MONTHLY_TYPE = "monthly";
	public static final String QUARTERLY_TYPE = "quarterly";
	public static final String YEARLY_TYPE = "yearly";
	
	private Date startDate;
	private Date endDate;
	private String type;
	
	public DateSegment()
	{
	}
	
	public DateSegment(Date startDate, Date endDate)
	{
		this.setStartDate(startDate);
		this.setEndDate(endDate);
	}
	
	public DateSegment(Date startDate, Date endDate, String type)
    {
        this(startDate, endDate);
        this.type = type;
    }
	
	@Override
    public int hashCode()
    {
        int startDateHashCode = this.startDate == null ? 0 : this.startDate.hashCode();
        int endDateHashCode = this.endDate == null ? 0 : this.endDate.hashCode();
        
        int result = startDateHashCode;
        result = 29 * result + endDateHashCode;
        
        return result;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null || !(other instanceof DateSegment))
        {
            return false;
        }
        
        DateSegment that = (DateSegment)other;
        if(this.startDate == null || this.endDate == null || that.startDate == null || that.endDate == null)
        {
            return false;
        }
        
        if(this.startDate.equals(that.startDate) && this.endDate.equals(that.endDate))
        {
            return true;
        }
        
        return false;
    }
	public void setStartDate(Date startDate)
    {
	    this.startDate = startDate;
    }

	public Date getStartDate()
    {
	    return startDate;
    }

	public void setEndDate(Date endDate)
    {
	    this.endDate = endDate;
    }

	public Date getEndDate()
    {
	    return endDate;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

}

