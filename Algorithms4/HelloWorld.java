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
        int k=0;
        int x=0;
        List<Integer> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String arrString = in.next();

        String[] intStrArr = arrString.split(",");
        for(int i=0; i<intStrArr.length; i++){
            arr.add(Integer.parseInt(intStrArr[i]));
        }
        for(int idx=0; idx<arr.size(); idx++){
            System.out.println(arr.get(idx));
        }

        k = in.nextInt();
        x = in.nextInt();
        Solution s = new Solution();
        List<Integer> list = s.findClosedInt(arr,k,x);
        for(int j=0; j<list.size();j++){
            System.out.print(list.get(j));
            if(j!=list.size()-1)
                System.out.print(",");
        }
    }
 }