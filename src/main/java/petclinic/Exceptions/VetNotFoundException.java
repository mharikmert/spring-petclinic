package petclinic.Exceptions;

public class VetNotFoundException extends RuntimeException{
    public VetNotFoundException(String message){
        System.out.println(message);
    }
}
