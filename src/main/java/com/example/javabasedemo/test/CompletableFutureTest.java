package com.example.javabasedemo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author 86187
 */
public class CompletableFutureTest {

    private static List<Integer> list = initList();

    private static List<Integer> initList() {
        List<Integer> tempList = new ArrayList<>();
        tempList.add(1000);
        tempList.add(2000);
        tempList.add(3000);
        tempList.add(4000);
        tempList.add(5000);
        return Collections.unmodifiableList(tempList);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        testCompletableThenApply();
    }


    private static void testCompletableThenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            return "dev";
        }).thenApply(a -> {
            if(Objects.equals(a,"dev")){
                return "dev";
            }
            return "prod";
        });

        System.out.println("当前环境为:" + cp1.get());

        //输出: 当前环境为:dev
    }

    public static void testCompletableThenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> "dev");

        CompletableFuture<Void> cp2 =  cp1.thenAccept(a -> System.out.println("上一个任务的返回结果为: " + a));

        cp2.get();
    }


    private static void testCompletableThenRun() {
        CompletableFuture.runAsync(()-> System.out.println("任务1执行完成")).thenRun(()-> System.out.println("任务2执行完成"));
    }

    public static void replaceCountdownLatch() {
        List<CompletableFuture<Integer>> collect = list.stream().map(item -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return item;
        })).collect(Collectors.toList());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[0]));
        voidCompletableFuture.join();
        System.out.println("-------------------");
        collect.forEach(item ->
                {
                    try {
                        System.out.println(item.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
        );
    }


}
