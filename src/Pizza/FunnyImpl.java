package Pizza;

public class FunnyImpl implements TestInterface {

    @Override
    public void print() {
        System.out.println("Funny");
    }

    @Override
    public int getPrice() {
        return 43;
    }

    @Override
    public void write() {
        System.out.println("Write");
    }
}
