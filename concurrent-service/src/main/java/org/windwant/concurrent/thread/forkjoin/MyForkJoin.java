package org.windwant.concurrent.thread.forkjoin;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoinPool 负责执行ForkJoinTask，通常继承以下两个类
 * RecursiveTask 带返回值的ForkJoinTask
 * RecursiveAction 不带返回值的ForkJoinTask
 *
 * 编写Task：计算并返回结果；继续分解任务，添加到执行队列，并等待聚合返回结果
 *
 * fork: 将任务放入待执行队列
 * join: 获取任务，等待执行完成，获取结果
 *
 * Created by windwant on 2016/6/3.
 */
public class MyForkJoin {

    public static void main(String[] args) {
        testFibonacci();
    }

    public static void testFibonacci(){
        System.out.println(new ForkJoinPool().invoke(new Fibonacci(30)));
    }

    /**
     * 统计文件数量
     */
    public static void testCalcFileNum(){
        MyCalcFileNumTask task = new MyCalcFileNumTask(new File("D:\\MPS"));
        Integer sum = new ForkJoinPool().invoke(task);
        System.out.println(sum);
    }

    /**
     * 列显
     */
    public static void testListFileNum(){
        MyListFileTask task = new MyListFileTask(new File("D:\\MPS"));
        List<String> files = new ForkJoinPool().invoke(task);
        files.stream().forEach(file -> System.out.println(file));
    }

    /**
     * 按类型 列显
     */
    public static void testCalcAndListFileNum(){
        MyCalcAndListFileTask task = new MyCalcAndListFileTask(new File("D:\\MPS"));
        Map<String, List<String>> files = new ForkJoinPool().invoke(task);
        files.keySet().stream().forEach(item-> {
            System.out.println("type: " + item);
            files.get(item).stream().forEach(file-> System.out.println(file));
        });
    }
}

