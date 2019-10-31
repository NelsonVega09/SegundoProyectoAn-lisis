package paralelismo;


public class Paralelismo {

        
        public static void main(String[] args) {
                
                int cores = Runtime.getRuntime().availableProcessors();
                System.out.println("Cores: "+cores);
                
                
                //Creating and starting thread
                
                Thread simpleThread = new Thread();
                simpleThread.setName("Thread #1");
                simpleThread.start();
                System.out.println("#1 simple thread: "+simpleThread.getName());
                
                
                //Creating 2
                
               ExtendsThread threadExtend = new ExtendsThread();
                threadExtend.start();
                
                
                //Creating 3
                
                Thread anonymousSubClass = new Thread(){
                        @Override
                        public void run(){
                                System.out.println("#3 Anonymous sub class thread");
                        }
                };
                anonymousSubClass.start();
                
                // Creating 4
                
                ImplementsRunnable runThread = new ImplementsRunnable();
                runThread.run();
                
                
                
                // Creating 5
                Runnable myRunnable = new Runnable(){
                        @Override
                        public void run(){
                                System.out.println("#5 Runnables implement thread");
                        }
                };
                myRunnable.run();
                
                
                
                //Creating 6
                
                Runnable runnable
                        = () -> {
                                System.out.println("#6 Lambda Runnable");
                        };
                runnable.run();
        }
        
}
