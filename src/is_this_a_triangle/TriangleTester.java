package is_this_a_triangle;

// ���������, �������� �� ������ �������������

public class TriangleTester {

    public static boolean isTriangle(int a, int b, int c) {
        if (a + b > c && a + c > b && c + b > a) {
            return true;
        } else {
            return false;
        }
    }
}
