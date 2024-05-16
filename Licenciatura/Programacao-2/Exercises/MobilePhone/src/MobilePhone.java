import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;

    // Lista de contatos associada ao telefone
    private ArrayList<Contact> myContacts;

    // Construtor que inicializa o número de telefone e a lista de contatos
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    // Adiciona um novo contato à lista de contatos
    public boolean addNewContact(Contact contact) {

        // Verifica se o contato já existe na lista com base no nome
        if (findContact(contact.getName()) >= 0) {
            // O contato já existe, portanto, não é adicionado novamente
            return false;
        }

        // Adiciona o contato à lista
        myContacts.add(contact);
        return true;
    }

    // Atualiza um contato existente na lista
    public boolean updateContact(Contact oldContact, Contact newContact) {

        // Encontra a posição do contato antigo na lista
        int foundPosition = findContact(oldContact);

        // Se o contato antigo não for encontrado, a atualização não é possível
        if (foundPosition < 0) {
            return false;
        }

        // Substitui o contato antigo pelo novo na lista
        this.myContacts.set(foundPosition, newContact);
        return true;
    }

    // Encontra a posição de um contato na lista com base no objeto Contact
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    // Encontra a posição de um contato na lista com base no nome do contato
    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                // Retorna a posição se o nome do contato for encontrado
                return i;
            }
        }
        // Retorna -1 se o nome do contato não for encontrado na lista
        return -1;
    }

    // Remove um contato da lista
    public boolean removeContact(Contact contact) {

        // Encontra a posição do contato na lista
        int foundPosition = findContact(contact);

        // Se o contato não for encontrado, a remoção não é possível
        if (foundPosition < 0) {
            return false;
        }

        // Remove o contato da lista
        this.myContacts.remove(foundPosition);
        return true;
    }

    // Consulta um contato com base no nome e retorna o objeto Contact correspondente
    public Contact queryContact(String name) {

        // Encontra a posição do contato com base no nome
        int position = findContact(name);

        // Se o contato for encontrado, retorna o objeto Contact
        if (position >= 0) {
            return this.myContacts.get(position);
        }

        // Se o contato não for encontrado, retorna null
        return null;
    }

    // Imprime a lista de contatos na saída padrão
    public void printContacts() {

        System.out.println("Contact List:");

        // Itera sobre a lista de contatos e imprime cada contato
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}


