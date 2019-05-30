public class App{
    public static void main(String[] args) {
        BankAccount newAccount = new BankAccount
        .BankAccountBuilder("Jon", "22738022275")
        .withEmail("jon@example.com")
        .wantNewsletter(true)
        .build();

        System.out.println(newAccount.toString());
    }
}

class BankAccount{
    private String name;
    private String accountNumber;
    private String email;
    private boolean newsletter;

    public static class BankAccountBuilder{
        private String name;
        private String accountNumber;
        private String email;
        private boolean newsletter;

        public BankAccountBuilder(String name, String accountNumber){
            this.name = name;
            this.accountNumber = accountNumber;
        }

        public BankAccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }
    
        public BankAccountBuilder wantNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public BankAccount build(){
            return new BankAccount(this);
        }
    
    }


    //Note that all the access modifiers on the fields are declared private 
    // since we don’t want outer objects to access them directly.

    //The constructor is also private so that only the Builder assigned to 
    // this class can access it. All of the properties set in the constructor are 
    // extracted from the builder object which we supply as an argument.
  
    private BankAccount(BankAccountBuilder bankBuilder) {
		super();
		this.name = bankBuilder.name;
        this.accountNumber = bankBuilder.accountNumber;
        this.email = bankBuilder.email;
		this.newsletter = bankBuilder.newsletter;
	}
    
    public String toString() {
    	return name +";" 
    			+ accountNumber + "; "
    			+ email+ "; "
    			+ newsletter;
    }


	private BankAccount() {
		super();
	}


	private String getName() {
		return name;
	}


    private void setName(String name) {
		this.name = name;
	}


    private String getAccountNumber() {
		return accountNumber;
	}


    private void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


    private String getEmail() {
		return email;
	}


    private void setEmail(String email) {
		this.email = email;
	}


    private boolean isNewsletter() {
		return newsletter;
	}


    private void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
} 