/*
c6
어떤 컴퓨터에 열 개의 레지스터와 1,000워드 분량의 램(RAM)이 있다.
각 레지스터 또는 램 위치에는 0 이상 999 이하의 세 자리 정수가 저장된다.
명령어는 세 자리 정수로 인코딩되며 램에 저장된다.
인코딩은 다음과 같다

100     종료
2dn     d 레지스터를 n으로 설정(0 이상 9 이하)
3dn     d 레지스터에 n 더함
4dn     d 레지스터에 n 곱함
5ds     d 레지스터를 s 레지스터의 값으로 설정
6ds     s 레지스터의 값을 d 레지스터에 더함
7ds     d 레지스터에 s 레지스터의 값을 곱함
8da     d 레지스터를 a 레지스터에 저장된 주소의 램에 들어있는 값으로 설정
9sa     a 레지스터에 저장된 주소의 램에 s 레지스터의 값을 대입
0ds     s 레지스터에 0이 들어있지 않으면 d 레지스터에 있는 위치로 이동

모든 레지스터의 초기 값은 000이다.
램에 저장되는 초기 값은 표준 입력으로부터 들어온다.
처음으로 실행될 명령은 주소가 0인 램에 들어있다.
모든 결과는 값이 1,000이 넘어가면 1,000으로 나눈 나머지로 줄어든다.

<입력>
입력은 입력 케이스의 개수를 나타내는 양의 정수 한 개가 들어있는 줄로 시작되며 그 줄에는 그 숫자밖에 입력되지 않는다.
그 뒤에는 빈 줄이 하나 들어가고 서로 다른 입력 케이스 사이에는 빈 줄 두 개가 입력된다.
각 입력 케이스는 최대 1,000개의 부호가 없는 세 자리 정수로 구성되며 그 숫자들은 0부터 시작하는 연속된 램 위치에 저장되는 내용을 나타낸다.
값이 지정되지 않는 램 위치는 000으로 초기화된다.

<출력>
각 테스트 케이스마다 하나씩의 정수를 출력한다.
출력되는 정수는 종료 명령어에 이르기까지(종료 명령어 포함) 실행된 명령어의 개수다.
프로그램이 종료된다고 미리 가정해도 된다.
케이스가 여려 개 있는 경우에는 각 출력 사이에 빈줄을 출력한다.

1

299
492
495
399
492
495
399
283
279
689
078
100
000
000
000

16
 */


package Chapter01_basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    static int cnt = 0;
    private static boolean end = true;
    public static ArrayList<String> RAM = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            while(sc.hasNext()) {
                RAM.add(sc.next());
            }
        }

        for (int i = 0; i < RAM.size(); i++) {
            String s = RAM.get(i);
            int number = Integer.parseInt(s);
            int a = number/100;
            int b = (number%100)/10;
            int c = ((number%100)%10);
            command(a, b, c);
        }

    }
    public static void command(int code, int a, int b) {
        int n;
        switch (code) {
            case 1:
                if (a == 0 && b == 0) {
                    cnt++;
                    quit();
                    break;
                }
            case 2:
                cnt++;
                RAM.set(a, "00" + b);
                break;
            case 3:
                cnt++;
                n = Integer.parseInt(RAM.get(a));
                n = (n + b)%1000;
                RAM.set(a, Integer.toString(n));
                break;
            case 4:
                cnt++;
                n = Integer.parseInt(RAM.get(a));
                n = (n * b)%1000;
                RAM.set(a, Integer.toString(n));
                break;
            case 5:
                cnt++;
                RAM.set(a, RAM.get(b));
                break;
            case 6:
                cnt++;
                n = Integer.parseInt(RAM.get(a));
                n += (Integer.parseInt((RAM.get(b))))%1000;
                RAM.set(a, Integer.toString(n));
                break;
            case 7:
                cnt++;
                n = Integer.parseInt(RAM.get(a));
                n *= (Integer.parseInt((RAM.get(b))))%1000;
                RAM.set(a, Integer.toString(n));
                break;
            case 8:
                cnt++;
                //a 레지스터를 b 레지스터에 저장된 주소의 램에 들어있는 값으로 설정
                break;
            case 9:
                cnt++;
                //b 레지스터에 저장된 주소의 램에 a 레지스터 값 저장
                break;
            case 0:
                n = Integer.parseInt(RAM.get(b));
                if (n != 0) {
                    //a 레지스터에 있는 위치로 이동
                }
        }
    }
    public static void quit () {
        end = false;
        System.out.println(cnt);
        return;
    }

}
