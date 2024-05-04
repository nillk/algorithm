import java.util.Arrays;

public class TrieNode {

    // 알파벳 대문자를 저장하는 경우 각 노드는 26개의 자손을 가질 수 있음
    public static final int ALPHABETS = 26;
    // 주어진 문자를 [0, ALPHABETS - 1] 범위의 숫자로 변환
    // 알파벳 대문자가 아니라 소문자, 숫자 등으로 변경이 필요하다면 이 부분만 수정하면 Trie의 구현 그대로 사용 가능
    private int toNumber(char ch) {
        return ch - 'A';
    }

    TrieNode[] children;
    // 이 노드가 종료 노드인가
    boolean terminal;

    public TrieNode() {
        this.children = new TrieNode[ALPHABETS];
        this.terminal = false;
    }

    // 예제 코드에 destructor가 정의되어 있어서 그냥 작성
    public void finalize() throws Throwable {
        for (int i = 0; i < ALPHABETS; i++) {
            if (this.children[i] != null) {
                this.children[i] = null;
            }
        }
        super.finalize();
    }

    // 이 노드를 루트로 하는 트라이에 문자열 key 추가
    public void insert(char[] key) {
        // 문자열이 끝나면 terminal만 참으로 변경하고 종료
        if (key.length == 0) {
            this.terminal = true;
        } else {
            int next = toNumber(key[0]);
            // 해당 자식 노드가 없다면 생성
            if (this.children[next] == null) {
                this.children[next] = new TrieNode();
            }
            // 해당 자식 노드로 재귀 호출
            this.children[next].insert(Arrays.copyOfRange(key, 1, key.length));
        }
    }

    // 이 노드를 루트로 하는 트라이에 문자열 key와 대응되는 노드를 찾는다
    // 없으면 null 반환
    public TrieNode find(char[] key) {
        if (key.length == 0) return this;
        int next = toNumber(key[0]);
        if (this.children[next] == null) return null;
        return this.children[next].find(Arrays.copyOfRange(key, 1, key.length));
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        root.insert(new char[]{'B', 'E'});
        root.insert(new char[]{'B', 'E', 'T'});
        root.insert(new char[]{'B', 'U', 'S'});
        root.insert(new char[]{'T', 'E', 'N'});
        root.insert(new char[]{'T', 'E', 'A'});

        System.out.println(root.find(new char[]{'B', 'E'}));
    }
}
