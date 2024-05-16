public class Person {

    private String firstName ;
    private String lastName ;
    private int age ;

    // Getters
    public String getFirstName(){
        return firstName ;
    }

    public String getLastName(){
        return lastName ;
    }

    public int getAge(){
        return age;
    }
    // Setters
    public void setFirstName(String setValueFirstName){
        this.firstName = setValueFirstName ;
    }

    public void setLastName(String setValueLastName){
        this.lastName = setValueLastName ;
    }

    public void setAge(int setValueAge){

        if(setValueAge < 0 || setValueAge > 100)
        {
            this.age = 0 ;
        }
        else
        {
            this.age = setValueAge ;
        }
    }

    public boolean isTeen(){
        if(age > 12 && age < 20)
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }


    public String getFullName(){

        if(firstName.isEmpty() && lastName.isEmpty())
        {
            return "" ;
        }
        else if(firstName.isEmpty())
        {
            return lastName ;
        }
        else if(lastName.isEmpty())
        {
            return firstName ;
        }
        else
        {
            return firstName + " " + lastName ;
        }
    }


    public static void main(String[] args) {

        Person person = new Person();
        person.setFirstName("");   // firstName is set to empty string
        person.setLastName("");    // lastName is set to empty string
        person.setAge(10);
        System.out.println("fullName= " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        person.setFirstName("John");    // firstName is set to John
        person.setAge(18);
        System.out.println("fullName= " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        person.setLastName("Smith");    // lastName is set to Smith
        System.out.println("fullName= " + person.getFullName());

    }
}