/*
c13

헝가리 출신의 수학자 폴 에르되시(Paul Erdos, 1913-1996)는 20세기의 가장 유명한 수학자 가운데 하나로 꼽힌다.
에르되시와 함께 논문을 쓴 경험이 있는 수학자들도 존경을 받을 정도니 그의 명성을 짐작할 수 있을 것이다.

하지만 불행하게도 모든 사람들이 그와 함께 논문을 쓸 기회를 얻을 수 있는 것은 아니었기 때문에 에르되시와 함께 논문을 썼던 사람과 논문을 같이 쓰는 정도로 만족해야 했다.
이런 이유로 인해 에르되시 수라는 것이 생겼다.
에르되시와 함께 논문을 쓴 사람의 에르되시 수는 1이다.
에르되시와 직접함께 논문을 쓰진 않았지만 에르되시 수가 1인 사람과 함께 논문을 쓴 적이 있는 사람의 에르되시 수는 2다.

주어진 논문과 논문 저자를 바탕으로 에르되시 수를 계산하는 프로그램을 만들어야 한다.

<입력>
입력의 첫번째 행에는 시나리오 개수가 들어있다.
각 시나리오는 논문 데이터베이스와 이름의 목적으로 구성된다.
각 시나리오의 첫번째 줄에는 P와 N이라는 자연수 두 개가 입력된다.
그 다음 줄에는 논문 데이터베이스가 입력되며 각 논문마다 한 줄씩 저자에 대한 정보가 입력된다.
각 논문에 대한 정보는 다음과 같은 식으로 기술된다.

Smith, M.N., Martin, G., Erdos, P.: Newtonian forms of prime factors matrices

움라우트는 편의상 'O'로 표기한다.
P개의 논문 정보 밑에는 각각 하나씩의 이름이 들어있는 N개의 행이 입력된다.
이름은 다음과 같은 형식으로 입력된다.

Martin, G.

<출력>
각 시나리오에 대해 "Scenario i"(i는 시나리오 번호)라는 내용이 들어있는 행을 우선 출력한다.
그 다음줄부터는 입력된 모든 이름에 대해 이름과 에르되시 수를 출력한다.
저자의 이름은 입력된 순서대로 출력된다.
에르되시 수는 시나리오에 들어있는 논문 데이터베이스를 기반으로 계산한다.
데이터베이스에 있는 논문으로 볼 때 에르되시와 전혀 관계가 없는 저자들의 에르되시 수는 "infinity"로 출력한다.

1
4 3
Smith, M.N., Martin, G., Erdos, P.: Newtonian forms of prime factors matrices
Erdos, P., Reisig, W.: Stuttering in petri nets
Smith, M.N., Chen, X.: First oder derivates in structured programming
Jablonski, T., Hsueh, Z.: Selfstabilizing data structures
Smith, M.N.
Hsueh, Z.
Chen, X.

Scenario 1
Smith, M.N. 1
Hsueh, Z. infinity
Chen, X. 2
 */



package Chapter02_DataStructure;

import java.util.Scanner;

public class ErdosNumbers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int scenario = sc.nextInt();
        for (int i = 0; i < scenario; i++) {
            int p = sc.nextInt();
            int n = sc.nextInt();

            String[] array;
            for (int j = 0; j < p; j++) {
                String input = sc.nextLine();
                array = input.split(": ");

                String[] p_list = array[1].split("., ");
            }
            for (int j = 0; j < n; j++) {

            }
        }

    }
}
