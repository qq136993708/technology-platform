package com.pcitc.service.system;

import com.pcitc.common.StringUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.util.Date;
import java.util.List;

public class TimedTaskManager {
    private TimedTaskManager() {
    }

    private static SchedulerFactory gSchedulerFactory = null;

    static {
        if (gSchedulerFactory == null) {
            gSchedulerFactory = new StdSchedulerFactory();
        }
    }

    public static void addTimedTask(TimedTask timedTask) {
        Class<? extends Job> jobClass = timedTask.getJobClass();
        String jobName = timedTask.getJobName();
        String jobGroupName = StringUtils.isNullOrEmpty(timedTask.getJobGroupName()) ? Scheduler.DEFAULT_GROUP : timedTask.getJobGroupName();
        String triggerName = jobName;
        String triggerGroupName = StringUtils.isNullOrEmpty(timedTask.getJobGroupName()) ? Scheduler.DEFAULT_GROUP : timedTask.getJobGroupName();
        Date startTime = timedTask.getStartTime() == null ? new Date() : timedTask.getStartTime();
        Date endTime = timedTask.getEndTime();
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            if (timedTask.getCronExpression() != null && timedTask.getCronExpression().length() > 0) {
                JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
                Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName).startAt(startTime).endAt(endTime)
                        .withSchedule(CronScheduleBuilder.cronSchedule(timedTask.getCronExpression()).withMisfireHandlingInstructionDoNothing()).build();
                if(sched.checkExists(JobKey.jobKey(triggerName,triggerGroupName))) {
                    sched.deleteJob(JobKey.jobKey(triggerName,triggerGroupName));
                }
                sched.scheduleJob(jobDetail, trigger);
            } else {
                DateBuilder.IntervalUnit cycleUnit = timedTask.getIntervalUnit();
                Integer timeInterval = timedTask.getTimeInterval();
                JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
                Trigger trigger = TriggerBuilder
                        .newTrigger()
                        .withIdentity(triggerName, triggerGroupName)
                        .startAt(startTime)
                        .endAt(endTime)
                        .withSchedule(
                                CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withInterval(timeInterval, cycleUnit)
                                        .withMisfireHandlingInstructionDoNothing()).build();
                sched.scheduleJob(jobDetail, trigger);
            }
            startup();
        } catch (SchedulerException e) {
            throw new RuntimeException("添加任务失败", e);
        }
    }

    public static void modifyTimedTask(String jobName, TimedTask timedTask) {
        modifyTimedTask(jobName, Scheduler.DEFAULT_GROUP, timedTask);
    }

    public static void modifyTimedTask(String jobName, String groupName, TimedTask timedTask) {
        groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
        try {
            removeTimedTask(jobName, groupName);
            addTimedTask(timedTask);
        } catch (Exception e) {
            throw new RuntimeException("删除任务失败", e);
        }
    }

    public static void removeTimedTask(String jobName, String groupName) {
        groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            JobKey jobKey = new JobKey(jobName, groupName);
            TriggerKey triggerKey = new TriggerKey(jobName, groupName);
            sched.pauseTrigger(triggerKey);
            sched.pauseJob(jobKey);
            sched.unscheduleJob(triggerKey);// 移除触发器
            sched.deleteJob(jobKey);// 删除任务
        } catch (Exception e) {
            throw new RuntimeException("删除任务失败", e);
        }
    }

    public static void removeTimedTask(String jobName) {
        removeTimedTask(jobName, Scheduler.DEFAULT_GROUP);
    }

    public static TimedTask getTimedTask(String jobName, String groupName) {
        groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;

        TimedTask timedTask = new TimedTask();
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            JobKey jobKey = new JobKey(jobName, groupName);
            JobDetail jobDetail = sched.getJobDetail(jobKey);
            timedTask.setJobName(jobName);
            timedTask.setJobGroupName(groupName);
            timedTask.setJobClass(jobDetail.getJobClass());

            List<? extends Trigger> triggers = sched.getTriggersOfJob(jobKey);
            Trigger trigger = triggers.get(0);
            timedTask.setStartTime(trigger.getStartTime());
            timedTask.setEndTime(trigger.getEndTime());
            if (trigger.getClass().equals(CronTriggerImpl.class)) {
                CronTriggerImpl cronTriggerImpl = (CronTriggerImpl) trigger;
                timedTask.setCronExpression(cronTriggerImpl.getCronExpression());
            } else if (trigger.getClass().equals(CalendarIntervalTriggerImpl.class)) {
                CalendarIntervalTriggerImpl calendarIntervalTriggerImpl = (CalendarIntervalTriggerImpl) trigger;
                timedTask.setIntervalUnit(calendarIntervalTriggerImpl.getRepeatIntervalUnit());
                timedTask.setTimeInterval(calendarIntervalTriggerImpl.getRepeatInterval());
            }
        } catch (Exception e) {
            throw new RuntimeException("获取任务失败", e);
        }
        return timedTask;
    }

    public static TimedTask getTimedTask(String jobName) {
        return getTimedTask(jobName, Scheduler.DEFAULT_GROUP);
    }

    public static void pauseTimedTask(String jobName) {
        pauseTimedTask(jobName, Scheduler.DEFAULT_GROUP);
    }

    public static void pauseTimedTask(String jobName, String groupName) {
        groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            TriggerKey triggerKey = new TriggerKey(jobName, groupName);
            sched.pauseTrigger(triggerKey);
            JobKey jobKey = new JobKey(jobName);
            sched.pauseJob(jobKey);
        } catch (Exception e) {
            throw new RuntimeException("暂停任务失败", e);
        }
    }

    public static void resumeTimedTask(String jobName) {
        resumeTimedTask(jobName, Scheduler.DEFAULT_GROUP);
    }

    public static void resumeTimedTask(String jobName, String groupName) {
        groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            TriggerKey triggerKey = new TriggerKey(jobName, groupName);
            sched.resumeTrigger(triggerKey);
            JobKey jobKey = new JobKey(jobName);
            sched.resumeJob(jobKey);
        } catch (Exception e) {
            throw new RuntimeException("恢复任务失败", e);
        }
    }

    public static void executeJob(String jobName) throws SchedulerException {
        executeJob(jobName, Scheduler.DEFAULT_GROUP);
    }

    public static void executeJob(String jobName, String groupName) throws SchedulerException {
        groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
        Scheduler sched = gSchedulerFactory.getScheduler();
        JobKey jobKey = new JobKey(jobName, groupName);
        sched.triggerJob(jobKey);
    }

    /**
     * 启动所有定时任务
     */
    public static void startup() {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            if (!sched.isStarted()) {
                sched.start();
            }
        } catch (Exception e) {
            throw new RuntimeException("启动任务失败", e);
        }
    }

    /**
     * 关闭所有定时任务
     */
    public static void shutdown() {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            if (!sched.isShutdown()) {
                sched.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException("关闭任务失败", e);
        }
    }

    public static void main(String[] args) {
        // TimedTask configuration1 = new TimedTask();
        // configuration1.setJobName("我的任务");
        // configuration1.setIntervalUnit(DateBuilder.IntervalUnit.SECOND);
        // configuration1.setTimeInterval(10);
        // configuration1.setJobClass(MyJob.class);
        // addTimedTask(configuration1);
        // TimedTask configuration2 = new TimedTask();
        // configuration2.setJobName("打印任务再次打印");
        // configuration2.setCronExpression("*/5 * * * * ?");
        // configuration2.setJobClass(PrintJob.class);
        // configuration2.setStartTime(new Date(new Date().getTime() + 2000));
        // addTimedTask(configuration2);
        // TimedTask configuration3 = new TimedTask();
        // configuration3.setJobName("打印任务");
        // configuration3.setCronExpression("*/1 * * * * ?");
        // configuration3.setJobClass(PrintJob.class);
        // configuration3.setStartTime(new Date(new Date().getTime() + 2000));
        // addTimedTask(configuration3);
    }
}
