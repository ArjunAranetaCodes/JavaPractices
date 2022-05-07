class Main {
    private String name;

    public Main(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Main other = (Main) obj;
        return this.name.equals(other.name);
    }

    public static void main(String[] args) {
        Main obj1 = new Main("John");
        Main obj2 = new Main("John");
        System.out.println("Objects are equal: " + obj1.equals(obj2));
    }
}
