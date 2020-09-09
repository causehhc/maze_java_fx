package sample;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CreatMap {
    protected int x = -1;// 初始化迷宫大小
    protected int y = -1;
    int[][] map;

    CreatMap() {

    }

    int[][] trans() {// 传回map数据
        return map;
    }

    void setMap(int x, int y) {// 初始化地图
        map = new int[x][y];
        while (true) {// 生成起点必须为奇数
            this.x = (int) (Math.random() * (x - 4)) + 2;
            this.y = (int) (Math.random() * (y - 4)) + 2;
            if (this.x % 2 == 0 && this.y % 2 == 0) {
                break;
            }
        }
        for (int i = 2; i < map.length - 1; i += 2) {
            for (int j = 2; j < map[i].length - 1; j += 2) {
                map[i][j] = 1;
            }
        }
    }

    void clear() {// 清空路径
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 || map[i][j] == 3) {
                    map[i][j] = 8;
                }
            }
        }
    }

    void print() {// 控制台带颜色打印
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < map.length - 1; i++) {
            System.out.printf("%2d", i);
            for (int j = 1; j < map[i].length - 1; j++) {
                if (i == 0) {
                    if (j > 9) {
                        if (j % 10 == 0) {
                            System.out.print("\u001b[1;31m0\u001b[0m");
                        } else {
                            System.out.print(j % 10);
                        }
                    } else {
                        System.out.print(j);
                    }
                } else {
                    if (map[i][j] == 0) {
                        System.out.print("\u001b[40m0\u001b[0m");
                    } else if (map[i][j] == 8) {
                        System.out.print("\u001b[37m8\u001b[0m");
                    } else if (map[i][j] == 3) {
                        System.out.print("\u001b[31m3\u001b[0m");
                    } else {
                        System.out.print("\u001b[1;31m1\u001b[0m");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
//		in.nextLine();
        in.close();
    }

    static void print(int[][] map) {// 控制台带颜色打印
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < map.length - 1; i++) {
            System.out.printf("%2d", i);
            for (int j = 1; j < map[i].length - 1; j++) {
                if (i == 0) {
                    if (j > 9) {
                        if (j % 10 == 0) {
                            System.out.print("\u001b[1;31m0\u001b[0m");
                        } else {
                            System.out.print(j % 10);
                        }
                    } else {
                        System.out.print(j);
                    }
                } else {
                    if (map[i][j] == 0) {
                        System.out.print("\u001b[40m0\u001b[0m");
                    } else if (map[i][j] == 8) {
                        System.out.print("\u001b[37m8\u001b[0m");
                    } else if (map[i][j] == 3) {
                        System.out.print("\u001b[31m3\u001b[0m");
                    } else {
                        System.out.print("\u001b[1;31m1\u001b[0m");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
//		in.nextLine();
        in.close();
    }

    void draw() {// 展示地图
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        in.nextLine();
        in.close();
    }

    static void draw(int[][] map) {// 展示地图
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        in.nextLine();
        in.close();
    }

    void draw(int x, int y) {// 展示地图（带扫描位置）
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == x && j == y) {
                    System.out.print("K");
                } else if (map[i][j] == 0) {
                    System.out.print(" ");
                } else if (map[i][j] == 1) {
                    System.out.print(map[i][j]);
                } else
                    System.out.print(map[i][j]);
            }
            System.out.println();
        }
        in.nextLine();
        in.close();
    }

    private boolean judge(int x, int y) {// 判断生成条件
        if (map[x][y + 2] + map[x][y + 1] == 1 || map[x - 2][y] + map[x - 1][y] == 1
                || map[x][y - 2] + map[x][y - 1] == 1 || map[x + 2][y] + map[x + 1][y] == 1) {
            return true;
        }
        return false;
    }

    private boolean recursion(int x, int y) {// 回溯法
//		System.out.println("push in:"+x+"+"+y);
//		this.draw();
        while (judge(x, y)) {
            int d = (int) (Math.random() * 4);
            switch (d) {
                case 0: {
                    if (map[x][y + 1] + map[x][y + 2] == 1) {
                        map[x][y + 1] = map[x][y + 2] = 8;
                        recursion(x, y + 2);
                    }
                    break;
                }
                case 1: {
                    if (map[x - 1][y] + map[x - 2][y] == 1) {
                        map[x - 1][y] = map[x - 2][y] = 8;
                        recursion(x - 2, y);
                    }
                    break;
                }
                case 2: {
                    if (map[x][y - 1] + map[x][y - 2] == 1) {
                        map[x][y - 1] = map[x][y - 2] = 8;
                        recursion(x, y - 2);
                    }
                    break;
                }
                case 3: {
                    if (map[x + 1][y] + map[x + 2][y] == 1) {
                        map[x + 1][y] = map[x + 2][y] = 8;
                        recursion(x + 2, y);
                    }
                    break;
                }
            }
        }
//		System.out.println("pop out:" + x + "+" + y);
        return false;
    }

    void recur() {// 方法调用
        recursion(x, y);
    }

    void stack() {// 深度优先-栈
        Stack<Integer> st = new Stack<Integer>();
        st.push(y);
        st.push(x);
        do {
            x = st.pop();
            y = st.pop();
            st.push(y);
            st.push(x);
            while (judge(x, y)) {
                int d = (int) (Math.random() * 4);
                switch (d) {
                    case 0: {
                        if (map[x][y + 1] + map[x][y + 2] == 1) {
                            map[x][y + 1] = map[x][y + 2] = 8;
                            st.push(y + 2);
                            st.push(x);
                        }
                        break;
                    }
                    case 1: {
                        if (map[x - 1][y] + map[x - 2][y] == 1) {
                            map[x - 1][y] = map[x - 2][y] = 8;
                            st.push(y);
                            st.push(x - 2);
                        }
                        break;
                    }
                    case 2: {
                        if (map[x][y - 1] + map[x][y - 2] == 1) {
                            map[x][y - 1] = map[x][y - 2] = 8;
                            st.push(y - 2);
                            st.push(x);
                        }
                        break;
                    }
                    case 3: {
                        if (map[x + 1][y] + map[x + 2][y] == 1) {
                            map[x + 1][y] = map[x + 2][y] = 8;
                            st.push(y);
                            st.push(x + 2);
                        }
                        break;
                    }
                }
                x = st.pop();
                y = st.pop();
                st.push(y);
                st.push(x);

//				System.out.println("push in:"+x+"+"+y);
//				System.out.print("stack:");
//				for(Integer q : st){
//		            System.out.print(q+" ");
//		        }
//				System.out.println();
//				draw();
            }
            x = st.pop();
            y = st.pop();

//			System.out.println("pop out:"+x+"+"+y);

        } while (!st.empty());
    }

    void queue(int c) {// 广度优先-队列 （c0简单c1难）
        LinkedList<Integer> que = new LinkedList<Integer>();
        que.offer(x);
        que.offer(y);
        do {
            int n = 0;
            Integer[] temp = new Integer[que.size()];
            que.toArray(temp);
            do {
                n = (int) (Math.random() * que.size());
            } while (n % 2 != 0);
            x = temp[n];
            y = temp[n + 1];

            while (judge(x, y)) {
                if (c == 1) {// 升级:更复杂（小死胡同更少）（一个点完整之前继续随机选择）
                    Integer[] temp2 = new Integer[que.size()];
                    que.toArray(temp2);
                    do {
                        n = (int) (Math.random() * que.size());
                    } while (n % 2 != 0);
                    x = temp2[n];
                    y = temp2[n + 1];
                }
                int d = (int) (Math.random() * 4);
                switch (d) {
                    case 0: {
                        if (map[x][y + 1] + map[x][y + 2] == 1) {
                            map[x][y] = map[x][y + 1] = map[x][y + 2] = 8;
                            que.offer(x);
                            que.offer(y + 2);
                        }
                        break;
                    }
                    case 1: {
                        if (map[x - 1][y] + map[x - 2][y] == 1) {
                            map[x][y] = map[x - 1][y] = map[x - 2][y] = 8;
                            que.offer(x - 2);
                            que.offer(y);
                        }
                        break;
                    }
                    case 2: {
                        if (map[x][y - 1] + map[x][y - 2] == 1) {
                            map[x][y] = map[x][y - 1] = map[x][y - 2] = 8;
                            que.offer(x);
                            que.offer(y - 2);
                        }
                        break;
                    }
                    case 3: {
                        if (map[x + 1][y] + map[x + 2][y] == 1) {
                            map[x][y] = map[x + 1][y] = map[x + 2][y] = 8;
                            que.offer(x + 2);
                            que.offer(y);
                        }
                        break;
                    }
                }

//				System.out.print("queue:");
//				for(Integer q : que){
//		            System.out.print(q+" ");
//		        }
//				System.out.println();
//				draw();
            }
            que.remove(n);
            que.remove(n);

//			System.out.print("queue:");
//			for(Integer q : que){
//	            System.out.print(q+" ");
//	        }
//			System.out.println();
//			draw(map);
        } while (!que.isEmpty());
    }
}
