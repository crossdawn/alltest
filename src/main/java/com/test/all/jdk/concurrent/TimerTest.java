package com.test.all.jdk.concurrent;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTest {
    static int i=1;

    public static void main(String[] args) {
        Timer timer = new Timer();
        Deque<Integer> stack = new ArrayDeque<>();
        Stack<Integer> stack1 = new Stack<>();
        //第3和第4个task的执行顺序是不确定的,因为时间片的切换导致的微小差别
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if(i==2){
//                    throw new RuntimeException();
//                }
//                System.out.println("执行了"+i+++"次");
//            }
//        }, getDelayTime(3), 1000);    //3, -3

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3);
//        scheduledThreadPoolExecutor.execute(()->{ if(i==2){
//            throw new RuntimeException();
//        }
//            System.out.println("执行了"+i+++"次");},10, TimeUnit.SECONDS);


//        for (int j = 0; j < 3; j++) {
            scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
                if (i == 2) {
                    System.err.println("yichan");

//                    throw new RuntimeException();
                }
                System.out.println("执行了" + i++ + "次");
            }, 0L, 5, TimeUnit.SECONDS);
//        }

//		test1();		//测试schedule功能
//		test2();		//测试所有scheduleAtFixedRate功能
//		test3();		//测试isDeamon对Timer的影响
//		test4();		//测试AtFixedRateSchedule和schedule区别
//		test5();		//测试schedule在过去时间的表现, 如果firstTime是过去时间, 则立即执行, 如果是未来时间, 则会等待时间到之后执行, 如果是传入延迟时间, 则延迟时间不能为负数, 否则报错
//		test6();
//        test7();

    }

    public static void test1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行了1次");
            }
        }, 1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行了2次");
            }
        }, getDelayTime(2));

        //第3和第4个task的执行顺序是不确定的,因为时间片的切换导致的微小差别
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(i==2){
                    throw new RuntimeException();
                }
                i++;
                System.out.println("执行了3次");
            }
        }, getDelayTime(3), 1000);    //3, -3

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("执行了4次");
            }
        }, 1000, 1000);
    }

    public static void test2() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("AtFixedRate1");
            }
        }, getDelayTime(1), 1000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("AtFixedRate2");
            }
        }, 2000, 1000);
    }

    public static void test3() {
        Timer timer = new Timer("isDeamon", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("isDeamon");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, getDelayTime(2), 2000);
    }

    public static void test4() {
        Timer timer = new Timer("AtFixedRate", false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("schedule");
            }
        }, getDelayTime(-5), 2000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("scheduleAtFixedRate");
            }
        }, getDelayTime(-5), 2000);
    }

    public static void test5() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试时间为过去时间和将来时间对schedule的影响");
            }
        }, getDelayTime(-5));    //立即执行
    }

    public static void test6() {
        //purge: 清洗, 净化
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试purge1");
            }
        }, getDelayTime(1), 1000);
        System.out.println("purge: " + timer.purge());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试purge2");
            }
        }, getDelayTime(1), 1000);
    }

    public static void test7() {
        //将7和6对比看
        Timer timer = new Timer();
        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                System.out.println("测试purge1");
                this.cancel();
            }
        }
        for (int i = 0; i < 100; i++) {
            MyTimerTask mt = new MyTimerTask();
            timer.schedule(mt, getDelayTime(1), 1000);
            mt.cancel();
        }
//		timer.cancel();
        System.out.println("此时可以移除取消的任务数为100个: " + timer.purge());
		/*timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("我现在还可以执行~~");
			}
		}, getDelayTime(2));*/


        for (int i = 0; i < 100; i++) {
            MyTimerTask mt = new MyTimerTask();
            mt.cancel();
            timer.schedule(mt, getDelayTime(1), 1000);
        }
        System.out.println("此时可以移除取消的任务数为100个: " + timer.purge());
        ///
    }

    //给定一个时间，返回给定多久以后的Date
    public static Date getDelayTime(int howlong) {
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.SECOND, howlong + cld.get(Calendar.SECOND));
        return cld.getTime();
    }

}
