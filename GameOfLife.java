/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfLife;

import java.util.*;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author hp
 */
public class GameOfLife {

    static int[][] array1 = new int[10][10];
    static int[][] array2 = new int[10][10];

    static int[] neighborhood;
    static File inputFile = new File("array.txt");

    public static void main(String[] args) throws IOException {

        readFile();
        nextGeneration(10);

    }

    public static void readFile() throws IOException {
        Scanner arrayReader = new Scanner(inputFile);
        for (int row = 0; row < array1.length; row++) {
            for (int col = 0; col < array1.length; col++) {
                array1[row][col] = arrayReader.nextInt();
            }
        }
        for (int r = 0; r < array1.length; r++) {

            for (int c = 0; c < array1.length; c++) {
                System.out.print((array1[r][c]) + " ");
            }
            System.out.println();
        }
        arrayReader.close();
    }

    public static void nextGeneration(int i) throws IOException {
        for (int generation = 1; generation <= i; generation++) {

            for (int row = 0; row < array1.length; row++) {
                for (int col = 0; col < array1.length; col++) {
                    int neighbors = 0;
                    for (int neighborrow = row - 1; neighborrow <= row + 1; neighborrow++) {
                        for (int neighborcol = col - 1; neighborcol <= col + 1; neighborcol++) {
                            if (neighborrow >= 0 && neighborrow < array1.length && neighborcol >= 0 && neighborcol < array1.length) {

                                if (neighborrow != row || neighborcol != col) {
                                    if (array1[neighborrow][neighborcol] == 1) {
                                        neighbors++;
                                    }
                                }
                            }
                        }
                    }

                    DeadOrAlive(row, col, neighbors);
//This line is for testing                    
//   System.out.println("index "+row+" "+col+" "+"is"+array1[row][col]+ " and has " + neighbors + " neighbors so in array2 it is " + array2[row][col]);

                }
            }

            PrintBoard(generation);
            CopyBoard();
        }
    }

    public static void DeadOrAlive(int row, int col, int neighbors) {
        if ((array1[row][col] == 1 && neighbors < 2) || (array1[row][col] == 1 && neighbors > 3)) {
            array2[row][col] = 0;
        } else if (array1[row][col] == 0 && (neighbors == 3)) {
            array2[row][col] = 1;
        } else {
            array2[row][col] = array1[row][col];
        }
    }

    public static void PrintBoard(int generation) {
        System.out.println();
        System.out.println();
        System.out.println("Generation" + " " + generation);
        System.out.println("**************");
        for (int r = 0; r < array2.length; r++) {

            for (int c = 0; c < array2.length; c++) {
                System.out.print((array2[r][c]) + " ");
            }
            System.out.println();
        }
    }

    public static void CopyBoard() {
        for (int r = 0; r < array1.length; r++) {
            array1[r] = array2[r].clone();
        }
    }
}
