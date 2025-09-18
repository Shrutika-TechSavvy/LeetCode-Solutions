class TaskManager {
  class Task{
    int uid;
    int tid;
    int p;

    Task(int u, int t, int pr){
      this.uid = u;
      this.tid = t;
      this.p = pr;
    } 
  }

  HashMap<Integer, Task> taskIdToTask = new HashMap<>();
  PriorityQueue<Task> exec;

  public TaskManager(List<List<Integer>> tasks) {
    exec = new PriorityQueue<>((a, b) -> {
      if(a.p != b.p) return b.p - a.p;
      else return b.tid - a.tid;
    });

    for(List<Integer> taskData: tasks){
      add(taskData.get(0), taskData.get(1), taskData.get(2));
    }
  }
  
  public void add(int userId, int taskId, int priority) {
    Task t = new Task(userId, taskId, priority);

    taskIdToTask.put(taskId, t);
    exec.add(t);
  }
  
  public void edit(int taskId, int newPriority) {
    Task oldTask = taskIdToTask.get(taskId);
    Task newTask = new Task(oldTask.uid, oldTask.tid, newPriority);
    taskIdToTask.put(taskId, newTask);
    exec.add(newTask);
  }
  
  public void rmv(int taskId) {
    taskIdToTask.remove(taskId);
  }
  
  public int execTop() {
    while(!exec.isEmpty()){
      Task topTask = exec.peek();

      if(taskIdToTask.containsKey(topTask.tid) && taskIdToTask.get(topTask.tid) == topTask){
        exec.poll();
        taskIdToTask.remove(topTask.tid);
        return topTask.uid;
      }

      exec.poll();
    }

    return -1;
  }
}