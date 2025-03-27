import java.util.*;
class TowerOfHanoi {
	/*n = number of disc
	s = source tower
	inter = 2nd tower
	d = destination tower*/
	
    static void toh(int n, char source, char inter, char dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + dest);
        } else {
        toh(n - 1, source, dest, inter);
        System.out.println("Disk " + n + " from " + source + " to " + dest);
        toh(n - 1, inter, source, dest);
		}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = sc.nextInt();
		sc.close();
        toh(n,'A','B','C');
    }
}

