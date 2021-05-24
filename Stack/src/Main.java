import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Stack
 */
class Stack {
    private int top;
    private int elements[];

    // initialize
    public Stack(int size) {
        this.top = -1;
        this.elements = new int[size];
    }

    // push X :: 정수 X를 스택에 넣는 연산이다.
    public void push(int e) {
        this.elements[++top] = e;
    }

    // pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public int pop() {
        if (top == -1) {
            return -1;
        }
        return this.elements[top--];
    }

    // size :: 스택에 들어있는 정수의 개수를 출력한다.
    public int size() {
        return this.top + 1;
    }

    // empty :: 스택이 비어있으면 1, 아니면 0을 출력한다.
    public int empty() {
        if (top == -1) {
            return 1;
        }
        return 0;
    }

    // top :: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public int top() {
        if (top == -1) {
            return -1;
        }
        return this.elements[top];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        String order = "";

        Stack stack = null;
        while ((n<1)||(n>10000)) {
            n = Integer.parseInt(br.readLine());
            if ((n>0)||(n<10001)) {
                stack = new Stack(n);
            }
        }

        for (int i = 0; i < n; i++) {

            order = br.readLine();

            if (order.contains("push")) {
                
                String split[] = order.split(" ");
                int e = Integer.parseInt(split[1]);
                
                stack.push(e);
            }
            if (order.contains("pop"))   bw.write(String.valueOf(stack.pop()) + "\n");
            if (order.contains("size"))  bw.write(String.valueOf(stack.size()) + "\n");
            if (order.contains("empty")) bw.write(String.valueOf(stack.empty()) + "\n");
            if (order.contains("top"))   bw.write(String.valueOf(stack.top()) + "\n");
        }
        
        bw.flush();
		bw.close();		
		br.close();
    }    
}
