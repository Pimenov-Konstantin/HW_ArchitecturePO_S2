import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prizes:");
        Random random = ThreadLocalRandom.current();
        List<ItemGenerator> generatorList = new ArrayList<>();
        generatorList.add(new GemGenerator());
        generatorList.add(new GoldGenerator());
        generatorList.add(new ToyGenerator());
        generatorList.add(new HouseGenerator());
        generatorList.add(new NoPrizeGenerator());
        generatorList.add(new ColaGenerator());
        generatorList.add(new AutoGenerator());

        for (int i = 0; i < 10; i++) {
            int index = Math.abs(random.nextInt() % 2 == 0 ? 0 : 1);
            ItemGenerator itemGenerator = generatorList.get(index);
            itemGenerator.openReward();
        }
    }
}

abstract class ItemGenerator {
    public void openReward() {
        GameItem gameItem = createItem();
        gameItem.open();
    }

    public abstract GameItem createItem();
}

interface GameItem {
    void open();
}

class GoldGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new GoldReward();
    }
}

class GemGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new GemReward();
    }
}

class ToyGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new ToyReward();
    }
}

class HouseGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new HouseReward();
    }
}

class NoPrizeGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new NoPrizeReward();
    }
}

class ColaGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new ColaReward();
    }
}

class AutoGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new AutoReward();
    }
}

class GoldReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Gold");
    }
}

class GemReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Gem");
    }
}

class ToyReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Toy");
    }
}

class HouseReward implements GameItem {
    @Override
    public void open() {
        System.out.println("House");
    }
}

class NoPrizeReward implements GameItem {
    @Override
    public void open() {
        System.out.println("NoPrize");
    }
}

class ColaReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Cola");
    }
}

class AutoReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Auto");
    }
}