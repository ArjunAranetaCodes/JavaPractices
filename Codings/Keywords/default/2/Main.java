class Sample {
    int num;
    Sample() {
        num = 10;
    }
}

class Main {
    public static void main(String[] args) {
        Sample obj = new Sample();
        System.out.println("Value of num: " + obj.num);
    }
}
