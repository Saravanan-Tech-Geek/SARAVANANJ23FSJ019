package basics;

public class CommandPatternDemo {

	public static void main(String[] args) {
		GoldenTouchMidasApp goldenApp = new GoldenTouchMidasApp();
		MarriageHall hall1 = new MarriageHall();
		Caters caterers1 = new Caters();
		FlowerWala flowerWala1 = new FlowerWala();
		ChairWala chairWala = new ChairWala();
		Command marriageCommand = new MarriageCommand(hall1, caterers1, flowerWala1, chairWala);
		goldenApp.setCommand(1, marriageCommand);

		Command birthDayCommand = new BirthdayCommand(hall1, caterers1, flowerWala1, chairWala);
		goldenApp.setCommand(2, birthDayCommand);
		
		goldenApp.executeCommand(1);
	}
}

class MarriageHall {
	public void ping(String details) {
		System.out.println("Got the details of marriage for hall" + details);
	}

	public void hallService() {
		System.out.println("hall service intiated for the customer");
	}
}

class Caters {
	public void ping(String details) {
		System.out.println("Got the details of marriage for caters" + details);
	}

	public void cateringService() {
		System.out.println("catering service intiated for the customer");
	}
}

class FlowerWala {
	public void ping(String details) {
		System.out.println("Got the details of marriage for flower decoration" + details);
	}

	public void flowerService() {
		System.out.println("flower decoration service intiated for the customer");
	}
}

class ChairWala {
	public void ping(String details) {
		System.out.println("Got the details of marriage.for chairs..:" + details);
	}

	public void chairService() {
		System.out.println("chair service initiated...for the customer.....");
	}
}

abstract class Command {
	MarriageHall marriageHall;
	Caters caters;
	FlowerWala flowers;
	ChairWala chairs;

	public Command() {
	}

	public Command(MarriageHall marriageHall, Caters caters, FlowerWala flowers, ChairWala chairs) {
		super();
		this.marriageHall = marriageHall;
		this.caters = caters;
		this.flowers = flowers;
		this.chairs = chairs;
	}

	public abstract void execute();

}

class MarriageCommand extends Command {
	public MarriageCommand(MarriageHall marriageHall, Caters caters, FlowerWala flowers, ChairWala chairs) {
		super(marriageHall, caters, flowers, chairs);
	}

	@Override
	public void execute() {
		System.out.println("Congrats...your marriage job initiated...Thankyou for approaching us...");
		marriageHall.ping("so and so getting married..");
		marriageHall.hallService();
		caters.ping("catering job initiated...");
		caters.cateringService();
		chairs.ping("chair wala service initiated...");
		chairs.chairService();
		System.out.println("all the marriage related services are going to call u ,,ur details are shared.. ");
	}

}

class BirthdayCommand extends Command {
	public BirthdayCommand(MarriageHall marriageHall, Caters caters, FlowerWala flowers, ChairWala chairs) {
		super(marriageHall, caters, flowers, chairs);
	}

	@Override
	public void execute() {
		System.out.println("Congrats...your birthday job initiated...Thankyou for approaching us...");
		marriageHall.ping("so and so getting birthday party celeberated..");
		marriageHall.hallService();
		caters.ping("catering job initiated...");
		caters.cateringService();
		chairs.ping("chair wala service initiated...");
		chairs.chairService();
		flowers.ping("flower service initiated...");
		flowers.flowerService();
		System.out.println("all the birthday related services are going to call u ,,ur details are shared.. ");
	}

}

class DummyCommand extends Command {
	@Override
	public void execute() {
		System.out.println("I am dummy yet to be operational....");
	}
}

class GoldenTouchMidasApp {
	Command command[] = new Command[5];

	public GoldenTouchMidasApp() {
		for (int i = 0; i < 5; i++) {
			command[i] = new DummyCommand();
		}
	}

	public void executeCommand(int slot) {
		command[slot].execute();
	}

	public void setCommand(int slot, Command command) {
		this.command[slot] = command;
	}
}
