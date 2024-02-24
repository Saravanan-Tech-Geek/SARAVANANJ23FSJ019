package basics;

public class BuilderDemo2 {
	public static void main(String[] args) {
		Car car = new Car.Builder()
				.make("Toyota")
				.model("Camry")
//				.year(2023)
				.tires(2)
				.build();
		System.out.println(car);
	}
}

class Car {
	private String make;
	private String model;
	private int year;
	private int tires;

	public Car(Builder builder) {
		this.make = builder.make;
		this.model = builder.model;
		this.year = builder.year;
		this.tires = builder.tires;
	}

	public static class Builder {
		private String make;
		private String model;
		private int year;
		private int tires;

		public Builder make(String make) {
			this.make = make;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
			return this;
		}

		public Builder year(int year) {
			this.year = year;
			return this;
		}

		public Builder tires(int tires) {
			this.tires = tires;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	@Override
	public String toString() {
		return "Car contains" + ":" +this.make + ":" + this.model + ":" + this.year + ":" + this.tires;
	}
}