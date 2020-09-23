public class Process {
    private SomeService someService;
    public Process(SomeService s){
        this.someService=s;
    }

    public  String process(int a){
        String someNumber = someService.doSomething(a);
        return "Result = "+someNumber;
    }
}
