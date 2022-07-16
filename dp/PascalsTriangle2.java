import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static  List<Integer> getRow(int rowIndex) {
        List<List<Integer>> l = new ArrayList<>();


        for(int i = 1; i<=rowIndex+1; i++)
        {
            List<Integer> t = new ArrayList<>();
            long c = 1;
            for(int j =1; j<= i; j++)
            {
                t.add((int)c);
                c = c * (i - j)/j;
            }
            l.add(new ArrayList<>(t));
        }
        return l.get(rowIndex);
    }
    public static void main(String []args)
    {
        System.out.println(getRow(30));
    }
}
