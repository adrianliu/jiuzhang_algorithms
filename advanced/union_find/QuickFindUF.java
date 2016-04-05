package jiuzhang.advanced.union_find;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * Created by xiaopengliu on 6/04/16.
 */

//O(1) find but O(n^2) union
public class QuickFindUF {

    private int[] id; //id[i] is component id for object i

    public QuickFindUF(int N) {
        id = new int[N];
        for(int i = 0;i < N;i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0;i < id.length;i++) {
            if(id[i] == pid) {
                id[i] = qid;
            }
        }
    }


}
