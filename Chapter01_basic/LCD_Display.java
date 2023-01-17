/*
c4-clear
한 친구가 방금 새 컴퓨터를 샀다.
그 친구가 지금까지 샀던 가장 강력한 컴퓨터는 공학용 전자 계산기였다.
그런데 그 친구는 새 컴퓨터의 모니터보다 공학용 계산기에 있는 LCD 디스플레이가 더 좋다며 크게 실망하고 말았다.
그 친구를 만족시킬 수 있도록 숫자를 LCD 디스플레이 방식으로 출력하는 프로그램을 만들어보자.

<입력>
입력 파일은 여러 줄로 구성되며 표시될 각각의 숫자마다 한 줄씩 입력된다.
각 줄에는 s와 n이라는 두 개의 정수가 들어있으며 n은 출력될 숫자(0<=n<=99,999,999), s는 숫자를 표시하는 크기(1<=s<=10)를 의미한다.
0이 두 개 입력된 줄이 있으면 입력이 종료되며 그 줄은 처리되지 않는다.

<출력>
입력 파일에서 지정한 숫자를 수평방향은 '-' 기호를, 수직 방향은 '|'를 이용해서 LCD 디스플레이 형태로 출력한다.
각 숫자는 정확하게 s+2개의 열, 2s+3개의 행으로 구성된다.
마지막 숫자를 포함한 모든 숫자를 이루는 공백을 스페이스로 채워야 한다.
두 개의 숫자 사이에는 정확하게 한 열의 공백이 있어야 한다.

각 숫자 다음에는 빈 줄을 한 줄 출력한다.
밑에 있는 출력 예에 각 숫자를 출력하는 방식이 나와있다.

2 12345
3 67890
0 0

      --   --        --
   |    |    | |  | |
   |    |    | |  | |
      --   --   --   --
   | |       |    |    |
   | |       |    |    |
      --   --        --

 ---   ---   ---   ---   ---
|         | |   | |   | |   |
|         | |   | |   | |   |
|         | |   | |   | |   |
 ---         ---   ---
|   |     | |   |     | |   |
|   |     | |   |     | |   |
|   |     | |   |     | |   |
 ---         ---   ---   ---
 */




package Chapter01_basic;

import java.util.Scanner;

public class LCD_Display {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int s = sc.nextInt();
            String n = sc.next();

            if (s == 0 && n.equals("0")) break;

            char[] number_list = new char[n.length()];
            int len = n.length();

            for (int i = 0; i < len; i++) {
                number_list[i] = n.charAt(i);
            }

            for (int i = 0; i < len; i++) {
                top(s, number_list[i]);
                System.out.print(' ');
            }
            System.out.println();
            for (int j = 0; j < s; j++) {
                for (int i = 0; i < len; i++) {
                    first(s, number_list[i]);
                    System.out.print(' ');
                }
                System.out.println();
            }
            for (int i = 0; i < len; i++) {
                middle(s, number_list[i]);
                System.out.print(' ');
            }
            System.out.println();
            for (int j = 0; j < s; j++) {
                for (int i = 0; i < len; i++) {
                    second(s, number_list[i]);
                    System.out.print(' ');
                }
                System.out.println();
            }
            for (int i = 0; i < len; i++) {
                bottom(s, number_list[i]);
                System.out.print(' ');
            }
            System.out.println();
            System.out.println();
        }



    }
    public static void top(int s, char number) {
        switch (number) {
            case '1':
            case '4':
                top_print_false(s);
                break;
            default:
                top_print_true(s);
                break;
        }
    }
    public static void middle(int s, char number) {
        switch (number) {
            case '1':
            case '0':
            case '7':
                top_print_false(s);
                break;
            default:
                top_print_true(s);
                break;
        }
    }
    public static void bottom(int s, char number) {
        switch (number) {
            case '1':
            case '7':
            case '4':
                top_print_false(s);
                break;
            default:
                top_print_true(s);
                break;
        }
    }
    public static void first (int s, char number) {
        switch (number) {
            case '1':
            case '2':
            case '3':
            case '7':
                three(s);
                break;
            case '5':
            case '6':
                one(s);
                break;
            default:
                one_three(s);
                break;
        }
    }
    public static void second (int s, char number) {
        switch (number) {
            case '6':
            case '8':
            case '0':
                one_three(s);
                break;
            case '2':
                one(s);
                break;
            default:
                three(s);
                break;
        }
    }
    public static void repeat_print_top (int num, char c) {
        System.out.print(' ');
        for (int i = 0; i < num; i++) {
            System.out.print(c);
        }
        System.out.print(' ');
    }
    public static void top_print_true (int num){
        repeat_print_top(num, '-');
    }
    public static void top_print_false (int num) {
        repeat_print_top(num, ' ');
    }
    public static void one (int num) {
        System.out.print('|');
        for (int i = 0; i < num; i++) {
            System.out.print(' ');
        }
        System.out.print(' ');
    }
    public static void three (int num) {
        System.out.print(' ');
        for (int i = 0; i < num; i++) {
            System.out.print(' ');
        }
        System.out.print('|');
    }
    public static void one_three (int num) {
        System.out.print('|');
        for (int i = 0; i < num; i++) {
            System.out.print(' ');
        }
        System.out.print('|');
    }
}
