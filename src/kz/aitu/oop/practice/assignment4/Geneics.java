package kz.aitu.oop.practice.assignment4;

public class Geneics<T,U> {
    T o1;
    Geneics(T o1){
        this.o1 = o1;
    }

    public void print(){
        System.out.println(o1);
    }
}
