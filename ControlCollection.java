import javax.swing.*;
class ControlCollection{
	
	private WaterLevelObserver[] waterLevelObserverArray=new WaterLevelObserver[0];
	private int waterLevel;
	
	public void addwaterLevel(WaterLevelObserver waterLevel){
		extendsArray();
		waterLevelObserverArray[waterLevelObserverArray.length-1]=waterLevel;
		
		
	}
	
	private void extendsArray(){
		WaterLevelObserver[] tempArray=new WaterLevelObserver[waterLevelObserverArray.length+1];
		for (int i = 0; i < waterLevelObserverArray.length; i++){
			tempArray[i]=waterLevelObserverArray[i];
		}
		waterLevelObserverArray=tempArray;
	}
	
	public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
		for (WaterLevelObserver obs : waterLevelObserverArray) {
			obs.update(this.waterLevel);
    
		}
	}
	
	
	
}
