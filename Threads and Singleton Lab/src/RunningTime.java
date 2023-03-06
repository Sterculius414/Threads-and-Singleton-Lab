class RunningTime implements Runnable {
    private final String threadName;
    private Thread t;
    RunningTime(String name){
    threadName = name;
    }
    @Override
    public void run() {
        {
        for (int i = 6; i > 0; i--)
            try {
                Thread.sleep(5); }
            catch (InterruptedException e) {
                throw new RuntimeException(e); }
        }
    }
    public void start () {
    if (t == null) {
        t = new Thread ( this, threadName);
        t.start ();
        }
    }
}