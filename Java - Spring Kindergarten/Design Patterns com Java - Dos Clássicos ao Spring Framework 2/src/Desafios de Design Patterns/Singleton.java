import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager {
  
  // TODO: Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários

  private static UserManager managingInstance;
  
  private UserManager(){
    super();  
    }
  
  public static UserManager getInstance(){
      if (managingInstance == null){
        managingInstance = new UserManager();
      }
      return managingInstance;
    }

  private static final List<User> users = new ArrayList<>();
  
  public void addUser(int id, String name) {
        
    // TODO("Implementar a lógica de adicionar um novo usuário na lista mutável $users.")
    
    User newUser = new User(id, name);
    users.add(newUser);
  }

  public void listUsers() {

    //TODO("Implementar a impressão dos $users, seguindo o padrão definido no enunciado.")

    for (User user: users){
      System.out.println(user.getId() + " - " + user.getName());
    }
    
  }
  
}


public class Singleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager manager = UserManager.getInstance();

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            manager.addUser(i, name);
        }

        manager.listUsers();
    }
}
