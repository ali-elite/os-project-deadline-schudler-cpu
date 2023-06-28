public class Task implements Comparable<Task> {
    String name;
    int priority;
    long arriveTime;
    long cbt;
    long deadline;
    long remainingTime;
    boolean isFinished;
    long finishedTime = 0;

    public Task(String name, int priority, long arriveTime, long cbt, long deadline) {
        this.name = name;
        this.priority = priority;
        this.arriveTime = arriveTime;
        this.cbt = cbt;
        this.deadline = deadline;
        this.remainingTime = cbt;
    }

    public String getName() {
        return name;
    }

    public long getFinishedTime() {
        return finishedTime;
    }

    public int getPriority() {
        return priority;
    }

    public long getArriveTime() {
        return arriveTime;
    }

    public long getCbt() {
        return cbt;
    }

    public long getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task " + "id=" + name + ", arriveTime=" + arriveTime + ", cbt=" + cbt + ", finish at=" + finishedTime +
                ", deadline=" + deadline + ", isFinished.";
    }

    @Override
    public int compareTo(Task o) {
        if (priority == o.priority)
            return Long.compare(deadline, o.deadline);
        else return Long.compare(priority, o.priority);
    }
}
