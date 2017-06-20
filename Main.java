

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static Set<String> recepients = new HashSet<>();


    public synchronized static void main(String args[]) throws MalformedURLException {
        Manager manager = new Manager();
        recepients.add("tcpoleg@gmail.com");
        Thread managerThread = new Thread(manager);
        managerThread.setDaemon(true);
        managerThread.start();
        Scanner sc = new Scanner(System.in);
        while (true){
            String command = sc.next();
            switch (command){
                case "exit":
                    System.exit(0);
                    break;
                case "send":
                    System.out.print("send?");
                    synchronized (managerThread) {
                        managerThread.notify();
                    }

                    break;
                case "addRecepient":
                    System.out.println("Count?");
                    int c = sc.nextInt();
                    for (int i = 0; i<c;i++) {
                        System.out.println("Enter email");
                        String mail = sc.next();
                        recepients.add(mail);
                    }
                    break;
                }
            }
        }

    }


