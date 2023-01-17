/*
c1-clear
어떤 수열을 만들어내는 다음과 같은 알고리즘을 생각해보자.
어떤 정수 n에서 시작해 n이 짝수면 2로 나누고, 홀수면 3을 곱한 다음 1을 더한다.
이렇게 해서 새로 만들어진 숫자를 n으로 놓고 n=1이 될 때까지 같은 작업을 계속 반복한다.
예를 들어, n=22이면 다음과 같은 수열이 만들어진다.
22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
아직 증명되진 않았지만 모든 정수 n에 대해 이 알고리즘을 적용시키면 결국에는 n=1에 이르게 되는 것으로 추측된다.
그리고 이 가설은 적어도 1,000,000까지의 정수에 대해서는 참이다.
n이라는 값이 입력되었을 때 1이 나올 때까지 만들어진 수의 개수(1 포함)를 n의 사이클 길이(cycle-length)라고 한다.
위에 있는 수열을 예로 들면 22의 사이클 길이는 16이다.
i와 j라는 두 개의 수가 주어졌을 때 i와 j 사이의 모든 수(i, j 포함)에 대해 최대 사이클 길이를 구하라.

<입력>
입력은 일련의 정수쌍 i와 j로 구성되며 한 줄에 한 쌍의 수가 입력된다.
모든 정수는 1,000,000보다 작고 0보다 크다.
<출력>

각 정수쌍 i와 j에 대해 i와 j를 입력된 순서대로 출력하고 i와 j 사이의 최대 사이클 길이를 출력한다.
이 세 수는 각각 하나씩의 스페이스로 구분되어야 하며 세 수가 모두 한 줄에 출력되어야 하고 입력된 각 줄마다 한 줄씩 출력해야 한다.

1 10
100 200
201 210
900 1000

1 10 20
100 200 125
201 210 89
900 1000 174
 */


package Chapter01_basic;

import java.util.Scanner;

public class TheNProblem {
    public static int max = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            for (int a = i; a <= j; a++) {
                cycle(a, 0);
            }
            System.out.println(i + " " + j + " " + max);
            max = 0;
        }

    }
    static void cycle(int n, int cnt) {
        if (n == 1) {
            cnt++;
            if (max < cnt) max = cnt;
            return;
        }

        if (n % 2 == 0) {
            cycle(n/2, cnt+1);
        }
        else {
            cycle(n*3 + 1, cnt+1);
        }
    }
}
