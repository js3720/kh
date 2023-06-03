import java.util.*;

public class BingoGameRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boardSize =0;

        while(true){
            System.out.print("빙고판 크기 지정 : ");
            boardSize = sc.nextInt();
            if(boardSize>1) break;
            else System.out.println("2 이상의 정수를 입력 해주세요.");
        }
        String [][] board = new String[boardSize][boardSize];
        Set<String> bingoNum = new HashSet<>();

        for(int i=0; i<board.length; i++){ // 빙고판 생성
            for(int j=0; j<board[0].length; j++){
                int random = (int)(Math.random()*(boardSize*boardSize)+1);
                if(bingoNum.contains(random+"")) j--;
                else{
                    board[i][j] = random+"";
                    bingoNum.add(board[i][j]);
                }
            }
        }
        System.out.println("=======================");
        for(String[] r : board){ // 빙고판 출력
            for(String i : r) System.out.print(i+"\t");
            System.out.println();
        }
        System.out.println("===== 빙고게임 시작 =====");

        while(true){
            int bingoCount = 0;
            int num = 0;
            while(true){
                System.out.print("정수를 입력하세요 : ");
                num = sc.nextInt();
                if(bingoNum.contains(num+"")) {
                    bingoNum.remove(num+"");
                    break;
                }
                else if(num<1 && num>(boardSize*boardSize)) System.out.println("빙고판에 없는 번호입니다, 다시 입력해주세요.");
                else System.out.println("이미 확인된 번호입니다, 다시 입력해주세요.");
            }
            int[] colCount = new int[boardSize]; // 행 빙고 판별용
            int[] rowCount = new int[boardSize]; // 열 빙고 판별용
            int diagonalCount1 = 0; // "\" 대각선 빙고 판별용
            int diagonalCount2 = 0; // "/" 대각선 빙고 판별용
            //현재 빙고판 상황
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j].equals(num+"")) board[i][j]="★"; // 숫자 일치하면 ★로 바꿔줌
                    System.out.print(board[i][j]+"\t");             // 현재 칸 문자 출력
                    if(board[i][j].equals("★")){
                        colCount[j]++;                                      // "ㅡ"
                        rowCount[i]++;                                      // "ㅣ"
                    }
                    if(i==j && board[i][j].equals("★")) diagonalCount1++;   // "\"
                }
                if(board[i][boardSize-i-1].equals("★")) diagonalCount2++;   // "/"
                System.out.println();
            }
            // 빙고 개수 확인
            for(int i : colCount) if(i==boardSize) bingoCount++;
            for(int i : rowCount) if(i==boardSize) bingoCount++;
            if(diagonalCount1==boardSize) bingoCount++;
            if(diagonalCount2==boardSize) bingoCount++;
            System.out.println("현재 "+bingoCount+"빙고");
            System.out.println("=======================");
            if(bingoCount>=3){
                System.out.println("***Bingo!!!!***");
                break;
            }
        }
    }
}
