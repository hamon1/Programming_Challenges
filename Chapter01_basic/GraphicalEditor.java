/*
포토샵 같은 그래픽 편집기를 이용하면 텍스트 편집기에서 문서를 수정하는 것처럼 비트맵 이미지를 수정할 수 있다.
이미지는 픽셀로 이루어진 M*N 배열로 표현되며 각 픽셀마다 색이 주어진다.

간단한 대화형 그래픽 편집기 흉내를 낼 수 있는 프로그램을 만들어보자.

<입력>
입력은 한 줄에 하나씩 편집기 명령으로 구성된다.
각 명령은 줄 맨 앞에 있는 대문자 한 개로 표현된다.
매개변수가 필요한 경우에는 그 명령과 같은 줄에 스페이스로 분리되어 매개변수가 입력된다.

픽셀 좌표는 1 이상 M 이하의 열 번호와 1 이상 N 이하의 행 번호, 이렇게 두 개의 정수로 표현되며 이때 1<=M, N<=250라는 조건이 만족된다.
표의 왼쪽 위 꼭지점을 원점으로 삼는다.
색은 대문자로 지정된다.
편집기에서 받아들이는 명령은 다음과 같다.

I M N               모든 픽셀이 흰색(O)으로 칠해진 M*N 이미지를 새로 만든다.
C                   모든 픽셀을 흰색(O)으로 칠해서 표를 지운다. 이미지의 크기는 바뀌지 않는다.
L X Y C             (X, Y) 픽셀을 주어진 색(C)으로 칠한다.
V X Y1 Y2 C         X열에 Y1행과 Y2행(y1, y2 포함) 사이에 주어진 색(C)으로 수직 방향 직선을 긋는다.
H X1 X2 Y C         Y열에 X1행과 X2행(X1, X2 포함) 사이에 주어진 색(C)으로 수평 방향 직선을 긋는다.
K X1 Y1 X2 Y2 C     주어진 색(C)으로 채워진 직사각형을 그린다. (X1, Y1)은 왼쪽 위 끝점, (X2, Y2)는 오른쪽 아래 끝 점을 의미한다.
F X Y C             R 영역을 주어진 색(C)으로 채우는데, 영역 R은 다음과 같이 정의된다.
                    (X, Y)픽셀은 R에 속한다.
                    (X, Y)픽셀과 색이 같고 R에 포함된 픽셀과 맞닿은 부분이 하나라도 있다면 그 픽셀도 R영역에 포함된다.
S Name              파일명은 입력받은 그대로 출력하고 그 뒤에 현재 이미지의 내용을 출력한다.
X                   세션을 종료한다.

<출력>
S NAME이라는 명령이 있을 때마다 NAME으로 주어진 파일명을 출력하고 현재 이미지의 내용을 출력한다.
각 행은 각 픽셀의 색을 나타내는 문자로 표시된다.
출력 예를 참고하자.
I, C, L, V, H, K, F, S, X를 제외한 문자로 정의된 명령이 있으면 그 줄 전체를 무시하고 다음 명령으로 넘어간다.
다른 오류에 대해서는 프로그램의 행동을 예측할 수 없다.

I 5 6
L 2 3 A
S one.bmp
G 2 3 J
F 3 3 J
V 2 3 4 W
H 3 4 2 Z
S two.bmp
X

one.bmp
OOOOO
OOOOO
OAOOO
OOOOO
OOOOO
OOOOO
two.bmp
JJJJJ
JJZZJ
JWJJJ
JWJJJ
JJJJJ
JJJJJ
 */



package Chapter01_basic;

import java.util.Scanner;

public class GraphicalEditor {
    static char[][] img;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean end = true;
        while(end) {
            String input = sc.next();
            char command = input.charAt(0);

            switch (command) {
                case 'I':
                    I_new_img(sc.nextInt(), sc.nextInt());
                    break;
                case 'C':
                    C_clear();
                    break;
                case 'L':
                    L_point_color(sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 'V':
                    V_line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 'H':
                    H_line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 'K':
                    K_squire(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 'F':
                    F(sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 'S':
                    S_print_file(sc.next());
                    break;
                case 'X':
                    end = false;
                    break;
                default:
                    break;
            }

        }
    }
    public static void I_new_img (int n, int m) {
        img = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] = 'O';
            }
        }
    }
    public static void C_clear () {
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                img[i][j] = 'O';
            }
        }
    }
    public static void L_point_color (int y, int x, char color) {
        if (img.length > x && img[0].length > y) {
            img[x-1][y-1] = color;
        }
        else {
            System.out.println("L - ERROR");
        }
    }
    public static void V_line (int x, int y1, int y2, char color) {
        if (img.length > y2 && img[0].length > x) {
            for (int i = y1-1; i < y2-1; i++) {
                img[i][x-1] = color;
            }
        }
        else {
            System.out.println("V - ERROR");
        }
    }
    public static void H_line (int x1, int x2, int y, char color) {
        if (img.length > y && img[0].length > x2) {
            for (int i = x1-1; i < x2-1; i++) {
                img[y-1][i] = color;
            }
        }
        else {
            System.out.println("V - ERROR");
        }
    }
    public static void K_squire (int x1, int x2, int y1, int y2, char color) {
        if (img.length > y2 && img[0].length > x2) {
            for (int j = y1-1; j < y2-1; j++) {
            for (int i = x1-1; i < x2-1; i++) {

                    img[j][i] = color;
                }
            }
        }
        else {
            System.out.println("K - ERROR");
        }
    }
    //*****************************************************************
    public static void F (int y, int x, char color) {
        char basic_color = img[x-1][y-1];
        img[x-1][y-1] = color;

        change_color(x-1, y-1, basic_color, color);
    }
    static void change_color (int x, int y, char basic_color, char color) {
        if (img[x][y] != basic_color || img[x][y] != color) {
            return;
        }

        int[] bx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] by = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            int mx = x + bx[i];
            int my = y + by[i];

            if (mx >= 0 && mx < img.length && my >= 0 && my < img[0].length) {
                if (img[mx][my] == basic_color) {
                    img[mx][my] = color;
                    change_color(mx, my, basic_color, color);
                }
            }
        }
    }

    public static void S_print_file (String file_name) {
        System.out.println(file_name);
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                System.out.print(img[i][j]);
            }
            System.out.println();
        }
    }
}
