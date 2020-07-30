public class ClassLoaderTest {
    public static void main(String[] Args){
        ClassLoader  classLoader=SingleTest.class.getClassLoader();
        System.out.print(""+classLoader.toString());
    }

}
