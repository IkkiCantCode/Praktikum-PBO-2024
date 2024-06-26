
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//Final
public final class App {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayList<PokemonConcrete> pokedex = new ArrayList<>();
        ArrayList<Trainer> trainers = new ArrayList<>();
        

        while (true) {
            System.out.println("""
                Pokemon & Trainer Information System
                ===================================
                ===== Pokemon =====
                1. Add Pokemon 
                2. View Pokedex
                3. Update Pokedex
                4. Release Pokemon
                ===== Trainer =====
                5. Add Trainer
                6. View Trainer
                7. Update Trainer
                8. Delete Trainer
                ===== Type Chart =====
                9. Type Chart
                ===== Exit =====
                0. Exit
                """);

            System.out.print("Select: ");
            String menu = br.readLine();

            if (menu.equals("1")) {
                addPokemon(pokedex);
            } else if (menu.equals("2")) {
                viewPokedex(pokedex);
            } else if (menu.equals("3")) {
                updatePokedex(pokedex, br);
            } else if (menu.equals("4")) {
                releasePokemon(pokedex, br);
            } else if (menu.equals("5")) {
                addTrainer(trainers, br);
            } else if (menu.equals("6")) {
                viewTrainers(trainers);
            } else if (menu.equals("7")) {
                updateTrainer(trainers, br);
            } else if (menu.equals("8")) {
                deleteTrainer(trainers, br);
            } else if (menu.equals("9")) {
                typeChart();
            } else if (menu.equals("0")) {
                System.out.println("Exiting Pokedex");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
    public static class PokemonConcrete extends Pokemon {
        public PokemonConcrete(int dexNumber, String name, String type1, String type2, String species, double height, double weight, String ability1, String ability2, String hiddenAbility, int hp, int attack, int defense, int spAttack, int spDefense, int speed, String regionName, int generation, String gameIntroduced) {
            super(dexNumber, name, type1, type2, species, height, weight, ability1, ability2, hiddenAbility, hp, attack, defense, spAttack, spDefense, speed, regionName, generation, gameIntroduced);
        }
    
        @Override
        public void displayPokemonStats() {
            System.out.println("Stats: ");
            System.out.println("HP: " + getHp());
            System.out.println("Attack: " + getAttack());
            System.out.println("Defense: " + getDefense());
            System.out.println("Special Attack: " + getSpAttack());
            System.out.println("Special Defense: " + getSpDefense());
            System.out.println("Speed: " + getSpeed());
            System.out.println("Total: " + getTotal());
        }
    }

    public static class TrainerConcrete extends Trainer {
        public TrainerConcrete(String name, int age, String gender, int money, String trainerClass, String trainerDesc, String regionName, int generation, String gameIntroduced) {
            super(name, age, gender, money, trainerClass, trainerDesc, regionName, generation, gameIntroduced);
        }
    
        @Override
        public void displayTrainerInfo() {
            System.out.println("Name : " + getName());
            System.out.println("Age : " + getAge());
            System.out.println("Money : $" + getMoney());
            System.out.println("Trainer Class : " + getTrainerClass());
            System.out.println("Trainer Description : " + getTrainerDesc());
        }
    }

    
    private static void addPokemon(ArrayList<PokemonConcrete> pokedex) throws IOException {
        System.out.println("=====Adding Pokemon to Pokedex=====");
        System.out.print("Region Name: ");
        String regionName = br.readLine();
        System.out.print("Generation: ");
        int generation = Integer.parseInt(br.readLine());
        System.out.print("Game Introduced: ");
        String gameIntroduced = br.readLine();
        int dexNumber;

        boolean dexExists;
        while (true) {
            System.out.print("Dex Number : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                dexNumber = Integer.parseInt(input);
                dexExists = false;
                int tempDexNumber = dexNumber; 
                for (Pokemon p : pokedex) {
                    if (p.getDexNumber() == tempDexNumber) {
                        dexExists = true;
                        break;
                    }
                }
                if (dexExists) {
                    System.out.println("Pokemon with the same Dex Number already exists");
                    continue;
                }
                break;
            } else {
                System.out.println("Invalid Dex Number");
            }
        }
        System.out.print("Name : ");
        String name = br.readLine();
        System.out.print("Primary Type : ");
        String type1 = br.readLine();
        System.out.print("Secondary Type (Press Enter if the Pokemon is Mono Type) : ");
        String type2 = br.readLine();
        System.out.print("Species : ");
        String species = br.readLine();
        double height;
        while (true) {
            System.out.print("Height : ");
            String input = br.readLine();
            if (input.matches("[0-9]+(\\.[0-9]+)?")) {
                height = Double.parseDouble(input);
                break;
            } else {
                System.out.println("Invalid Height");
            }
        }
        double weight;
        while (true) {
            System.out.print("Weight : ");
            String input = br.readLine();
            if (input.matches("[0-9]+(\\.[0-9]+)?")) {
                weight = Double.parseDouble(input);
                break;
            } else {
                System.out.println("Invalid Weight");
            }
        }
        System.out.print("Ability 1 : ");
        String ability1 = br.readLine();
        System.out.print("Ability 2 (Press Enter if the Pokemon only has 1 Ability) : ");
        String ability2 = br.readLine();
        System.out.print("Hidden Ability (Press Enter if the Pokemon doesn't have Hidden Ability) : ");
        String hiddenAbility = br.readLine();
        int hp, attack, defense, spAttack, spDefense, speed;
        while (true) {
            System.out.print("HP : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                hp = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid HP");
            }
        }
        while (true) {
            System.out.print("Attack : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                attack = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid Attack");
            }
        }
        while (true) {
            System.out.print("Defense : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                defense = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid Defense");
            }
        }
        while (true) {
            System.out.print("Special Attack : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                spAttack = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid Special Attack");
            }
        }
        while (true) {
            System.out.print("Special Defense : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                spDefense = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid Special Defense");
            }
        }
        while (true) {
            System.out.print("Speed : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                speed = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid Speed");
            }
        }
        PokemonConcrete newPokemon = new PokemonConcrete(dexNumber, name, type1, 
                                        type2, species, height, weight, ability1, 
                                        ability2, hiddenAbility, hp, attack, defense, 
                                        spAttack, spDefense, speed, regionName, generation, 
                                        gameIntroduced);
        pokedex.add(newPokemon);
        System.out.println("Pokemon added to the Pokedex successfully!");
    }

    private static void viewPokedex(ArrayList<PokemonConcrete> pokedex) {
        System.out.println("=====Viewing Pokedex=====");
        if (pokedex.isEmpty()) {
            System.out.println("Pokedex is empty");
        } else {
            for (int i = 0; i < pokedex.size(); i++) {
                System.out.println("Pokemon Number : " + (i + 1));
                pokedex.get(i).display();
            }
        }
    }

    private static void updatePokedex(ArrayList<PokemonConcrete> pokedex, BufferedReader br) throws IOException {
        if (pokedex.isEmpty()) {
            System.out.println("Pokedex is empty");
            return;
        }
    
        System.out.println("=====Updating Pokedex=====");
        viewPokedex(pokedex);
    
        System.out.print("Enter the Pokemon Number you want to update: ");
        int update = Integer.parseInt(br.readLine()) - 1;
    
        if (update < 0 || update >= pokedex.size()) {
            System.out.println("Invalid Pokemon Number");
            return;
        }
    
        Pokemon pokemonToUpdate = pokedex.get(update);
        System.out.println("Updating Pokemon Number " + (update + 1));
        
        System.out.println("Region Name: ");
        String regionName = br.readLine();
        System.out.println("Generation: ");
        int generation = Integer.parseInt(br.readLine());
        System.out.println("Game Introduced: ");
        String gameIntroduced = br.readLine();
        System.out.print("Dex Number : ");
        int dexNumber = Integer.parseInt(br.readLine());
        for (Pokemon pokemon : pokedex) {
            if (dexNumber == pokemon.getDexNumber() && pokemon != pokemonToUpdate) {
                System.out.println("Pokemon with the same Dex Number already exists");
                System.out.println("Please enter a different Dex Number");
                dexNumber = Integer.parseInt(br.readLine());
            }
        }
    
        System.out.print("Name : ");
        String name = br.readLine();
        System.out.print("Primary Type : ");
        String type1 = br.readLine();
        System.out.print("Secondary Type (Press Enter if the Pokemon is Mono Type) : ");
        String type2 = br.readLine();
        System.out.print("Species : ");
        String species = br.readLine();
        double height = readDoubleInput(br, "Height : ");
        double weight = readDoubleInput(br, "Weight : ");
        System.out.println("Ability 1 : ");
        String ability1 = br.readLine();
        System.out.println("Ability 2 (Press Enter if the Pokemon only has 1 Ability) : ");
        String ability2 = br.readLine();
        System.out.println("Hidden Ability (Press Enter if the Pokemon doesn't have Hidden Ability) : ");
        String hiddenAbility = br.readLine();
        int hp = readIntegerInput(br, "HP : ");
        int attack = readIntegerInput(br, "Attack : ");
        int defense = readIntegerInput(br, "Defense : ");
        int spAttack = readIntegerInput(br, "Special Attack : ");
        int spDefense = readIntegerInput(br, "Special Defense : ");
        int speed = readIntegerInput(br, "Speed : ");
    
        //Untuk mengupdate data pokemon
        pokemonToUpdate.setRegionName(regionName);
        pokemonToUpdate.setGeneration(generation);
        pokemonToUpdate.setGameIntroduced(gameIntroduced);
        pokemonToUpdate.setDexNumber(dexNumber);
        pokemonToUpdate.setName(name);
        pokemonToUpdate.setType1(type1);
        pokemonToUpdate.setType2(type2);
        pokemonToUpdate.setSpecies(species);
        pokemonToUpdate.setHeight(height);
        pokemonToUpdate.setWeight(weight);
        pokemonToUpdate.setAbility1(ability1);
        pokemonToUpdate.setAbility2(ability2);
        pokemonToUpdate.setHiddenAbility(hiddenAbility);
        pokemonToUpdate.setHp(hp);
        pokemonToUpdate.setAttack(attack);
        pokemonToUpdate.setDefense(defense);
        pokemonToUpdate.setSpAttack(spAttack);
        pokemonToUpdate.setSpDefense(spDefense);
        pokemonToUpdate.setSpeed(speed);
    
        System.out.println("Pokemon Number " + (update + 1) + " has been updated");
    }
    
    //Error Handling untuk input double dan integer
    private static double readDoubleInput(BufferedReader br, String prompt) throws IOException {
        double value;
        while (true) {
            System.out.print(prompt);
            String input = br.readLine();
            try {
                value = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
        return value;
    }
    
    private static int readIntegerInput(BufferedReader br, String prompt) throws IOException {
        int value;
        while (true) {
            System.out.print(prompt);
            String input = br.readLine();
            try {
                value = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }

    private static void releasePokemon(ArrayList<PokemonConcrete> pokedex, BufferedReader br) throws IOException {
        if (pokedex.isEmpty()) {
            System.out.println("Pokedex is empty");
            return;
        }
    
        System.out.println("=====Releasing Pokemon=====");
        viewPokedex(pokedex);
    
        System.out.print("Enter the Pokemon Number you want to release: ");
        int release = Integer.parseInt(br.readLine()) - 1;
    
        if (release < 0 || release >= pokedex.size()) {
            System.out.println("Invalid Pokemon Number");
            return;
        }
    
        System.out.println("Do you really want to release this pokemon? (Y/N)");
        String confirm = br.readLine();
        if (confirm.equalsIgnoreCase("Y")) {
            System.out.println("Pokemon Number " + (release + 1) + " has been released");
            pokedex.remove(release);
        } else {
            System.out.println("Pokemon Number " + (release + 1) + " has not been released");
        }
    }

    private static void addTrainer(ArrayList<Trainer> trainers, BufferedReader br) throws IOException {
        System.out.println("=====Adding Trainer=====");
        System.out.println("Trainer Home Region: ");
        String regionName = br.readLine();
        System.out.println("Trainer Generation: ");
        int generation = Integer.parseInt(br.readLine());
        System.out.println("Trainer Game Introduced: ");
        String gameIntroduced = br.readLine();
        System.out.print("Trainer Name: ");
        String name = br.readLine();
        System.out.print("Trainer Age: ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Trainer Gender: ");
        String gender = br.readLine();
        System.out.print("Trainer Money: ");
        int money = Integer.parseInt(br.readLine());
        System.out.print("Trainer Class: ");
        String trainerClass = br.readLine();
        System.out.print("Trainer Description: ");
        String trainerDesc = br.readLine();
    
        TrainerConcrete newTrainer = new TrainerConcrete(name, age, gender, money, trainerClass, 
                                trainerDesc, regionName, generation, gameIntroduced);
        trainers.add(newTrainer);
    }

    private static void viewTrainers(ArrayList<Trainer> trainers) {
        if (trainers.isEmpty()) {
            System.out.println("No trainers available");
            return;
        }
    
        System.out.println("=====Viewing Trainers=====");
        for (int i = 0; i < trainers.size(); i++) {
            System.out.println("Trainer Number: " + (i + 1));
            ((TrainerConcrete) trainers.get(i)).display();
        }
    }

    private static void updateTrainer(ArrayList<Trainer> trainers, BufferedReader br) throws IOException {
        if (trainers.isEmpty()) {
            System.out.println("No trainers available");
            return;
        }
    
        System.out.println("=====Updating Trainer=====");
        viewTrainers(trainers);
    
        System.out.print("Enter the Trainer Number you want to update: ");
        int update = Integer.parseInt(br.readLine()) - 1;
    
        if (update < 0 || update >= trainers.size()) {
            System.out.println("Invalid Trainer Number");
            return;
        }
    
        TrainerConcrete trainerToUpdate = (TrainerConcrete) trainers.get(update);
        System.out.println("Updating Trainer Number " + (update + 1));
    
        System.out.println("Trainer Home Region: ");
        trainerToUpdate.setRegionName(br.readLine());
        System.out.println("Trainer Generation: ");
        trainerToUpdate.setGeneration(Integer.parseInt(br.readLine()));
        System.out.println("Trainer Game Introduced: ");
        trainerToUpdate.setGameIntroduced(br.readLine());
        System.out.print("Trainer Name: ");
        trainerToUpdate.setName(br.readLine());
        System.out.print("Trainer Age: ");
        trainerToUpdate.setAge(Integer.parseInt(br.readLine()));
        System.out.print("Trainer Gender: ");
        trainerToUpdate.setGender(br.readLine());
        System.out.print("Trainer Money: ");
        trainerToUpdate.setMoney(Integer.parseInt(br.readLine()));
        System.out.print("Trainer Class: ");
        trainerToUpdate.setTrainerClass(br.readLine());
        System.out.print("Trainer Description: ");
        trainerToUpdate.setTrainerDesc(br.readLine());
    
        System.out.println("Trainer Number " + (update + 1) + " has been updated");
    }

    private static void deleteTrainer(ArrayList<Trainer> trainers, BufferedReader br) throws IOException {
        if (trainers.isEmpty()) {
            System.out.println("No trainers available");
            return;
        }
    
        System.out.println("=====Deleting Trainer=====");
        viewTrainers(trainers);
    
        System.out.print("Enter the Trainer Number you want to delete: ");
        int delete = Integer.parseInt(br.readLine()) - 1;
    
        if (delete < 0 || delete >= trainers.size()) {
            System.out.println("Invalid Trainer Number");
            return;
        }
    
        System.out.println("Do you really want to delete this trainer? (Y/N)");
        String confirm = br.readLine();
        if (confirm.equalsIgnoreCase("Y")) {
            System.out.println("Trainer Number " + (delete + 1) + " has been deleted");
            trainers.remove(delete);
        } else {
            System.out.println("Trainer Number " + (delete + 1) + " has not been deleted");
        }
    }

    //Final
    private static final void typeChart() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("""
                ===== Type Chart Menu =====
                1. Check Type Defenses
                2. View All Pokemon Types
                0. Exit
                ===========================
                """);

            System.out.print("Select: ");
            String menu = br.readLine();

            switch (menu) {
                case "1":
                    typeDefenses(br);
                    break;
                case "2":
                    viewTypes();
                    break;
                case "0":
                    System.out.println("Exiting Type Chart Menu");
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid option.");
            }
        }
    }
    
    private static void typeDefenses(BufferedReader br) throws IOException {
        System.out.println("===== Type Defenses =====");
        System.out.print("Enter Pokemon Type 1: ");
        String type1 = br.readLine();
        System.out.print("Enter Pokemon Type 2 (Press Enter if Mono Type): ");
        String type2 = br.readLine();
    
        if (type2.isEmpty()) {
            typeDefenses(type1);
        } else {
            typeDefenses(type1, type2);
        }
    }
    
    // Overloaded Method untuk pokemon memiliki 1 type
    private static void typeDefenses(String type1) {
        typeChart typeChart1 = getTypeChart(type1);
    
        if (typeChart1 == null) {
            System.out.println("Invalid Pokemon type.");
            return;
        }
    
        System.out.println("Type effectiveness for " + type1 + ":");
    
        System.out.println("Weaknesses: " + formatTypeEffectiveness(typeChart1.weaknesses));
        System.out.println("Resistances: " + formatTypeEffectiveness(typeChart1.resistances));
        System.out.println("Immunities: " + formatTypeEffectiveness(typeChart1.immunities));
    }
    
    // Overloaded Method untuk pokemon memiliki 2 type
    private static void typeDefenses(String type1, String type2) {
        typeChart typeChart1 = getTypeChart(type1);
        typeChart typeChart2 = getTypeChart(type2);
    
        if (typeChart1 == null && typeChart2 == null) {
            System.out.println("Invalid Pokemon types.");
            return;
        }
    
        System.out.println("Type effectiveness for " + type1 + " & " + type2 + ":");
    
        String[] combinedWeaknesses = combineArrays(
            typeChart1 != null ? typeChart1.weaknesses : new String[]{},
            typeChart2 != null ? typeChart2.weaknesses : new String[]{});
        String[] combinedResistances = combineArrays(
            typeChart1 != null ? typeChart1.resistances : new String[]{},
            typeChart2 != null ? typeChart2.resistances : new String[]{});
        String[] combinedImmunities = combineArrays(
            typeChart1 != null ? typeChart1.immunities : new String[]{},
            typeChart2 != null ? typeChart2.immunities : new String[]{});
    
        System.out.println("Weaknesses: " + formatTypeEffectiveness(combinedWeaknesses));
        System.out.println("Resistances: " + formatTypeEffectiveness(combinedResistances));
        System.out.println("Immunities: " + formatTypeEffectiveness(combinedImmunities));
    }

    private static typeChart getTypeChart(String type) {
        Types types = new Types();
        return types.getType(type);
    }

    private static String[] combineArrays(String[] array1, String[] array2) {
        String[] combinedArray = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, combinedArray, 0, array1.length);
        System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);
        return combinedArray;
    }

    private static String formatTypeEffectiveness(String[] types) {
        StringBuilder formattedTypes = new StringBuilder();
        for (String type : types) {
            if (formattedTypes.length() > 0) {
                formattedTypes.append(", ");
            }
            formattedTypes.append(type);
        }
        return formattedTypes.toString();
    
    }  

    private static void viewTypes() {
        System.out.println("=====Viewing All Pokemon Types=====");
        System.out.println("Normal, Fire, Water, Grass, Electric, Ice, Fighting, Poison, Ground, Flying, Psychic, Bug, Rock, Ghost, Dragon, Dark, Steel, Fairy");
        System.out.println("====================================");
    }
}
