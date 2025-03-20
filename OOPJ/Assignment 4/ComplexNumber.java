class ComplexNumber {
    private double real;
    private double imaginary;

    // Default constructor
    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    // Constructor to initialize only real part
    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    // Constructor to initialize both real and imaginary parts
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Method to multiply two complex numbers
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Method to display a complex number
    public void display() {
        System.out.println(this.real + " + " + this.imaginary + "i");
    }

    public static void main(String[] args) {
        // Creating two complex numbers: 3 + 2i and 4 - 2i
        ComplexNumber c1 = new ComplexNumber(3, 2);
        ComplexNumber c2 = new ComplexNumber(4, -2);

        // Adding the two complex numbers
        ComplexNumber sum = c1.add(c2);
        System.out.print("Sum: ");
        sum.display();

        // Multiplying the two complex numbers
        ComplexNumber product = c1.multiply(c2);
        System.out.print("Product: ");
        product.display();
    }
}
