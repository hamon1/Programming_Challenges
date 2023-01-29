/*
c19-clear
두 개의 문자열 a, b가 주어졌을 때 글자의 순서를 바꿔서 a의 부분 문자열도 만들 수 있고 b의 부분 문자열도 만들 수 있는 것 중 가장 긴 문자열 x를 출력하라.

<입력>
입력 파일에는 여러 개의 케이스가 들어갈 수 있으며 각 케이스는 두 개의 연속된 줄로 구성된다.
즉 첫번째 줄과 두번째 줄이 한 테스트 케이스를 이루며 세번째 줄과 네번째 줄이 또 다른 테스트 케이스를 이루는 식이다.
각 행에는 소문자로 이루어진 문자열이 하나씩 들어있으며 한 테스트 케이스를 이루는 문자열 중 첫번째 것을 a, 두번째 것을 b라고 하자.
각 문자열의 최대 길이는 1,000글자이다.

<출력>
입력된 각 테스트 케이스마다 한 줄씩 x를 출력한다.
위의 조건을 만족하는 x가 여러 개 있으면 알파벳 순으로 맨 앞에 있는 것을 출력한다.

pretty
women
walking
down
the
street

e
nw
et
 */


package Chapter03_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CommonPermutation {
    static boolean[] abc;
    static ArrayList<Character> result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            abc = new boolean[26];
            result = new ArrayList<>();
            String a = sc.next();
            String b = sc.next();

            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                abc[(int)c - 97] = true;
            }
            for (int i = 0; i < b.length(); i++) {
                boolean t = true;
                char c = b.charAt(i);
                for (int j = 0; j < result.size(); j++) {
                    if (result.get(j) == c) t = false;
                }
                if (abc[(int)c - 97] && t) {
                    result.add(c);
                }
            }
            Collections.sort(result);

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
            }
            System.out.println();
        }
        sc.close();
    }
}
