class AdapterTestDrive {
	public static void main(String [] args) {
        Duck d = new Duck();
        d.quack();
        d.fly();

        Turkey t = new Turkey();
        t.gobble();
        t.hover();

        System.out.println(
            "-----------Now using BirdsFacade-----------");

        BirdsFacade f = new BirdsFacade(d,t);
        f.birdsFest();

        System.out.println(
            "-----------Now using TurkeyAdapter-----------");

        d = new TurkeyAdapter(t);
        d.quack();
        d.fly();

    }
}
