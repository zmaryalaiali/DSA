package tree.binarytree.byarray;

public class BinaryTree<T> {
    T[] arr;
    int lastIndex;

    public BinaryTree(int size) {
        arr = (T[]) new Object[size + 1];
        lastIndex = 0;
        System.out.println("successfully created");
    }

    public boolean isFull() {
        return arr.length - 1 == lastIndex;
    }

    public void insertNote(T t) {
        if (isFull()) {
            System.out.println("Your tree are full");
            return;
        }
        arr[lastIndex + 1] = t;
        lastIndex++;
        System.out.println("your inserted a value of " + (String) t);
    }

    public void preorder(int index) {
        if (index > lastIndex)
            return;
        System.out.print(arr[index] + " ");
        preorder(index * 2);
        preorder(index * 2 + 1);
    }

    public void postorder(int index) {
        if (index > lastIndex)
            return;
        preorder(index * 2);
        preorder(index * 2 + 1);
        System.out.print(arr[index] + " ");

    }

    public void inorder(int index) {
        if (index > lastIndex)
            return;
        preorder(index * 2);
        System.out.print(arr[index] + " ");
        preorder(index * 2 + 1);
    }

    public void levelOrder(){
        for (int i = 1; i <=lastIndex; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public T search(T searchValue){
        for (int i = 1; i < lastIndex; i++) {
            if (searchValue == arr[i])
                return searchValue;
        }
        return null;
    }

    public void delete(T searchValue){
        int location = -1;
        for (int i = 1; i < lastIndex; i++) {
            if (searchValue == arr[i]){
                location  = i;
                break;
            }
        }
        if (location == -1){
            return;
        }
        arr[location] = arr[lastIndex];
        lastIndex--;
        System.out.println("deleted and location is "+location);
    }

    public void deleteAll(){
        try{
            arr = null;
            System.out.println("deleted ");
        }catch (Exception e){
            System.out.println("no deleted some occurred");
        }
    }
}
