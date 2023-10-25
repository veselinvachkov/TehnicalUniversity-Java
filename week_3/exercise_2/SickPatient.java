package TU_Java.week_3.exercise_2;

public class SickPatient extends Patient {
    private String dischargeSummary;
    private boolean isSick;
    private int dayOfIllness;

    public String getDischargeSummary() {
        return dischargeSummary;
    }

    public void setDischargeSummary(String dischargeSummary) {
        this.dischargeSummary = dischargeSummary;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public int getDayOfIllness() {
        return dayOfIllness;
    }

    public void setDayOfIllness(int dayOfIllness) {
        this.dayOfIllness = dayOfIllness;
    }


    public SickPatient(String name, String address, String egn, String dischargeSummary, boolean isSick, int dayOfIllness) {
        super(name, address, egn);
        this.dischargeSummary = dischargeSummary;
        this.isSick = isSick;
        this.dayOfIllness = dayOfIllness;
    }

    @Override
    public void cure(String medicine, int dosage) {
        dischargeSummary += "\nDrug: " + medicine + ", Dosage: " + dosage + " Mg";
    }
}
