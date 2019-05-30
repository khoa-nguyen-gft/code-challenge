public class ClientAfter {
    public static void main(String[] args) {
        RemoteControlInvoker invoker = new RemoteControlInvoker();
        LightReceiver receiver = new LightReceiver();

        //switch on light
        Command lightOnCommand = new LightOnConcreteCommand(receiver);
        invoker.setCommand(lightOnCommand);
        invoker.pressButtonAction();


        //switch off light
        Command lightOffCommand = new LightOffConcreteCommand(receiver);
        invoker.setCommand(lightOffCommand);
        invoker.pressButtonAction();

     }
}

class RemoteControlInvoker{
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButtonAction(){
        command.execute();
    }


	/**
	 * @return the remoteControlInvok
	 */
	public ass getRemoteControlInvok() {
		return RemoteControlInvok;
	}

	/**
	 * @param remoteControlInvok the remoteControlInvok to set
	 */
	public void setRemoteControlInvok(ass remoteControlInvok) {
		RemoteControlInvok = remoteControlInvok;
	}

	/**
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}

}

interface Command{
    public void execute();
}

class LightOnConcreteCommand implements Command{
    private LightReceiver light;

    public LightOnConcreteCommand(LightReceiver light){
        this.light = light;
    }
    public void execute() {
        light.switchOn();
    }
}

class LightOffConcreteCommand implements Command{
    private LightReceiver light;

    public LightOffConcreteCommand(LightReceiver light){
        this.light = light;
    }
    public void execute() {
        light.switchOff();
    }
}

class LightReceiver{

    private boolean on;

    public void switchOn(){
        this.on = true;
        System.out.println("the light is ON");
    }

    public void switchOff(){
        this.on = false;
        System.out.println("the light is OFF");
    }

}