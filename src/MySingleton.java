class MySingleton {
    static MySingleton instance = null;
    public int x = 10;

    private MySingleton() {
    }

    static public MySingleton getInstance() {
        if (instance == null)
            instance = new MySingleton();
        return instance;
    }
}