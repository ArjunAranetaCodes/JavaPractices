/**
 * Tutorial: Builder Design Pattern
 * Demonstrates builder pattern
 */
class Computer {
    private String cpu;
    private String ram;
    private String storage;
    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }
    
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        
        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }
        
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
    
    @Override
    public String toString() {
        return "Computer{CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + "}";
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
            .cpu("Intel i7")
            .ram("16GB")
            .storage("512GB SSD")
            .build();
        
        System.out.println(computer);
    }
}










