package com.problems;


import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
    public static void main(String[] args){
        int numQueen = 4;
        System.out.println(new _51_NQueens().solveNQueens(numQueen));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String >> result = new ArrayList<List<String>>();
        //nxn chess board
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';
            }
        }
        solve(result, chess, 0);
        return result;
    }

    private boolean valid(char[][] chess, int row, int col) {
        // check all cols
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //check 45 degree
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //check 135
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    /*
    private boolean valid2(char[][] chess, int row, int col){
        //check columns
        for(int i = 0; i < row; i++){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        //check 45 degree
        for(int j = col + 1; j < chess.length; j++){
        for(int i = row - 1; i >= 0; i--){

                if(chess[i][j] == 'Q'){
                    return false;
                }
            }
        }
        //check 135 degree
        for(int j = col - 1; j >= 0; j--){
        for(int i = row - 1; i >= 0; i--){

                if(chess[i][j] == 'Q'){
                    return false;
                }
            }
        }
        return true;
    }
    */
    private List<String> construct(char[][] chess){
        List<String> path = new ArrayList<>();
        for (char[] chars : chess) {
            path.add(new String(chars));
        }
        return path;
    }
    private void solve(List<List<String>> result, char[][] chess, int row){
        if(row == chess.length){
            result.add(construct(chess));
            return;
        }
        for(int col = 0; col < chess.length; col++){
            if(valid(chess, row, col)){
                chess[row][col] = 'Q';
                solve(result, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }
}
