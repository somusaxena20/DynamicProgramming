import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();


        for(int i = 1; i<=numRows; i++)
        {
            List<Integer> t = new ArrayList<>();
            int c = 1;
            for(int j =1; j<= i; j++)
            {
                t.add(c);
                c = c * (i - j)/j;
            }
            l.add(new ArrayList<>(t));
        }
        return l;
    }
    public static void main(String []args)
    {
        System.out.println(generate(5));
    }
}
