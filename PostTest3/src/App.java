
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        ArrayList<Trainer> trainers = new ArrayList<Trainer>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("""
                Pokedex Menu
                1. Add Pokemon 
                2. View Pokedex
                3. Update Pokedex
                4. Release Pokemon
                5. Add Trainer
                6. View Trainer
                7. Update Trainer
                8. Delete Trainer
                9. Type Chart
                0. Exit
                """);

            System.out.print("Select: ");
            String menu = br.readLine();

            int dexNumber = 0;
            double height = 0.0;
            double weight = 0.0;
            int hp = 0;
            int attack = 0;
            int defense = 0;
            int spAttack = 0;
            int spDefense = 0;
            int speed = 0;

            if (menu.equals("1")) {
                addPokemon(pokedex, br);
            } else if (menu.equals("2")) {
                viewPokedex(pokedex);
            } else if (menu.equals("3")) {
                updatePokedex(pokedex, br);
            } else if (menu.equals("4")) {
                releasePokemon(pokedex, br);
            } else if (menu.equals("5")) {
                addTrainer(trainers, br)
            } else if (menu.equals("6")) {
                viewTrainers(trainers);
            } else if (menu.equals("7")) {
                updateTrainer(trainers, br);
            } else if (menu.equals("8")) {
                deleteTrainer(trainers, br);
            } else if (menu.equals("9")) {
                typeChart();
            } else if (menu.equals("10")) {
                System.out.println("Exiting Pokedex");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private static void addPokemon(ArrayList<Pokemon> pokedex, BufferedReader br) throws IOException {
        System.out.println("=====Adding Pokemon to Pokedex=====");
        System.out.print("Region Name: ");
        String regionName = br.readLine();
        System.out.print("Generation: ");
        int generation = Integer.parseInt(br.readLine());
        System.out.print("Game Introduced: ");
        String gameIntroduced = br.readLine();
        int dexNumber;
        while (true) {
            System.out.print("Dex Number : ");
            String input = br.readLine();
            if (input.matches("\\d+")) {
                dexNumber = Integer.parseInt(input);
                boolean dexExists = pokedex.stream().anyMatch(p -> p.getDexNumber() == dexNumber);
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
        Pokemon newPokemon = new Pokemon(dexNumber, name, type1, type2, species,
                height, weight, ability1, ability2,
                hiddenAbility, hp, attack, defense, spAttack,
                spDefense, speed, regionName, generation, gameIntroduced);
        pokedex.add(newPokemon);
        System.out.println("Pokemon added to the Pokedex successfully!");
    }

    private static void viewPokedex(ArrayList<Pokemon> pokedex) {
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

    private static void updatePokedex(ArrayList<Pokemon> pokedex, BufferedReader br) throws IOException {
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
        String ability1 = br.readLine();
        String ability2 = br.readLine();
        String hiddenAbility = br.readLine();
        int hp = readIntegerInput(br, "HP : ");
        int attack = readIntegerInput(br, "Attack : ");
        int defense = readIntegerInput(br, "Defense : ");
        int spAttack = readIntegerInput(br, "Special Attack : ");
        int spDefense = readIntegerInput(br, "Special Defense : ");
        int speed = readIntegerInput(br, "Speed : ");
    
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

    private static void releasePokemon(ArrayList<Pokemon> pokedex, BufferedReader br) throws IOException {
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
    
        Trainer newTrainer = new Trainer(name, age, gender, money, trainerClass, trainerDesc, regionName, generation, gameIntroduced);
        trainers.add(newTrainer);
        System.out.println("Trainer added successfully!");
    }

    private static void viewTrainers(ArrayList<Trainer> trainers) {
        if (trainers.isEmpty()) {
            System.out.println("No trainers available");
            return;
        }
    
        System.out.println("=====Viewing Trainers=====");
        for (int i = 0; i < trainers.size(); i++) {
            System.out.println("Trainer Number: " + (i + 1));
            System.out.println(trainers.get(i));
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
    
        Trainer trainerToUpdate = trainers.get(update);
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


}