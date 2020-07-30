public enum SingleTest {
    INSTANCE;
    int x=9;
    protected void print(){
        System.out.println("asd");
    }
    public static void main(String[] Args){
        SingleTest st=SingleTest.INSTANCE;
        st.print();

    }
}
