import java.util.Scanner;

public class Operator {
    public static Scanner scn = new Scanner(System.in);
    private char op;
    private double val;

    public Operator(char op, double v) {
        switch (op) {
            case '+':
                this.op = op;
                break;
            case '*':
                this.op = op;
                break;
            default:
                System.out.println("Error operator " + op);
                this.op = 'x';
                break;
        }
        this.val = v;
    }

    public Operator(char op) {
        this.op = op;
        if (op == '+') {
            this.val = 0;
        } else if (op == '*') {
            this.val = 1;
        }
    }

    public Operator(Operator ref) {
        this.op = ref.op;
        this.val = ref.val;
    }

    public boolean isSame(Operator other) {
        return this.op == other.op;
    }

    public double calc (double a) {
        switch (this.op) {
            case '+':
                return a + this.val;
            case '*':
                return a * this.val;
            default:
                System.out.println("Error");
                return 0;
        }
    }

    public Operator combine(Operator other) {
        if (!this.isSame(other)) {
            System.out.println("Cannot Combine");
            return null;
        } else {
            return new Operator(this.op, calc(other.val));
        }
    }

    @Override
    public String toString() {
        return "a" + this.op + this.val;
    }
}
