package task4;

import java.util.function.Consumer;

class HeavyBox {
    private int weight;
    
    public HeavyBox(int weight) {
        this.weight = weight;
    }
    
    public int getWeight() {
        return weight;
    }
}

public class HeavyBoxExample {
    public static void main(String[] args) {
        Consumer<HeavyBox> ship = box -> 
            System.out.println("Отправляем ящик с весом " + box.getWeight());
        Consumer<HeavyBox> deliver = box -> 
            System.out.println("Отгрузили ящик с весом " + box.getWeight());
        
        Consumer<HeavyBox> combined = ship.andThen(deliver);
        
        HeavyBox box = new HeavyBox(50);
        combined.accept(box);
    }
}