package extra_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1260_Graph {

    static int n; //정점의 개수
    static int m; //간선의 개수
    static int start_v; //탐색을 시작할 정점
    static int[][] graph;

    static ArrayList<Integer> check = new ArrayList<>();

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start_v = sc.nextInt();

        graph = new int[m][2];
        for (int i = 0; i < m; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
        }
        sc.close();

        DFS(start_v);
        System.out.println();
        check.clear();


        BFS(start_v);

    }

    //깊이 우선 탐색
    static int DFS(int v) {
        ArrayList<Integer> search;
        for (int i = 0; i < check.size(); i++) {
            if (check.get(i) == v) return 0;
        }
        check.add(v);
        System.out.print(v + " ");
        if (check.size() == n) {
            return 0;
        }

        search = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (graph[i][0] == v) {
                search.add(graph[i][1]);
            }
            if (graph[i][1] == v) {
                search.add(graph[i][0]);
            }
        }
        Collections.sort(search);

        for (int i = 0; i < search.size(); i++) {
            DFS(search.get(i));
        }

        return 0;
    }

    //너비 우선 탐색
    static int BFS (int v) {


        return 0;
    }

}

/*
4 5 1
        1 2
        1 3
        1 4
        2 4
        3 4
 */
/*
5 5 3
5 4
5 2
1 2
3 4
3 1
 */
/*
1000 1 1000
999 1000
 */