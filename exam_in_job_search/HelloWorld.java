class Person{
    private String name;
    private int age;
    private String sex;
    public Person(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void printPerson(){
        System.out.println("Name: "+ name);
        System.out.println("Age: "+ age);
        System.out.println("Sex: "+ sex);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

public class HelloWorld{
    public static void main(String[] args){
        List<Integer> arr = new ArrayList();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            arr.add(a);
        }
        int k = in.nextInt();
        int x= in.nextInt();

        Solution s = new Solution();
        s.findClosedInt(arr,k,x);
    }
 }