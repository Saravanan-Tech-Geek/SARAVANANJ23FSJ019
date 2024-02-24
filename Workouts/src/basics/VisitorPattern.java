package basics;

import java.util.Scanner;

public class VisitorPattern {
	public static void main(String[] args) throws Exception {
		Dogi tiger = new Dogi();
		Childi baby = new Childi();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the item class name...:");
		String itemclass = scan.next();
		Item item = (Item) Class.forName(itemclass).newInstance();
		baby.playWithDog(tiger, item);

	}
}

class Childi {
	public void playWithDog(Dogi dog, Item item) {
		try {
			dog.play(item);
		} catch (DogExceptions dee) {
			dee.printStackTrace();
			dee.visit();
		}
	}
}

class Handler911 {
	public void handle(DogBiteException e) {
		System.out.println("bite is serious...take him to hospital....");
	}

	public void handle(DogBarkException d) {
		System.out.println("barking dogs seldom bite...no panic....");
	}

	public void handle(DogHappyException d) {
		System.out.println("barking dogs seldom bite...no panic....");
	}
}

class Dogi {
	public void play(Item item) throws DogExceptions {
		item.execute();
	}
}

abstract class Item {
	public abstract void execute() throws DogExceptions;
}

class StickItem extends Item {
	@Override
	public void execute() throws DogBiteException {
		throw new DogBiteException("you beat I bite....");
	}
}

class StoneItem extends Item {
	@Override
	public void execute() throws DogBarkException {
		throw new DogBarkException("you throw I run....");
	}
}

class Biscuit extends Item {
	@Override
	public void execute() throws DogHappyException {
		throw new DogHappyException("yummy yummy..i love biscuits...");
	}
}

abstract class DogExceptions extends Exception {
	public abstract void visit();
}

class DogHappyException extends DogExceptions {
	String msg;

	public DogHappyException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Exception is...:" + this.msg;
	}

	@Override
	public void visit() {
		new Handler911().handle(this);
	}
}

class DogBiteException extends DogExceptions {
	String msg;

	public DogBiteException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Exception..:" + this.msg;
	}

	@Override
	public void visit() {
		new Handler911().handle(this);
	}
}

class DogBarkException extends DogExceptions {
	String msg;

	public DogBarkException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Exception...:" + this.msg;
	}

	@Override
	public void visit() {
		new Handler911().handle(this);
	}
}
