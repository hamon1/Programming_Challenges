/*
c21
대부분의 경시 대회 심사위원들은 상당히 까다롭다.
심사위원 없이 심사를 진행할 수 있도록 제출된 풀이를 심사하는 자동화된 심사 스크립트를 작성하라.

이 프로그램에서는 정답과 제출된 프로그램에서 만들어낸 출력 결과가 들어있는 파일을 받아서 아래에 정의된 방법에 따라 Accepted, Presentation Error, Wrong Answer 가운데 하나로 답해야 한다.

Accepted: 제출된 프로그램에 의한 출력과 결과가 정답과 완벽하게 일치하는 경우에 'Accepted' 라고 답한다.
모든 문자가 똑같은 순서대로 매치되어야만 한다.
Presentation Error: 숫자는 전부 같은 순서로 매체되지만 숫자가 아닌 문자가 하나 이상 매치되지 않는 것이 있으면 'Presentation Error'라고 답한다.
예를 들어 '15 0'과 '150'이 입력되었다면 'Presentation Error'라고 답할 수 있지만 '15 0'과 '1 0'이 입력되었다면 아래 설명에 나와있는 것처럼 'Wrong Answer'라고 답해야 한다.
Wrong Answer: 제출된 프로그램에 의한 출력 결과가 위에 나와있는 두 가지 범주에 속하지 않는다면 'Wrong Answer'라고 답해야 한다.

<입력>
입력은 임의 개수의 입력 세트로 구성된다.
각 입력 세트는 정답의 줄 수를 나타내는 100 미만의 양의 정수 n이 들어있는 행으로 시작된다.
그 다음 n개의 줄에는 정답이 입력된다.
그 다음 줄에는 제출된 풀이의 출력 결과의 줄 수를 나타내는 100 미만의 양의 정수 m이 들어있는 행이 입력된다.
그 다음 m개의 줄에는 제출된 프로그램에서 출력한 내용이 입력된다.
n으로 0이 입력되면 입력을 종료하고 그 행은 처리하지 않는다.

<출력>
각 세트에 대해 다음 중 하나를 출력한다.
Run #x: Accepted
Run #x: Presentation Error
Run #x: Wrong Answer
여기에서 x에는 입력 세트의 번호(1에서 시작)가 들어간다.

2
The answer is: 10
The answer is: 5
2
The answer is: 10
The answer is: 5
2
The answer is: 10
The answer is: 5
2
The answer is: 10
The answer is: 15
2
The answer is: 10
The answer is:  5
2
The answer is: 10
The answer is: 5
3
Input Set #1: YES
Input Set #2: NO
Input Set #3: NO
3
Input Set #0: YES
Input Set #1: NO
Input Set #2: NO
1
1 0 1 0
1
1010
1
The judges are mean!
1
The judges are good!
0

Run #1: Accepted
Run #2: Wrong Answer
Run #3: Presentation Error
Run #4: Wrong Answer
Run #5: Presentation Error
Run #6: Presentation Error
 */


package Chapter03_String;

import java.util.Scanner;

public class AutomatedJudgeScript {
    static String[] input1;
    static String[] input1_space;
    static String[] input2;
    static String[] input2_space;
    static boolean whole_word;
    static boolean exp_space;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            int n1 = sc.nextInt();
            input1 = new String[n1];
            for (int i = 0; i < n1; i++) {
                String input = sc.nextLine();
                input1[i] = input;
                input1_space[i] = input.replace(" ", "");
            }
            int n2 = sc.nextInt();
            input2 = new String[n2];
            for (int i = 0; i < n2; i++) {
                String input = sc.nextLine();
                input2[i] = input;
                input2_space[i] = input.replace(" ", "");
            }
            if (n1 == n2) { //두 String이 완전히 같은가 다른가
                String a;
                String b;
                for (int i = 0; i < n1; i++) {
                    a = input1[i];
                    b = input2[i];

                    if (a.equals(b)) {
                        whole_word = true;
                    }
                    else {
                        whole_word = false;
                        break;
                    }
                }
            }
            else { //두 String의 Presentation error 유무 확인
                if (input1_space.length == input2_space.length) { //공백을 없앤 후 비교
                    for (int i = 0; i < input1_space.length; i++) {
                        if (input1_space[i].equals(input2_space[i])) { //(공백 제외) 두 String이 같음

                        }
                        else { //다른 경우, 다른 문자가 숫자인지 문자인지 구별
                            //다른 문자가 숫자 인 경우, wrong answer / 문자인 경우, Presentation error
                            //숫자 -> ('0' <= n <= '9')
                            if(input1_space[i].length() == input2_space[i].length()) {
                                for (int j = 0; j <= input1_space[i].length(); j++) {
                                    char c1 = input1_space[i].charAt(j);
                                    char c2 = input2_space[i].charAt(j);

                                    if (c1 == c2) {
                                        continue;
                                    }
                                    else {
                                        if ('0' <= c1 && c1 <= '9' && '0' <= c2 && c2 <= '9') {
                                            whole_word = false;
                                            exp_space = false;
                                            //함수로 옮겨서 return 으로 바로 결과 출력하자.
                                        }
                                        else {

                                        }
                                    }
                                }
                            }

                        }
                    }
                }

            }



        }
    }
    static boolean check_accepted() {
        if (input1.length == input2.length) { //두 String이 완전히 같은가 다른가
            String a;
            String b;
            for (int i = 0; i < input1.length; i++) {
                a = input1[i];
                b = input2[i];

                if (a.equals(b)) {
                    whole_word = true;
                }
                else {
                    whole_word = false;
                    return false;
                }
            }
        }
        return true;
    }
    static boolean check_presentation() {
        if (input1_space.length == input2_space.length) { //공백을 없앤 후 비교
            for (int i = 0; i < input1_space.length; i++) {
                if (input1_space[i].equals(input2_space[i])) { //(공백 제외) 두 String이 같음

                } else { //다른 경우, 다른 문자가 숫자인지 문자인지 구별
                    //다른 문자가 숫자 인 경우, wrong answer / 문자인 경우, Presentation error
                    //숫자 -> ('0' <= n <= '9')
                    if (input1_space[i].length() == input2_space[i].length()) {
                        for (int j = 0; j <= input1_space[i].length(); j++) {
                            char c1 = input1_space[i].charAt(j);
                            char c2 = input2_space[i].charAt(j);

                            if (c1 == c2) {
                                continue;
                            } else {
                                if ('0' <= c1 && c1 <= '9' && '0' <= c2 && c2 <= '9') {
                                    whole_word = false;
                                    exp_space = false;
                                    return false;
                                } else {
                                    whole_word = false;
                                    exp_space = true;
                                }
                            }
                        }
                    }

                }
            }
        }
        return true;
    }
}
