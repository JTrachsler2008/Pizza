// Package anschauen, Doku, Zertifikat

/**
 * The type Test.
 */
public class Test {

    /**
     * The .
     */
    int i;

    /**
     * The S.
     */
    String s = "Hallo Welt";

    /**
     * The S 1.
     */
    String s1;

    /**
     * The Next.
     */
    Test next;

    /**
     * The X.
     */
    int x = 7;


    /**
     * Add.
     *
     * @param next the next
     */
    public void add(Test next) {
        this.next = next;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    }

    /**
     * Instantiates a new Test.
     *
     * @param i the
     */
    public Test(int i) {
        this.i = i;
    }

    /**
     * Instantiates a new Test.
     */
    public Test() {
        i = 0;
    }

    /**
     * Test.
     */
    public void test() {
        System.out.println(i);
    }

    /**
     * Test.
     *
     * @param i the
     */
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