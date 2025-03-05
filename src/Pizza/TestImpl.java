package Pizza;

public class TestImpl implements TestInterface {
    @Override
    public void print() {
        System.out.println("TestImpl");
    }

    @Override
    public int getPrice() {
        return 34;
    }

    @Override
    public void write() {
        System.out.println("write");
    }
}
