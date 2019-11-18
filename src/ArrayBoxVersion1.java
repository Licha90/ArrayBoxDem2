public class ArrayBoxVersion1 {

    //属性 名字
    //需要一个最小的数组
    public int[] elementData = new int[10];
    public int size;//用户给出的有效元素个数

    //一个方法 检测给定的数组长度有没有比初始的长度大 如果大于初始数组长度就需要扩容 需要返回值
    private void ensureCapacity(int minCapacity){

        if (minCapacity > elementData.length){
            //需要扩容
        }
    }

    //一个方法用来扩容
    private void grow(int minCapacity){

        //需要获取旧数组的容量
        int oldCapacity = elementData.length;

        //为了减少内存的使用 先做一个算法 固定扩容
        int newCapacity =oldCapacity + oldCapacity >> 2;

        //如果还是不够 就直接赋值
        if (newCapacity < minCapacity){

            newCapacity = minCapacity;
        }

        //然后需要一个方法去把旧数组里面的元素搬到新数组里面去
        this.copyOf(elementData,minCapacity);
    }

    //一个方法 把旧数组里面的元素搬到新数组里去
    public int[] copyOf(int[] oldArray, int newCapacity){

        //首先需要一个新数组--newCapacity的容量 才能搬旧数组进去
        int newArray[]  = new int[newCapacity];

        //然后循环搬入
        for (int i = 0; i < oldArray.length; i++){

            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    //一个方法  检测index是否合法
    private void indexCheck(int index){

        if (index < 0 || index >= size){

        throw new Exception("index:"+ index +" size"+ size);

        }
    }

    //一个方法 删除数组中index对应的元素 然后返回元素
    //需要存储用户删除的元素 避免误操作
    private void removeElement(int index){

        //首先需要检测给定的元素是否合法
        this.indexCheck(index);

        //循环删除index对应的元素
        for (int i = index; i < size - 1; i++){

            elementData[i] = elementData[i +1];
        }

        elementData[--size] = 0;// elementData[size - 1] = 0 有效元素的最后一个元素 = 0
    }

    //ArrayBox里面add的方法
    public boolean add(int element){
        //需要一个方法来帮忙完成添加元素
        //首先需要确认用户给定的数组 需要一个方法去做
        this.ensureCapacity(size + 1);

        elementData[size++] = element;

        return true;
    }
}
