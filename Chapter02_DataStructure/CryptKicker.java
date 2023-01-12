/*
c12
텍스트를 암호화하는 방법 중에 보안상 취약하긴 하지만 흔하게 쓰이는 방법으로 알파벳 글자를 다른 글자로 돌리는 방법이 있다.
즉 알파벳의 각 글자를 다른 글자로 치환한다.
암화화된 것을 다시 원래대로 되돌릴 수 있으려면 두 개의 서로 다른 글자가 같은 글자로 치화되지 않아야 한다.

암호화된 텍스트가 한 줄 이상 입력되는데, 각 줄마다 서로 다른 치환 방법이 적용된다고 가정하자.
암화화 이전의 텍스트에 있는 단어는 모두 주어진 사전에 들어있는 단어라고 가정하고, 암호화된 텍스트를 해독하여 원래 텍스트를 알아내자.

<입력>
입력은 한 개의 정수 n이 들어있는 행으로 시작되며 그 다음 줄부터는 한 줄에 하나씩 n개의 소문자로 쓰인 단어들이 알파벳 순으로 입력된다.
이 n개의 단어들은 복호화된 텍스트에 들어갈 수 있는 단어로 구성된 사전이다. 사전 뒤에는 몇 줄의 텍스트가 입력된다.
각 줄은 앞에서 설명했던 방법에 따라 암호화된다.

사전에 들어갈 수 있는 단어의 개수는 1,000개를 넘지 않는다.
단어의 길이는 16글자를 넘지 않는다.
암호화된 텍스트에는 소문자와 스페이스만 들어가며 한 줄의 길이는 80글자를 넘어가지 않는다.

<출력>
각 줄을 복호화하여 표준 출력으로 출력한다.
여러 문장으로 복호화될 수 있다면 그 중 아무 결과나 출력하면 된다.
가능한 풀이가 없다면 알파벳 모든 문자를 아스테리스크(*)로 바꾸면 된다.

6
and
dick
jane
puff
spot
yertle
bjvg xsb hxsn xsb qumm xsb rqat xsb pnetfn
xxxx yyy zzzz www yyyy aaa bbbb ccc dddddd

dick and jane and puff and spot and yertle
**** *** **** *** **** *** **** *** ******
 */



package Chapter02_DataStructure;

import java.util.Scanner;

public class CryptKicker {
    static String[] dic;
    static char[] abc = new char[26];
    static boolean[] dic_check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dic = new String[n];
        dic_check = new boolean[n];
        for (int i = 0; i < n; i++) {
            dic[i] = sc.next();
        }
        String input;
        String[] input_word;
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            input_word = input.split(" ");
        }

    }
    static void search(String[] input) {
        for (int i = 0; i < dic.length; i++) {

        }
    }
}
