public class ClassName {
    private static ClassName ourInstance = new ClassName();

    public static ClassName getInstance() {
        return ourInstance;
    }

    private ClassName() {
    }
}
