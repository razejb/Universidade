
public class Contact {
    private String name;
    private String phoneNumber;

    // Construtor que inicializa um objeto Contact com nome e número de telefone
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Método getter para obter o nome do contato
    public String getName() {
        return name;
    }

    // Método getter para obter o número de telefone do contato
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Método estático para criar um novo objeto Contact
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}
