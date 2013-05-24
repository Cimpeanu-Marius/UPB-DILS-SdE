

class Philosophe extends Thread {
    Baguette droit;
    Baguette gauche;

    public Philosophe(Baguette droit, Baguette gauche,String name) {
	this.droit=droit;
	this.gauche=gauche;
	setName(name);
    }
    public void run() 
    {
    	
    	while (true)
    	{
    	// prend la baguette de gauche
    	try {
			droit.prend();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// prend la baguette de droite
    	try {
			gauche.prend();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	manger();
    	// pose la baguette de gauche
    	try {
			droit.libere();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// pose la baguette de droite
    	try {
			gauche.libere();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			reflechir();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Réfléchit…
    	}
    }
    public synchronized void manger()
    {
    	System.out.println("filosof" +this.getName()+"mange");
    	try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public synchronized void reflechir() throws InterruptedException
    {
    	System.out.println("filosof" +this.getName()+" pense");
    	wait(1000);
    }
}
