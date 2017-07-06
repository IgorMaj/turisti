package model;

public class Aktivan extends Stanje {

	
	//redefinise samo one metode koje mu trebaju a ostale prazne
	public Aktivan() {
		
	}

	public Aktivan(Termin termin) {
		super(termin);
	}
	
	@Override
	public void entry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aktivacijaTermina() {
		this.getTermin().setAktivan(true);
		
	}

	@Override
	public void deaktivacijaTermina() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rezervacijaTermina() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void otkazvanjeRezervacije() {
		// TODO Auto-generated method stub
		
	}

}
