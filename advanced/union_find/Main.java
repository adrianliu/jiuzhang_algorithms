package jiuzhang.advanced.union_find;

/**
 * Created by xiaopengliu on 6/04/16.
 */
public class Main {

    public static void main(String[] args) {

        QuickFindUF qf = new QuickFindUF(10);
        qf.union(0, 5);
        qf.union(5, 6);

        qf.union(1, 2);
        qf.union(2, 7);

        qf.union(3, 4);
        qf.union(3, 8);
        qf.union(4, 9);

        System.out.println(qf.connected(0,6));

    }
}
