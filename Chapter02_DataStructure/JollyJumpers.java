/*
n개의 정수(n>0)로 이루어진 수열에 대해 서로 인접해 있는 두 수의 차가 1에서 n-1까지의 값을 모두가지면 그 수열을 유쾌한 점퍼라고 부른다.
예를 들어 다음과 같은 수열에서
1 4 2 3
앞뒤에 있는 숫자 차의 절대 값이 각각 3, 2, 1이므로 이 수열은 유쾌한 점퍼가 된다.
이 정의에 따르면 정수 하나로 된 수열도 유쾌한 점퍼다.
어떤 수열이 유쾌한 점퍼인지 판단할 수 있는 프로그램을 작성하라.

<입력>
각 줄 맨 앞에는 3,000 이하의 정수가 있으며 그 뒤에는 수열을 나타내는 n개의 정수가 입력된다.

<출력>
입력된 각 줄에 대해 "Jolly" 또는 "Not jolly"를 한 줄씩 출력한다.

4 1 4 2 3
5 2 4 2 -1 6

Jolly
Not jolly
 */



package Chapter02_DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class JollyJumpers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while(sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                numbers.add(sc.nextInt());
            }
            boolean[] checkList = new boolean[n];

            search(numbers, checkList);
            if (check_jolly(checkList)) System.out.println("Jolly");
            else System.out.println("Not jolly");
        }
    }
    static void search(ArrayList<Integer> numbers, boolean[] checkList) {
        if (numbers.size() == 1) {
            checkList[1] = true;
            return;
        }
        int a = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int n = numbers.get(i);
            int k = absoluteValue(n, a);
            if (k >= checkList.length) return;
            checkList[k] = true;
            a = n;
        }
    }
    static boolean check_jolly (boolean[] checkList) {
        for (int i = 1; i < checkList.length; i++) {
            if (checkList[i] == false) return false;
        }
        return true;
    }
    static int absoluteValue(int a, int b) {
        int result = a - b;
        if (result > 0) return result;
        else return result*(-1);
    }
}
