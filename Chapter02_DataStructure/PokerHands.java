/*
c10
포커용 카드는 52개의 카드로 이루어진다.
각 카드는 클럽, 다이아몬드, 하트, 스페이드(입력 데이터에서는 각각 C, D, H, S로 표기) 중 한 가지 무늬를 가진다.
또한 각 카드는 2에서 10까지, 그리고 잭, 퀸, 킹 또는 에이스(2, 3, 4, 5, 6, 7, 8, 9, J, Q, K, A로 표기)의 값을 갖는다.
점수를 매길 때 위에 열거한 순서대로 등급이 매겨지며 2가 가장 낮고 에이스가 가장 높다.
무늬는 값에 영향을 끼치지 않는다.

포커 패는 다섯 장의 카드로 구성되며 다음과 같은 순서대로 등급이 매겨진다.

하이 카드: 아래에 있는 것 가운데 어떤 범주에도 속하지 않는 패는 그 중 가장 높은 카드의 값에 따라 등급이 매겨진다.
    가장 높은 카드의 값이 같으면 그 다음 카드, 그 다음 카드도 같으면 그 다음 카드, 이런 식으로 등급이 매겨진다.
원 페어: 다섯 장의 카드 가운데 두 장이 같은 경우.
    같은 원 페어끼리 맞붙는 경우에는 더 높은 값을 가지는 원 페어 패에 더 높은 값을 가지는 원 페어 패에 더 높은 등급이 매겨진다.
    값까지 같은 경우네는 나머지 카드의 값에 의해 더 높은 패가 결정된다.
투 페어: 두 쌍의 카드가 같은 값을 가지는 경우.
    투 페어끼리 맞붙은 경우에는 그 중 더 높은 페어의 값에 의해 더 높은 등급이 매겨진다.
    두 쌍의 값이 모두 같으면 남은 카드에 의해 더 높은 패가 결정된다.
쓰리 카드: 다섯 장 가운데 세 장이 같은 값을 가지는 경우.
    쓰리 카드끼리 맞붙는 경우에는 세 장의 같은 값을 가지는 카드이 값에 의해 더 높은 패가 결정된다.
스트레이트: 다섯 장의 카드가 연속적인 값을 가지는 경우.
    스트레이트끼리 맞붙을 경우에는 가장 높은 카드에 의해 더 높은 패가 결정된다.
플러시: 다섯 장의 카드의 무늬가 모두 같은 경우.
    플러시끼리 맞붙은 경우에는 하이 카드의 규칙에 따라서 더 높은 패가 결정된다.
풀 하우스: 세 장의 카드가 같은 값을 가지고 나머지 두 장의 카드가 같은 값을 가지는 경우.
    같은 값을 가지는 세 장의 우열에 의해 더 높은 패가 결정된다.
포카드: 네 장의 카드가 같은 값을 가지는 경우.
    포카드끼리 맞붙은 경우네는 네 장의 같은 값을 가지는 카드의 값에 의해 더 높은 패가 결정된다.
스트레이트 플러시: 다섯 장의 카드가 무늬가 같으면서 모두 연속적인 값을 가지는 경우.
    패에 있는 것 중 가장 높은 카드에 의해 더 높은 패가 결정된다.

몇 쌍의 포커 패를 비교해서 어느 쪽이 이겼는지 아니면 무승부인지 알아내자.

<입력>
입력 파일은 여러 줄로 구성되며 각 줄에는 열 장의 카드를 나타내는 값이 들어간다.
앞에 있는 다섯 장의 카드는 "Black"이라는 참가자의 카드고 뒤에 있는 다섯 장의 카드는 "White"라는 참가자의 카드이다.

<출력>
입력된 각 줄에 대해 다음 중 한 가지가 들어있는 행을 출력한다.
(첫번째는 Black이 이기는 경우, 두 번째는 White가 이기는 경우, 세 번째는 둘이 비기는 경우)
Black wins.
White wins.
Tie.

2H 3D 5S 9C KD 2C 3H 4S 8C AH
2H 4S 4C 2D 4H 2S 8S AS QS 3S
2H 3D 5S 9C KD 2C 3H 4S 8C KH
2H 3D 5S 9C KD 2D 3H 5C 9S KH

White wins.
Black wins.
Black wins.
Tie.
 */


package Chapter02_DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class PokerHands {
    static int b_score;
    static int w_score;
    static int extra_b_score;
    static int extra_w_score;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            b_score = 0;
            w_score = 0;
            String[] cards = new String[10];
            for (int i = 0; i < 10; i++) {
                cards[i] = sc.next();
            }
        }


    }
    static boolean Straight_Flush (String[] cards, int who) {
        if (Straight(cards, who) && Flush(cards)) return true;
        else return false;
    }
    static boolean Four_Card(String[] cards, int who) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            char b = cards[i].charAt(0);
            for (int j = 0; j < 5; j++) {
                if (cards[j].charAt(0) == b) cnt++;
            }
            if (cnt == 4) {
                if (who == 0) {
                    b_score = 8;
                    extra_b_score = number_change(b);
                }
                else {
                    w_score = 8;
                    extra_w_score = number_change(b);
                }
                return true;
            }
        }
        return false;

    }
    static boolean Full_House(String[] cards, int who) {
        int cnt1 = 0;
        int cnt2 = 0;
        char b = cards[0].charAt(0);
        char c = '*';
            for (int j = 0; j < 5; j++) {
                char k = cards[j].charAt(0);
                if (k == b) cnt1++;
                else {
                    if (cnt2 == 0) {
                        c = k;
                        cnt2++;
                    }
                    if (k == c) cnt2++;
                }
            }
            if (cnt1 == 3 && cnt2 == 2) {
                if (who == 0) {
                    b_score = 7;
                    extra_b_score = number_change(b);
                }
                else {
                    w_score = 7;
                    extra_w_score = number_change(b);
                }
                return true;
            }

        return false;
    }
    static boolean Flush(String[] cards) {
        char img = cards[0].charAt(1);
        for (int i = 0; i < 5; i++) {
            if (cards[i].charAt(1) != img) return false;
        }
        High_Card(cards);
        return true;
    }
    static boolean Straight(String[] cards, int who) {
        int[] number_list = new int[5];
        for (int i = 0; i < 5; i++) {
            char a = cards[i].charAt(0);
            number_list[i] = number_change(a);
        }
        Arrays.sort(number_list);
        int n = number_list[0];
        for (int i = 1; i < 5; i++) {
            int nn = number_list[i];
            if (nn - n != 1) return false;
        }
        if (who == 0) {
            extra_b_score = number_list[4];
        }
        else {
            extra_w_score = number_list[4];
        }
        return true;
    }
    static boolean Three_Card(String[] cards, int who) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            char b = cards[i].charAt(0);
            for (int j = 0; j < 5; j++) {
                if (cards[j].charAt(0) == b) cnt++;
            }
            if (cnt == 3) {
                if (who == 0) {
                    b_score = 8;
                    extra_b_score = number_change(b);
                }
                else {
                    w_score = 8;
                    extra_w_score = number_change(b);
                }
                return true;
            }
        }
        return false;
    }
    static void Two_Pair(String[] cards) {

    }
    static void One_Pair(String[] cards) {

    }
    static void High_Card(String[] cards) {

    }
    static int number_change(char code) {
        switch (code) {
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'J':
                return 10;
            case 'Q':
                return 11;
            case 'K':
                return 12;
            case 'A':
                return 13;
            default:
                return -1;
        }
    }
}
