public class DisjointSet {

    private final int[] parent;

    public DisjointSet(int n) {
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
    }

    public int find(int target) {
        if (target == this.parent[target]) {
            // target이 자신의 부모와 같다면 루트 노드라는 이야기이므로 자기 자신 반환
            return target;
        }

        // 재귀적으로 노드의 부모를 찾아 올라감
        return find(this.parent[target]);
    }

    public void union(int a, int b) {
        // find root node
        a = find(a);
        b = find(b);

        if (a == b) {
            // a와 b의 부모가 같다는 건 서로 같은 집합에 속해있다는 뜻이므로 아무 일도 하지 않고 반환
            return;
        }

        // a를 b의 서브 트리로 지정
        this.parent[a] = b;
    }
}
