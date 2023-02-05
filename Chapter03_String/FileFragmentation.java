/*
c22
생화학을 전공하는 한 친구가 컴퓨터 파일이 담긴 쟁반을 들고 가다가 실험실 바닥에 넘어졌는데 파일이 전부 바닥에 떨어져서 부서져 버렸다.
그 친구는 파일 조각을 전부 줍고 나서 당신에게 전화를 걸어서는 파일을 다시 원래대로 복구해달라고 요청했다.
쟁반에 있는 모든 파일은 전부 똑같았고 모두 정확하게 두 조각으로 부서졌으며 모든 파일 조각을 찾을 수 있었다는 점은 정말 다행이라고 할 수 있었다.
하지만 안타깝게도 파일이 전부 똑같은 위치에서 부서지지 않은 데다가 파일이 바닥에 떨어지면서 전부 뒤섞여 버리고 말았다.

원래의 이진 파일 조각은 ASCII 1과 0으로 이루어진 문자열로 변환된 상태다.
이제 당신은 파일에 원래 들어있던 비트 패턴을 알아내기 위한 프로그램을 만들어야 한다.

<입력>
첫 번째 줄에는 테스트 케이스 개수를 나타내는 양의 정수가 하나 들어있다.
그 다음 줄은 빈 줄이다.
서로 다른 테스트 케이스 사이에도 빈 줄이 들어간다.
그리고 각 케이스는 한 줄에 하나씩의 '파일 조각'을 나타내는 숫자들로 구성되며 파일 종료 문자 도는 빈 줄에 의해 종료된다.
각 파일 조각은 ASCII 문자 1과 0으로 이루어진 문자열로 구성된다.

<출력>
각 테스트 케이스에 대해 원래 파일의 비트 패턴을 나타내는 ASCII 문자 1과 0으로 구성된 문자열을 한 줄에 출력한다.
입력에 2N개의 조각이 있다면 이 조각들을 두 개씩 이어서 출력 문자열과 같은 문자열을 N개 만들 수 있어야 한다.
결과가 유일하지 않은 경우에는 그 중 어떤 것을 출력해도 상관없다.

친구의 말에 의하면 쟁반 위에 있었던 파일의 개수는 144개를 넘지 않으며 파일의 크기는 모두 256바이트보다 작았다고 한다.
두 개의 서로 다른 테스트 케이스에 대한 결과 사이에는 빈 줄 하나를 출력한다.

1

011
0111
01110
111
0111
10111


01110111
 */


package Chapter03_String;

import java.util.ArrayList;
import java.util.Scanner;

public class FileFragmentation {
    static ArrayList<String> file_piece;
    static int[] file_piece_max;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase_num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testcase_num; i++) {
            sc = new Scanner(System.in);
            file_piece = new ArrayList<>();
            while(sc.hasNext()) {
                file_piece.add(sc.next());
            }
            int file_piece_size = file_piece.size();
            file_piece_max = new int[file_piece_size];
            for (int j = 0; j < file_piece_size; j++) {
                file_piece_max[j] = (file_piece.get(j)).length();
            }
            int min = min();
            int max = max();
            int file_full_size = min + max;

            //작은 것 부터 총 합이 file_full_size가 되도록 탐색
            //원본 파일 차례대로 탐색 후 search_file()
            for (int j = 0; j < file_piece_size; j++) {
                if (file_piece_max[i] == min) {
                    
                }
            }

            sc.close();
        }


    }
    static void search_file(String original_file) {
        //원본을 받아 비교 및 탐색
    }
    static int min() {
        int min = 100000;
        for (int i = 0; i < file_piece_max.length; i++) {
            int num = file_piece_max[i];
            if (min > num) min = num;
        }
        return min;
    }
    static int max() {
        int max = -1;
        for (int i = 0; i < file_piece_max.length; i++) {
            int num = file_piece_max[i];
            if (max < num) max = num;
        }
        return max;
    }
}
