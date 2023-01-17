/*
c2-clear
M * N 크기의 지뢰밭에서 모든 지뢰의 위치를 찾아내는 게임.

이 게임에서는 각 칸에 인접한 칸에 몇 개의 지뢰가 있는지를 보여준다.
각 칸에는 최대 여덟 개의 인접한 칸이 있을 수 있다.
아래에서 왼쪽에 있는 4*4 지뢰밭에는 지뢰 두 개가 있으며 각각은 '*'문자로 표시되어 있다.
이 지뢰밭을 방금 설명한 힌트 숫자로 표기하면 오른쪽에 있는 것과 같은 필드가 만들어진다.
*...    *100
....    2210
.*..    1*10
....    1110

<입력>
입력은 임의 개수의 지뢰밭으로 구성된다.
각 지뢰밭의 첫번째 줄에는 각각 행과 열의 개수를 나타내는 두 개의 정수 n과 m(0<n, m<=100)이 들어있다.
그 다음 줄부터는 n개의 줄에 걸쳐서 각 줄마다 정확하게 m개씩의 문자가 들어있으며 이는 지뢰밭은 나타낸다.

지뢰가 없는 칸은 '.'으로, 지뢰는 '*'로 표시되며 이때 따옴표는 쓰지 않는다.
n=m=0인 줄은 입력이 끝났음을 나타내는 것이므로 그 줄은 처리하지 않는다.

<출력>
각 지뢰밭에 대해 Field #x;라고 적혀 있는 메시지를 출력한다.
이때 x는 필드 번호를 나타내며 1에서 시작한다.
그 다음 줄부터는 n개의 줄에 걸쳐서 '.'문자 대신 그 칸에 인접한 칸에 들어있는 지뢰의 개수를 출력한다.
각 지뢰밭에 대한 출력 사이에는 반드시 빈 줄이 하나씩 있어야 한다.

4 4     Field #1:
*...    *100
....    2210
.*..    1*10
....    1110
0 0

 */


package Chapter01_basic;

import java.util.Scanner;

public class Minesweeper {
    static Character[][] field;
    static Character[][] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        while (true) {
            num++;
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (m == 0 && n == 0) break;

            field = new Character[m][n];
            result = new Character[m][n];

            String input;
            for (int i = 0; i < m; i++) {
                input = sc.next();
                for (int j = 0; j < n; j++) {
                    field[i][j] = input.charAt(j);
                }
            }

            System.out.println("Field #" + num + ":");

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j] == '*') System.out.print('*');
                    else {
                        System.out.print(count_landmine(i, j, m, n));
                    }
                }
                System.out.println();
            }
        }

    }
    static int count_landmine(int x, int y, int m, int n) {
        int[] bx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] by = {0, 1, 1, 1, 0, -1, -1, -1};
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int mx = x + bx[i];
            int my = y + by[i];
            if(mx >= 0 && mx < n && my >= 0 && my < m) {
                if(field[mx][my] == '*') cnt++;
            }
        }
        return cnt;

    }
}
