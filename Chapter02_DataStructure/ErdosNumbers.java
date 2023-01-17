/*
c13-clear

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

import java.util.ArrayList;
import java.util.Scanner;

public class ErdosNumbers {
    static String erdos = "Erdos, P.";
    static ArrayList<String> ppl = new ArrayList<>();
    static ArrayList<Integer> ppl_Erdosnumber = new ArrayList<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int scenario = sc.nextInt();
        for (int i = 0; i < scenario; i++) {
            int p = sc.nextInt(); //number that title input
            int n = sc.nextInt(); //number that ppl who will print

            sc.nextLine();
            String[] array;
            for (int j = 0; j < p; j++) {
                String input = sc.nextLine();

                array = input.split(": "); // divide ppl and title

                String[] p_list = array[0].split(", ");

                for (int k = 0; k < p_list.length; k++) {
                    if (k % 2 == 0) {
                        p_list[k] = p_list[k] + ", " + p_list[k+1];
                    }
                    else {
                        continue;
                    }
                    int num = ppl.size();
                    boolean a = true;
                    for (int m = 0; m < num; m++) {
                        if(ppl.get(m).equals(p_list[k])) {
                            a = false;
                            break;
                        }
                    }
                    if (a) {
                        ppl.add(p_list[k]);
                        ppl_Erdosnumber.add(0);
                    }
                }

                set_Erdos_number(p_list, check_erd(p_list));
            }

            System.out.println("Scenario " + (i+1));
            //check input's Erdos number and print it
            for (int j = 0; j < n; j++) {
                String name = sc.nextLine();

                System.out.print(name + " ");

                int erdos_number = 0;
                for (int k = 0; k < ppl.size(); k++) {
                    if (name.equals(ppl.get(k))) {
                        erdos_number = ppl_Erdosnumber.get(k);
                        if (erdos_number == 0) {
                            System.out.println("infinity");
                        }
                        else {
                            System.out.println(erdos_number);
                        }
                    }
                }
            }
        }

    }
    static int check_erd(String[] p_list) {
        //if Erdos is in this group, set group's Erodos number 1
        for (int k = 0; k < p_list.length; k++) {
            if ((p_list[k]).equals(erdos)) {
                return 1;
            }
        }
        int num = 100000;
        for (int i = 0; i < p_list.length; i++) {
            for (int j = 0; j < ppl.size(); j++) {
                int er = ppl_Erdosnumber.get(j);
                if (p_list[i].equals(ppl.get(j)) && er != 0) {
                    if (er < num) num = er;
                }
            }
        }
        if (num == 100000) return 0;
        return num + 1;
    }
    //setting Erdos number
    static void set_Erdos_number(String[] p_list, int num) {
        if (num == 0) return;
        for (int i = 0; i < p_list.length; i++) {
            for (int j = 0; j < ppl.size(); j++) {
                int er = ppl_Erdosnumber.get(j);
                if (p_list[i].equals(ppl.get(j)) && (er > num || er == 0)) {
                    ppl_Erdosnumber.set(j, num);
                }
            }
        }
    }
}
