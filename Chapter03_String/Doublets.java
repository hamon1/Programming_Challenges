/*
c23
딱 한 글자만 서로 다른 한 쌍의 단어를 더블릿이라고 부른다.
예를 들어 'booster'와 'rooster', 'rooster'와 'roaster', 'roaster'와 'roasted' 등은 모두 더블릿이다.

단어의 최대 길이는 16글자고 최대 25,143개의 단어(모두 소문자)가 들어있는 사전이 주어진다.
그리고 몇 쌍의 단어가 주어진다.
각 쌍의 단어에 대해 첫번째 단어로 시작해서 두번째 단어로 끝나고, 서로 인접한 각 단어 쌍이 더블릿인 가장 짧은 단어 시퀀스를 찾아라.
예를 들어 'booster'와 'roasted'라는 단어 쌍이 입력되면, 그리고 여기에 있는 단어들이 모두 사전에 들어있으면 'booster', 'rooster', 'roaster', 'roasted'라는 시퀀스가 답이 될 수 있다.

<입력>
입력 파일에는 사전과 몇 쌍의 단어가 들어있다.
사전은 몇 개의 단어로 구성되는데 한 줄에 한 단어씩 들어가며 사전이 끝나면 빈 줄이 한 개 입력된다.
그 다음 줄부터는 각 줄마다 한 쌍씩의 단어가 입력되며 한 줄에 있는 두 단어는 스페이스에 의해 구분된다.

<출력>
입력된 각 단어 쌍에 대해 첫번째 단어로 시작해서 두번쨰 단어로 끝나는 가장 짧은 단어 시퀀스를 한 줄에 한 단어씩 출력한다.
위 아래에 있는 두 단어는 더블릿이어야 한다.

가장 짧은 시퀀스가 여러 개 나오면 그 중 아무 시퀀스나 출력해도 된다.
답이 없으면 "No solution."이라고 출력한다.
각 케이스 사이에는 빈 줄을 하나씩 집어넣는다.

booster
rooster
roaster
coasted
roasted
coastal
postal

booster roasted
coastal postal


booster
rooster
roaster
roasted

No solution.
 */


package Chapter03_String;

public class Doublets {
}
