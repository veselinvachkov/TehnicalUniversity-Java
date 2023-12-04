package TU_Java.SAA.Kursova_17;

public class BinaryTreeDuplicateValues {
    public static void main(String[] args) {
        // Пример за създаване на двоично дърво
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2); // Двата върха с еднакви стойности

        if (hasDuplicateValues(root)) {
            System.out.println("Дървото има поне два върха с еднакви стойности.");
        } else {
            System.out.println("Дървото няма два върха с еднакви стойности.");
        }
    }

    // Рекурсивна функция за проверка на дали в дървото има поне два върха с еднакви стойности
    private static boolean hasDuplicateValues(TreeNode root) {
        if (root == null) {
            return false;
        }

        // Проверка за еднакви стойности само в лявото и дясното поддърво на корена
        return root.left != null && root.right != null && root.left.value == root.right.value ||
                hasDuplicateValues(root.left) || hasDuplicateValues(root.right);
    }
}