import algorithm.PageRankAlgebraic;
import algorithm.PageRankIterative;

import java.io.File;

public class EntryPoint {

    public static void main(String[] args) {
        //driver code
        //iterative PageRank
        new PageRankIterative(new File("E:\\Dev\\University\\numerical-methods-university-course\\Lab3\\resources\\config.txt"));

        //algebraic page rank
        new PageRankAlgebraic(new File("E:\\Dev\\University\\numerical-methods-university-course\\Lab3\\resources\\config.txt"));


    }

}
