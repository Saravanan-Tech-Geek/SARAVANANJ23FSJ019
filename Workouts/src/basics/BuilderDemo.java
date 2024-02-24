package basics;

public class BuilderDemo {
	public static void main(String[] args) {
		Computer mycomputer=new Computer.BuildComputer().
					buildCabinet("zebronics cabinet").
					buildMotherBoard("intel inside mental outside..").
					buildStorage("DDR Ram...").
					build();
		System.out.println(mycomputer);
	}
}
class Computer{
	String str[];
	public Computer(String ...s) {
		this.str=s;
	}
	static class BuildComputer{
		String cabinetDetails;String motherBoard;String storage;
		public BuildComputer buildCabinet(String cabinetDetails) {
			this.cabinetDetails=cabinetDetails;
			return this;
		}
		public BuildComputer buildMotherBoard(String motherBoardDetails) {
			this.motherBoard=motherBoardDetails;
			return this;
		}
		public BuildComputer buildStorage(String storageDetails) {
			this.storage=storageDetails;
			return this;
		}
		public Computer build() {
			return new Computer(this.cabinetDetails,this.motherBoard,this.storage);
		}	
	}
	
	@Override
	public String toString() {
		String computer="The computer is..:";
		for(String details:str) {
			computer=computer+":"+details;
		}
		return computer;
	}
}







