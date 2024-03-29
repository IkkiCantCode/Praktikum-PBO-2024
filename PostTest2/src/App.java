
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Pokemon {
    //Private access modifier untuk membatasi akses ke class tersebut
    private int dexNumber;
    private String name;
    private String type1;
    private String type2;
    private String species;
    private double height;
    private double weight;
    private String ability1;
    private String ability2;
    private String hiddenAbility;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private int total = hp + attack + defense + spAttack + spDefense + speed;

    public Pokemon(int dexNumber, String name, String type1, String type2,
                    String species, double height, double weight, 
                    String ability1, String ability2, String hiddenAbility, 
                    int hp, int attack, int defense, int spAttack, int spDefense, 
                    int speed) {
        this.dexNumber = dexNumber;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.ability1 = ability1;
        this.ability2 = ability2;
        this.hiddenAbility = hiddenAbility;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
    }
    //Getter menggunakan access modifier public
    public int getDexNumber() {
        return dexNumber;
    }
    public String getName() {
        return name;
    }
    public String getType1() {
        return type1;
    }
    public String getType2() {
        return type2;
    }
    public String getSpecies() {
        return species;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public String getAbility1() {
        return ability1;
    }
    public String getAbility2() {
        return ability2;
    }
    public String getHiddenAbility() {
        return hiddenAbility;
    }
    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getSpAttack() {
        return spAttack;
    }
    public int getSpDefense() {
        return spDefense;
    }
    public int getSpeed() {
        return speed;
    }
    public int getTotal() {
        return total;
    }
    
    //Setter menggunakan access modifier public 
    public void setDexNumber(int dexNumber) {
        this.dexNumber = dexNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType1(String type1) {
        this.type1 = type1;
    }
    public void setType2(String type2) {
        this.type2 = type2;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }
    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }
    public void setHiddenAbility(String hiddenAbility) {
        this.hiddenAbility = hiddenAbility;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }
    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    void display() {
        total = hp + attack + defense + spAttack + spDefense + speed;
        System.out.println("========================================");
        System.out.println("Dex Number: " + dexNumber);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type1 + " " + type2);
        System.out.println("Species: " + species + " Pokemon");
        System.out.println("Height: " + height + " m");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Abilities: " + ability1 + " " + ability2);
        System.out.println("Hidden Ability: " + hiddenAbility);
        System.out.println("========================================");
        System.out.println("Stats: ");
        System.out.println("HP: " + hp);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Special Attack: " + spAttack);
        System.out.println("Special Defense: " + spDefense);
        System.out.println("Speed: " + speed);
        System.out.println("Total: " + total);
        System.out.println("========================================");
    }
}
class TypeChart {
    String type;
    String[] weaknesses;
    String[] resistances;
    String[] immunities;

    public TypeChart(String type, String[] weaknesses, String[] resistances, String[] immunities) {
        this.type = type;
        this.weaknesses = weaknesses;
        this.resistances = resistances;
        this.immunities = immunities;
    }

    public void display() {
        System.out.println("====================================");
        System.out.println("Weaknesses : " + format(weaknesses));
        System.out.println("====================================");
        System.out.println("Resistances : " + format(resistances));
        System.out.println("====================================");
        System.out.println("Immunities : " + format(immunities));
        System.out.println("====================================");

    }

    public String format(String[] list) {
        StringBuilder formatType =new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (i > 0) {
                formatType.append(", ");
            }
            formatType.append(list[i]);
        }
        return formatType.toString();
    }
}

class Types {
    TypeChart Normal = new TypeChart("Normal", new String[]{"Fighting"}, new String[]{}, new String[]{"Ghost"});
    TypeChart Fire = new TypeChart("Fire", new String[]{"Water", "Rock", "Ground"}, new String[]{"Fire", "Grass", "Ice", "Bug", "Steel", "Fairy"}, new String[]{});
    TypeChart Water = new TypeChart("Water", new String[]{"Electric", "Grass"}, new String[]{"Water", "Fire", "Ice", "Steel"}, new String[]{});
    TypeChart Grass = new TypeChart("Grass", new String[]{"Fire", "Ice", "Poison", "Flying", "Bug"}, new String[]{"Water", "Electric", "Grass", "Ground"}, new String[]{});
    TypeChart Electric = new TypeChart("Electric", new String[]{"Ground"}, new String[]{"Electric", "Flying", "Steel"}, new String[]{});
    TypeChart Ice = new TypeChart("Ice", new String[]{"Fire", "Fighting", "Rock", "Steel"}, new String[]{"Ice"}, new String[]{});
    TypeChart Fighting = new TypeChart("Fighting", new String[]{"Flying", "Psychic", "Fairy"}, new String[]{"Bug", "Rock", "Dark"}, new String[]{});
    TypeChart Poison = new TypeChart("Poison", new String[]{"Ground", "Psychic"}, new String[]{"Grass", "Fighting", "Poison", "Bug", "Fairy"}, new String[]{});
    TypeChart Ground = new TypeChart("Ground", new String[]{"Water", "Grass", "Ice"}, new String[]{"Poison", "Rock"}, new String[]{"Electric"});
    TypeChart Flying = new TypeChart("Flying", new String[]{"Electric", "Ice", "Rock"}, new String[]{"Grass", "Fighting ", "Bug"}, new String[]{"Ground"});
    TypeChart Psychic = new TypeChart("Psychic", new String[]{"Bug", "Ghost", "Dark"}, new String[]{"Fighting", "Psychic"}, new String[]{});
    TypeChart Bug = new TypeChart("Bug", new String[]{"Fire", "Flying", "Rock"}, new String[]{"Grass", "Fighting", "Ground"}, new String[]{});
    TypeChart Rock = new TypeChart("Rock", new String[]{"Water", "Grass", "Fighting", "Ground", "Steel"}, new String[]{"Normal", "Fire", "Poison", "Flying"}, new String[]{});
    TypeChart Ghost = new TypeChart("Ghost", new String[]{"Ghost", "Dark"}, new String[]{"Poison", "Bug"}, new String[]{"Normal", "Fighting"});
    TypeChart Dragon = new TypeChart("Dragon", new String[]{"Ice", "Dragon", "Fairy"}, new String[]{"Fire", "Water", "Electric", "Grass"}, new String[]{});
    TypeChart Dark = new TypeChart("Dark", new String[]{"Fighting", "Bug", "Fairy"}, new String[]{"Ghost", "Dark"}, new String[]{"Psychic"});
    TypeChart Steel = new TypeChart("Steel", new String[]{"Fire", "Fighting", "Ground"}, new String[]{"Normal", "Grass", "Ice", "Flying", "Psychic", "Bug", "Rock", "Dragon", "Steel", "Fairy"}, new String[]{"Poison"});
    TypeChart Fairy = new TypeChart("Fairy", new String[]{"Poison", "Steel"}, new String[]{"Fighting", "Bug", "Dark"}, new String[]{"Dragon"});

    public TypeChart getType(String type) {
        switch (type) {
            case "Normal":
                return Normal;
            case "Fire":
                return Fire;
            case "Water":
                return Water;
            case "Grass":
                return Grass;
            case "Electric":
                return Electric;
            case "Ice":
                return Ice;
            case "Fighting":
                return Fighting;
            case "Poison":
                return Poison;
            case "Ground":
                return Ground;
            case "Flying":
                return Flying;
            case "Psychic":
                return Psychic;
            case "Bug":
                return Bug;
            case "Rock":
                return Rock;
            case "Ghost":
                return Ghost;
            case "Dragon":
                return Dragon;
            case "Dark":
                return Dark;
            case "Steel":
                return Steel;
            case "Fairy":
                return Fairy;
            default:
                return null;
        }
    }
}

public class App {
    public static void main(String[] args) throws IOException{
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("""
                Pokedex Menu
                1. Add Pokemon 
                2. View Pokedex
                3. Update Pokedex
                4. Release Pokemon
                5. Type Chart
                6. Exit
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
                System.out.println("=====Adding Pokemon to Pokedex=====");
                System.out.println("Please fill all the information of your Pokemon");
                System.out.print("Dex Number : ");
                    if (pokedex.size() > 0) {
                        dexNumber = Integer.parseInt(br.readLine());
                        for (int i = 0; i < pokedex.size(); i++) {
                            if (dexNumber == pokedex.get(i).getDexNumber()) {
                                System.out.println("Pokemon with the same Dex Number already exists");
                                System.out.println("Please enter a different Dex Number");
                                dexNumber = Integer.parseInt(br.readLine());
                            }
                        }
                    } else {
                        while (true) {
                            String input = br.readLine();
                            if (input.matches("\\d+")) {
                                dexNumber = Integer.parseInt(input);
                                break;
                            } else {
                                System.out.println("Invalid Dex Number");
                                System.out.print("Dex Number : ");
                                continue; 
                            }
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
                System.out.print("Height : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("[0-9]+(\\.[0-9]+)?")) {
                            height = Double.parseDouble(input);
                            break;
                        } else {
                            System.out.println("Invalid Height");
                            System.out.print("Height : ");
                            continue;
                        }
                    }
                System.out.print("Weight : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("[0-9]+(\\.[0-9]+)?")) {
                            weight = Double.parseDouble(input);
                            break;
                        } else {
                            System.out.println("Invalid Weight");
                            System.out.print("Weight : ");
                            continue;
                        }
                    }
                System.out.print("Ability 1 : ");
                String ability1 = br.readLine();
                System.out.print("Ability 2 (Press Enter if the Pokemon only has 1 Ability) : ");
                String ability2 = br.readLine();
                System.out.print("Hidden Ability (Press Enter if the Pokemon doesn't have Hidden Ability) : ");
                String hiddenAbility = br.readLine();
                System.out.print("HP : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("\\d+")) {
                            hp = Integer.parseInt(input);
                            break;
                        } else {
                            System.out.println("Invalid HP");
                            System.out.print("HP : ");
                            continue;
                        }
                    }
                System.out.print("Attack : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("\\d+")) {
                            attack = Integer.parseInt(input);
                            break;
                        } else {
                            System.out.println("Invalid Attack");
                            System.out.print("Attack : ");
                            continue;
                        }
                    }
                System.out.print("Defense : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("\\d+")) {
                            defense = Integer.parseInt(input);
                            break;
                        } else {
                            System.out.println("Invalid Defense");
                            System.out.print("Defense : ");
                            continue;
                        }
                    }
                System.out.print("Special Attack : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("\\d+")) {
                            spAttack = Integer.parseInt(input);
                            break;
                        } else {
                            System.out.println("Invalid Special Attack");
                            System.out.print("Special Attack : ");
                            continue;
                        }
                    }
                System.out.print("Special Defense : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("\\d+")) {
                            spDefense = Integer.parseInt(input);
                            break;
                        } else {
                            System.out.println("Invalid Special Defense");
                            System.out.print("Special Defense : ");
                            continue;
                        }
                    }
                System.out.print("Speed : ");
                    while (true) {
                        String input = br.readLine();
                        if (input.matches("\\d+")) {
                            speed = Integer.parseInt(input);
                            break;
                        } else {
                            System.out.println("Invalid Speed");
                            System.out.print("Speed : ");
                            continue;
                        }
                    }

                Pokemon newPokemon = new Pokemon(dexNumber, name, type1, type2, species, 
                                                    height, weight, ability1, ability2, 
                                                    hiddenAbility, hp, attack, defense, spAttack, 
                                                    spDefense, speed);
                pokedex.add(newPokemon);

            } else if (menu.equals("2")) {
                if (pokedex.size() == 0) {
                    System.out.println("Pokedex is empty");
                
                } else {
                    System.out.println("Viewing Pokedex");
                    for (int i = 0; i < pokedex.size(); i++) {
                        System.out.println("Pokemon Number : " + (i + 1));
                        pokedex.get(i).display();
                    }
                }
            } else if (menu.equals("3")) {
                if (pokedex.size() == 0) {
                    System.out.println("Pokedex is empty");
                    
                } else {
                    System.out.println("=====Updating Pokedex=====");
                    for (int i = 0; i < pokedex.size(); i++) {
                        System.out.println("Pokemon Number : " + (i + 1));
                        pokedex.get(i).display();
                    }
                    System.out.print("Enter the Pokemon Number you want to update: ");
                    int update = Integer.parseInt(br.readLine()) - 1;

                    if (update >= 0 && update < pokedex.size()) {
                        System.out.println("Updating Pokemon Number " + (update + 1));
                        Pokemon pokemonToUpdate = pokedex.get(update);
            
                        System.out.println("Please fill all the information of your Pokemon");
                        System.out.print("Dex Number : ");
                            if (pokedex.size() > 0) {
                                dexNumber = Integer.parseInt(br.readLine());
                                for (int i = 0; i < pokedex.size(); i++) {
                                    if (dexNumber == pokedex.get(i).getDexNumber()) {
                                        System.out.println("Pokemon with the same Dex Number already exists");
                                        System.out.println("Please enter a different Dex Number");
                                        dexNumber = Integer.parseInt(br.readLine());
                                    }
                                }
                            } else {
                                while (true) {
                                    String input = br.readLine();
                                    if (input.matches("\\d+")) {
                                        dexNumber = Integer.parseInt(input);
                                        break;
                                    } else {
                                        System.out.println("Invalid Dex Number");
                                        System.out.print("Dex Number : ");
                                        continue; 
                                    }
                                }
                            }
                        pokemonToUpdate.setDexNumber(dexNumber);
                        System.out.print("Name : ");
                        pokemonToUpdate.setName(br.readLine());
                        System.out.print("Primary Type : ");
                        pokemonToUpdate.setType1(br.readLine());
                        System.out.print("Secondary Type (Press Enter if the Pokemon is Mono Type) : ");
                        pokemonToUpdate.setType2(br.readLine());
                        System.out.print("Species : ");
                        pokemonToUpdate.setSpecies(br.readLine());
                        System.out.print("Height : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("[0-9]+(\\.[0-9]+)?")) {
                                    height = Double.parseDouble(input);
                                    break;
                                } else {
                                    System.out.println("Invalid Height");
                                    System.out.print("Height : ");
                                    continue;
                                }
                            }
                        pokemonToUpdate.setHeight(height);
                        System.out.print("Weight : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("[0-9]+(\\.[0-9]+)?")) {
                                    weight = Double.parseDouble(input);
                                    break;
                                } else {
                                    System.out.println("Invalid Weight");
                                    System.out.print("Weight : ");
                                    continue;
                                }
                            }
                        pokemonToUpdate.setWeight(weight);
                        System.out.print("Ability 1 : ");
                        pokemonToUpdate.setAbility1(br.readLine());
                        System.out.print("Ability 2 (Press Enter if the Pokemon only has 1 Ability) : ");
                        pokemonToUpdate.setAbility2(br.readLine());
                        System.out.print("Hidden Ability (Press Enter if the Pokemon doesn't have Hidden Ability) : ");
                        pokemonToUpdate.setHiddenAbility(br.readLine());
                        System.out.print("HP : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("\\d+")) {
                                    hp = Integer.parseInt(input);
                                    break;
                                } else {
                                    System.out.println("Invalid HP");
                                    System.out.print("HP : ");
                                    continue;
                                }
                            }   
                        pokemonToUpdate.setHp(hp);
                        System.out.print("Attack : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("\\d+")) {
                                    attack = Integer.parseInt(input);
                                    break;
                                } else {
                                    System.out.println("Invalid Attack");
                                    System.out.print("Attack : ");
                                    continue;
                                }
                            }
                        pokemonToUpdate.setAttack(attack);
                        System.out.print("Defense : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("\\d+")) {
                                    defense = Integer.parseInt(input);
                                    break;
                                } else {
                                    System.out.println("Invalid Defense");
                                    System.out.print("Defense : ");
                                    continue;
                                }
                            }
                        pokemonToUpdate.setDefense(defense);
                        System.out.print("Special Attack : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("\\d+")) {
                                    spAttack = Integer.parseInt(input);
                                    break;
                                } else {
                                    System.out.println("Invalid Special Attack");
                                    System.out.print("Special Attack : ");
                                    continue;
                                }
                            }
                        pokemonToUpdate.setSpAttack(spAttack);
                        System.out.print("Special Defense : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("\\d+")) {
                                    spDefense = Integer.parseInt(input);
                                    break;
                                } else {
                                    System.out.println("Invalid Special Defense");
                                    System.out.print("Special Defense : ");
                                    continue;
                                }
                            }
                        pokemonToUpdate.setSpDefense(spDefense);
                        System.out.print("Speed : ");
                            while (true) {
                                String input = br.readLine();
                                if (input.matches("\\d+")) {
                                    speed = Integer.parseInt(input);
                                    break;
                                } else {
                                    System.out.println("Invalid Speed");
                                    System.out.print("Speed : ");
                                    continue;
                                }
                            }
                        pokemonToUpdate.setSpeed(speed);
            
                        System.out.println("Pokemon Number " + (update + 1) + " has been updated");
                        } else {
                            System.out.println("Pokemon Number" + (update + 1) + " did not exist");
                        }
                    }
                
            } else if (menu.equals("4")) {
                if (pokedex.size() == 0) {
                    System.out.println("Pokedex is empty");
                } else {
                    System.out.println("=====Releasing Pokemon=====");
                    for (int i = 0; i < pokedex.size(); i++) {
                        System.out.println("Pokemon Number : " + (i + 1));
                        pokedex.get(i).display();
                    }
                    System.out.print("Enter the Pokemon Number you want to release: ");
                    int release = Integer.parseInt(br.readLine()) - 1;
                    if (release >= 0 && release < pokedex.size()) {
                        System.out.println("Do you really want to release this pokemon? (Y/N)");
                        String confirm = br.readLine();
                        if (confirm.equals("Y")) {
                            System.out.println("Pokemon Number " + (release + 1) + " has been released");
                            pokedex.remove(release);
                        } else {
                            System.out.println("Pokemon Number " + (release + 1) + " has not been released");
                        }
                    } else {
                        System.out.println("Pokemon Number " + (release + 1) + " did not exist");
                    }
                }
            } else if (menu.equals("5")) {
                System.out.println("=====Type Chart=====");
                Types typeChart = new Types();
                System.out.println("Type List");
                System.out.println("Normal, Fire, Water, Grass, Electric, Ice, Fighting, Poison, Ground, Flying, Psychic, Bug, Rock, Ghost, Dragon, Dark, Steel, Fairy");
                System.out.print("Enter the Pokemon Type you want to check"); br.readLine(); 
                System.out.println("Primary Type :");
                String type1 = br.readLine();
                System.out.println("Secondary Type (Press Enter if the Pokemon is Mono Type) :");
                String type2 = br.readLine();
                TypeChart primaryType = typeChart.getType(type1);
                TypeChart secondaryType = typeChart.getType(type2);
                    if (type2.equals("")) {
                        System.out.println("Primary Type:");
                        primaryType.display();
                    } else if (primaryType != null && secondaryType != null){
                        System.out.println("Primary Type:");
                        primaryType.display();
                        System.out.println("Secondary Type:");
                        secondaryType.display();
                    } else {
                        System.out.println("Invalid Type");
                        continue;
                    }
                
            } else if (menu.equals("6")) {
                System.out.println("Exiting Pokedex");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}