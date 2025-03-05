// Package anschauen, Doku, Zertifikat

public class Test {

    int i;

    String s = "Hallo Welt";

    String s1;

    Test next;

    int x = 7;


    public void add(Test next) {
        this.next = next;
    }

    public static void main(String[] args) {

    }

    public Test(int i) {
        this.i = i;
    }

    public Test() {
        i = 0;
    }

    public void test() {
        System.out.println(i);
    }

    public void test(int i) {
        System.out.println(i);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(i);
    }
}