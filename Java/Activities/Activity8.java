package activities;

class CustomException extends Exception {
    private String message = null;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 {
    public static void main(String[] a){
        try {
            Activity8.exceptionTest("This will print to console");
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("This won't execute");
        } catch(CustomException msg) {
            System.out.println("Message inside catch block: " + msg.getMessage());
        }
    }
    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null or blank");
        } else {
            System.out.println(str);
        }
    }
}